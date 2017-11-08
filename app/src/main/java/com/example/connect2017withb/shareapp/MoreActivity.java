package com.example.connect2017withb.shareapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MoreActivity extends AppCompatActivity {

    private BaseAdapter adapter;

    // 名前
    private static final String[] name = {
            "いち",
            "に",
            "さん",
            "ちくわ大明神",
            "名前",
            "名前",
            "名前",
            "名前"
    };

    // 口コミ
    private static final String[] word = {
            "にゃんこ公園",
            "猪苗代湖",
            "TSUTAYA桑野店",
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
        setContentView(R.layout.more);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を more      // inflate するためにadapterに引数として渡す
        adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.list, name, word, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

    }
}
