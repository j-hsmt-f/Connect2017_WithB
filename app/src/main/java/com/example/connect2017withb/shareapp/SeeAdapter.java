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
 * Created by Administrator on 2017/11/11.
 */

public class SeeAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] mHueArray = {
            "fukei_mura", "リカチャン", "磐梯熱海温泉",
            "ふれあい科学館", "開成山公園","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞","阿武隈洞"
    };
    private Integer[] mHueIdArray = {
            R.drawable.fukei_mura,
            R.drawable.rikachan,
            R.drawable.bandaia,
            R.drawable.koriyama_hureai,
            R.drawable.kaiseizan_park,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
            R.drawable.abukumadou,
    };
    private static class ViewHolder {
        public ImageView hueImageView;
        public TextView  hueTextView;
    }

    public SeeAdapter(Context context) {
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

        SeeAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.grid_item_hue, null);
            holder = new SeeAdapter.ViewHolder();
            holder.hueImageView = (ImageView)convertView.findViewById(R.id.hue_imageview);
            holder.hueTextView = (TextView)convertView.findViewById(R.id.hue_textview);
            convertView.setTag(holder);
        } else {
            holder = (SeeAdapter.ViewHolder)convertView.getTag();
        }

        holder.hueImageView.setImageResource(mHueIdArray[position]);
        holder.hueTextView.setText(mHueArray[position]);

        return convertView;
    }
}
