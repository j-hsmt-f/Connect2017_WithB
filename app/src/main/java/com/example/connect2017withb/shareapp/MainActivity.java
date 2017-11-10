package com.example.connect2017withb.shareapp;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView fukei_mura;
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new HueAdapter(this));

        Button button = (Button) findViewById(R.id.button7);
        // ボタンに OnClickListener インターフェースを実装する
        button.setOnClickListener(new View.OnClickListener() {

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
            }
        });

        gridView.setAdapter(new HueAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // クリック時に呼ばれるメソッド
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent = new Intent(getApplicationContext(), MoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
