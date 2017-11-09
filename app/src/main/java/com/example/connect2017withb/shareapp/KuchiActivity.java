package com.example.connect2017withb.shareapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KuchiActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_kuchi);

            //deleteDatabase("NameAgeDB");

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

                    ContentValues insertValues = new ContentValues();
                    insertValues.put("name", name);
                    insertValues.put("kuchikomi", kuchikomi);
//                    insertValues.put("pic", bitmapdata);
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

            Button deleteAllButton = (Button) findViewById(R.id.btnAlldelete);
            deleteAllButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.delete("place", null, null);

                }
            });

            Button detaBaseButton = (Button) findViewById(R.id.btnShow);
            detaBaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Intent dbIntent = new Intent(com.example.connect2017withb.shareapp.KuchiActivity.this, ShowDataBaseK.class);
                  startActivity(dbIntent);
                }
            });

        }
}