package com.example.connect2017withb.shareapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MoreActivity extends AppCompatActivity {

    private BaseAdapter adapter;

    // 名前
    private static final String[] name = {
            "高橋",
            "渡邉",
            "橋本",
            "吉田",
            "矢内",
            "関根",
            "ぽむぽむ",
            "ぷりん"
    };

    // 口コミ
    private static final String[] word = {
            "職場の信条",
            "明朗な職場は朝夕の挨拶から",
            "計画を密にし、常に研鑽に努める",
            "責任と勇気と情熱を持って仕事にあたる",
            "性格迅速を信条とし品質の向上を図る",
            "交通事故の絶無を期する",
            "サンリオ",
            "ピューロランド"

    };

    // サムネイル
    private static final int[] photos = {
            R.drawable.pom,
            R.drawable.pom,
            R.drawable.pom,
            R.drawable.pom,
            R.drawable.pom,
            R.drawable.pom,
            R.drawable.pom,
            R.drawable.pom
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル more_list.xmlをinflate するためにadapterに引数として渡す
        adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.more_list, name, word, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        Button detaBaseButton = (Button) findViewById(R.id.btnShow);
        detaBaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dbIntent = new Intent(com.example.connect2017withb.shareapp.MoreActivity.this, ShowDataBase.class);
                startActivity(dbIntent);
            }
        });
    }
}
