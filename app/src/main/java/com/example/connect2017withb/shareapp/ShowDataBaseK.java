package com.example.connect2017withb.shareapp;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ShowDataBaseK extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_database_k);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        MyOpenHelperK helper = new MyOpenHelperK(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        Cursor c = db.query("kuchikomi", new String[] { "name", "kuchikomi", "pic" }, null,
        null, null, null, null);

        boolean mov = c.moveToFirst();

        while (mov) {
            TextView textView = new TextView(this);
            textView.setText(String.format("%s:%s ", c.getString(0), c.getString(1)));
            ImageView imageView = new ImageView(this);
            if (c.getBlob(2) != null) {
                imageView.setImageBitmap(BitmapFactory.decodeByteArray(c.getBlob(2), 0, c.getBlob(2).length));
            }
            mov = c.moveToNext();
            layout.addView(textView);
            layout.addView(imageView);
        }
        c.close();
        db.close();
    }
}