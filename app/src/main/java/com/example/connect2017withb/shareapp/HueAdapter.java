package com.example.connect2017withb.shareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Button;

/**
 * Created by Administrator on 2017/11/06.
 */

public class HueAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private String[] mHueArray = {
            "三万石", "柏屋", "かんの屋","エルマール","仁亭","萬壽園","大友パン","たらふく亭","佐藤珈琲"
    };
    private Integer[] mHueIdArray = {
            R.drawable.sanmangoku,
            R.drawable.kashiwaya,
            R.drawable.kanoya,
            R.drawable.erumaru,
            R.drawable.jintei,
            R.drawable.manjuen,
            R.drawable.otomopan,
            R.drawable.tarahukutei,
            R.drawable.satocoffee
    };
    private static class ViewHolder {
        public ImageView hueImageView;
        public TextView  hueTextView;
    }

    public HueAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return mHueArray.length;
    }

    public Object getItem(int position) {
        return mHueArray[position];
    }

    public long getItemId(int position) {
        return position;
    }




    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.grid_item_hue, null);
            holder = new ViewHolder();
            holder.hueImageView = (ImageView)convertView.findViewById(R.id.hue_imageview);
            holder.hueTextView = (TextView)convertView.findViewById(R.id.hue_textview);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.hueImageView.setImageResource(mHueIdArray[position]);
        holder.hueTextView.setText(mHueArray[position]);

        return convertView;
    }
}