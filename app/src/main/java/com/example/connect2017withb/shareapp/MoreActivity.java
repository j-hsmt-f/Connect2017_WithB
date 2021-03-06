package com.example.connect2017withb.shareapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

    private String[] seeList = {
            "fukei_mura", "リカチャン", "磐梯熱海温泉",
            "ふれあい科学館", "開成山公園","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞"
    };
    private String[] eatList= {
            "三万石", "柏屋", "かんの屋","エルマール","仁亭","萬壽園","大友パン","たらふく亭","佐藤珈琲"
    };

    private String[] playList = {
            "ふれあい科学館"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        int gridPos = intent.getIntExtra("gridId", 0);
        String tag = intent.getStringExtra("tag");

        setContentView(R.layout.more);

        // ListViewのインスタンスを生成
        ListView listView = findViewById(R.id.list_view);

        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル more_list.xmlをinflate するためにadapterに引数として渡す
        adapter = new ListViewAdapter(this.getApplicationContext(),
                R.layout.more_list, name, word, photos);

        // ListViewにadapterをセット
        listView.setAdapter(adapter);

        TextView title= (TextView)findViewById(R.id.titleText);
        switch (tag){
            case "see": title.setText(seeList[gridPos]); break;
            case "eat": title.setText(eatList[gridPos]); break;
            case "play": title.setText(playList[gridPos]); break;
            default:break;
        }


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
