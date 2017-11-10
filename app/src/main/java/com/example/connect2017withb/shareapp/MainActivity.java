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

        TextView hue_tv= (TextView)findViewById(R.id.text);
        hue_tv.setClickable(true);
        hue_tv.setOnClickListener(new View.OnClickListener() {

            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MoreActivity.class);
                startActivity(intent);
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
