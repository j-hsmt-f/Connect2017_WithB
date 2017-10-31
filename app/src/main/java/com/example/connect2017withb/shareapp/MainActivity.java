package com.example.connect2017withb.shareapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private BaseAdapter adapter;

    // 場所名
    private static final String[] place = {
            "にゃんこ公園",
            "場所名",
            "場所名",
            "ちくわ大明神",
            "場所名",
            "場所名",
            "場所名",
            "場所名"

    };

    // サムネイル
    private static final int[] photos = {
            R.drawable.fukei_mura,
            R.drawable.fukei_mura,
            R.drawable.fukei_mura,
            R.drawable.fukei_mura,
            R.drawable.fukei_mura,
            R.drawable.fukei_mura,
            R.drawable.fukei_mura,
            R.drawable.fukei_mura
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に
        // inflate するためにadapterに引数として渡す
        adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, place, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

    }
}
