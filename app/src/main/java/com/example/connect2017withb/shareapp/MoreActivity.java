package com.example.connect2017withb.shareapp;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Bitmap.createScaledBitmap;
import static com.example.connect2017withb.shareapp.R.id.titleText;

public class MoreActivity extends AppCompatActivity {

    private BaseAdapter adapter;

    // 名前
//    private static final String[] name = {
//            "高橋",
//            "渡邉",
//            "橋本",
//            "吉田",
//            "矢内",
//            "関根",
//            "ぽむぽむ",
//            "ぷりん"
//    };
//
//    // 口コミ
//    private static final String[] kuchikomi = {
//            "職場の信条",
//            "明朗な職場は朝夕の挨拶から",
//            "計画を密にし、常に研鑽に努める",
//            "責任と勇気と情熱を持って仕事にあたる",
//            "性格迅速を信条とし品質の向上を図る",
//            "交通事故の絶無を期する",
//            "サンリオ",
//            "ピューロランド"
//
//    };
//
//    // サムネイル
//    private static final int[] pic = {
//            R.drawable.pom,
//            R.drawable.pom,
//            R.drawable.pom,
//            R.drawable.pom,
//            R.drawable.pom,
//            R.drawable.pom,
//            R.drawable.pom,
//            R.drawable.pom
//    };

  ArrayList<String> name = new ArrayList<>();
  ArrayList<String> kuchikomi = new ArrayList<>();
  ArrayList<Bitmap> pic = new ArrayList<>();

    private String[] mHueArray = {
            "fukei_mura", "リカチャン", "磐梯熱海温泉",
            "郡山市ふれあい科学館", "開成山公園","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        MyOpenHelperK helper = new MyOpenHelperK(this);
        SQLiteDatabase db = helper.getReadableDatabase();
        // queryメソッドの実行例
        //DBのデータを取得
        Cursor c = db.query("kuchikomi", new String[] { "name", "kuchikomi", "pic" }, null,
                null, null, null, null);

        boolean mov = c.moveToFirst();

        //データぶん回す
        while (mov) {
            TextView textView = new TextView(this);
            //textView.setText(String.format("%s:%s ", c.getString(0), c.getString(1)));
            textView.setText("てすと");
            //名前取得
            name.add(c.getString(0));
            //口コミ取得
            kuchikomi.add(c.getString(1));
            ImageView imageView = new ImageView(this);
            Bitmap picture;
            //画像取得
            if (c.getBlob(2) != null) {
                //imageView.setImageBitmap(BitmapFactory.decodeByteArray(c.getBlob(2), 0, c.getBlob(2).length));
                picture = BitmapFactory.decodeByteArray(c.getBlob(2), 0, c.getBlob(2).length);
                picture = (createScaledBitmap(picture, 100, 100, false));
                imageView.setImageBitmap(picture);
                pic.add(picture);
            }
            mov = c.moveToNext();
            layout.addView(textView);
            //layout.addView(imageView);
        }
        c.close();
        db.close();

        Intent intent = getIntent();
        int gridPos = intent.getIntExtra("gridId", 0);

        setContentView(R.layout.more);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        listView.addView(layout);
        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル more_list.xmlをinflate するためにadapterに引数として渡す
        adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.more_list, name, kuchikomi, pic);

        // ListViewにadapterをセットlistView.addView(layout)
        listView.setAdapter(adapter);

        TextView title= (TextView)findViewById(titleText);
        title.setText(mHueArray[gridPos]);


        Button button = (Button) findViewById(R.id.button7);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {

            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), KuchiActivity.class);
                startActivity(intent);
            }
        });

    }
}
