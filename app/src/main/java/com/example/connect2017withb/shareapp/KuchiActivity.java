package com.example.connect2017withb.shareapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;

import static android.graphics.Bitmap.createScaledBitmap;

public class KuchiActivity extends Activity {

    public static Bitmap Pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuchi);

        //deleteDatabase("KuchikomiDB");

        MyOpenHelperK helper = new MyOpenHelperK(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        final EditText txtKuchi = (EditText) findViewById(R.id.txtKuchi);

        Button entryButton = (Button) findViewById(R.id.btnEntry);
        entryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String kuchikomi = txtKuchi.getText().toString();
                byte[] bitmapdata;

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                if (Pic != null) {

                    Pic.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    bitmapdata = stream.toByteArray();

                } else {
                    bitmapdata = null;
                }

                ContentValues insertValues = new ContentValues();
                insertValues.put("name", name);
                insertValues.put("kuchikomi", kuchikomi);
                insertValues.put("pic", bitmapdata);
                long id = db.insert("kuchikomi", name, insertValues);

                AlertDialog.Builder alert = new AlertDialog.Builder(KuchiActivity.this);
                alert.setTitle("口コミ投稿");
                alert.setMessage("投稿が完了しました！");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                alert.show();

            }
        });

        Button deleteAllButton = (Button) findViewById(R.id.btnAlldeleteK);
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("kuchikomi", null, null);

            }
        });

        Button detaBaseButton = (Button) findViewById(R.id.btnShowK);
        detaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent dbIntent = new Intent(com.example.connect2017withb.shareapp.KuchiActivity.this, ShowDataBaseK.class);
              startActivity(dbIntent);
            }
        });

        Button picButton = (Button) findViewById(R.id.btnPic);
        picButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, 1001);
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {

        ImageView imageView = (ImageView)findViewById(R.id.imageView2);

        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {

            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                try {
                    Bitmap bmp = getBitmapFromUri(uri);
                    Pic = bmp;
                    Bitmap bmp2 = createScaledBitmap(bmp, 200, 200, false);
                    imageView.setImageBitmap(bmp2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
}