package com.example.connect2017withb.shareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jun_hasimoto on 2017/11/11.
 */

public class PlayAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private String[] mHueArray = {
            "ふれあい科学館"
    };
    private Integer[] mHueIdArray = {
            R.drawable.koriyama_hureai
    };
    private static class ViewHolder {
        public ImageView hueImageView;
        public TextView hueTextView;
    }

    public PlayAdapter(Context context) {
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

        PlayAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.grid_item_hue, null);
            holder = new PlayAdapter.ViewHolder();
            holder.hueImageView = (ImageView)convertView.findViewById(R.id.hue_imageview);
            holder.hueTextView = (TextView)convertView.findViewById(R.id.hue_textview);
            convertView.setTag(holder);
        } else {
            holder = (PlayAdapter.ViewHolder)convertView.getTag();
        }

        holder.hueImageView.setImageResource(mHueIdArray[position]);
        holder.hueTextView.setText(mHueArray[position]);

        return convertView;
    }
}