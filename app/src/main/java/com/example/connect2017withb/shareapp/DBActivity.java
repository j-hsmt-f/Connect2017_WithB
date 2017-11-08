package com.example.connect2017withb.shareapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import java.net.*;

import java.io.*;

public class DBActivity extends AppCompatActivity {

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

                ContentValues insertValues = new ContentValues();
                insertValues.put("name", name);
                insertValues.put("category", item);
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

//            FileListDialog dlg = new FileListDialog(this);
//            dlg.setOnFileListDialogListener((FileListDialog.onFileListDialogListener) this);
//            dlg.show( "/", "/");
//
//            Button picButton = (Button) findViewById(R.id.btnFile);
//            picButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                    intent.setType("file/*");
//                    startActivityForResult(intent, CHOSE_FILE_CODE);
//                }
//
//            });


    }
//    private final static int CHOSE_FILE_CODE = 12345;
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 12345 && resultCode == RESULT_OK) {
//            String filePath = data.getDataString().replace("file://", "");
////            String decodedfilePath = URLDecoder.decode(filePath, "utf-8");
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setMessage(filePath);
//            builder.show();
//        }
//    }

}