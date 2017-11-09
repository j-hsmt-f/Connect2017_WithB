package com.example.connect2017withb.shareapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import java.net.*;

import java.io.*;
import static android.graphics.Bitmap.createScaledBitmap;

public class DBActivity extends Activity {

    public static Bitmap Pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        //deleteDatabase("NameAgeDB");

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText placeText = (EditText) findViewById(R.id.txtPlace);

        Button entryButton = (Button) findViewById(R.id.btnRegist);
        entryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = placeText.getText().toString();
                Spinner spinner = findViewById(R.id.cboCat);
                String item = (String)spinner.getSelectedItem();
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
                insertValues.put("category", item);
                insertValues.put("pic", bitmapdata);
                long id = db.insert("person", name, insertValues);
            }
        });

        Button deleteAllButton = (Button) findViewById(R.id.btnAlldelete);
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("person", null, null);

            }
        });

        Button detaBaseButton = (Button) findViewById(R.id.btnShow);
        detaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dbIntent = new Intent(com.example.connect2017withb.shareapp.DBActivity.this, ShowDataBase.class);
                startActivity(dbIntent);
            }
        });

        String spinnerItems[] = {"食べる", "遊ぶ", "観る", "学ぶ"};

        Spinner spinner = findViewById(R.id.cboCat);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        Button picButton = (Button) findViewById(R.id.btnFile);
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

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

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