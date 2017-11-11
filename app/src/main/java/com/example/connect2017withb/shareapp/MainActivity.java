package com.example.connect2017withb.shareapp;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;

import static com.example.connect2017withb.shareapp.R.id.floatingActionButton;

public class MainActivity extends AppCompatActivity {

    private String e_tag = "eat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* アニメーション無効化 */
        overridePendingTransition(0, 0);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new HueAdapter(this));

        FloatingActionButton fButton = (FloatingActionButton) findViewById(floatingActionButton);
        // ボタンに OnClickListener インターフェースを実装する
        fButton.setOnClickListener(new View.OnClickListener() {

            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DBActivity.class);
                startActivity(intent);
            }
        });

        Button taberuButton = (Button) findViewById(R.id.button);
        // ボタンに OnClickListener インターフェースを実装する
        taberuButton.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                TextView hue_tv= (TextView)findViewById(R.id.text);
                hue_tv.setText("食べる");
                e_tag = "eat";
                GridView gridView = (GridView) findViewById(R.id.gridview);
                gridView.setAdapter(new HueAdapter(getApplicationContext()));

//              Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//              startActivity(intent);
            }
        });

        Button asobuButton = (Button) findViewById(R.id.button4);
        // ボタンに OnClickListener インターフェースを実装する
        asobuButton.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                TextView hue_tv= (TextView)findViewById(R.id.text);
                hue_tv.setText("遊ぶ");
                e_tag = "play";
                GridView gridView = (GridView) findViewById(R.id.gridview);
                gridView.setAdapter(new PlayAdapter(getApplicationContext()));
            }
        });
        Button miruButton = (Button) findViewById(R.id.button5);
        // ボタンに OnClickListener インターフェースを実装する
        miruButton.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                TextView hue_tv= (TextView)findViewById(R.id.text);
                hue_tv.setText("観る");
                e_tag = "see";
//              Intent intent = new Intent(getApplicationContext(), SightseeingActivity.class);
//              startActivity(intent);

                GridView gridView = (GridView) findViewById(R.id.gridview);
                gridView.setAdapter(new SeeAdapter(getApplicationContext()));

            }
        });


        Button tomaruButton = (Button) findViewById(R.id.button6);
        // ボタンに OnClickListener インターフェースを実装する
        tomaruButton.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                TextView hue_tv= (TextView)findViewById(R.id.text);
                hue_tv.setText("泊まる");
                e_tag = "stop";
            }
        });

        gridView.setAdapter(new HueAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // クリック時に呼ばれるメソッド
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getApplicationContext(), MoreActivity.class);
                intent.putExtra("gridId", position);
                intent.putExtra("tag", e_tag);
                startActivity(intent);
            }
        });
    }
}
