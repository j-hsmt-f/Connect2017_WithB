package com.example.connect2017withb.shareapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView textView;
        TextView textView1;
        ImageView imageView;
    }

    private LayoutInflater inflater;
    private int itemLayoutId;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayList<String> titles1 = new ArrayList<String>();
    ArrayList<Bitmap> ids = new ArrayList<Bitmap>();

    ListViewAdapter(Context context, int itemLayoutId,
                    ArrayList<String> name, ArrayList<String> kuchikomi, ArrayList<Bitmap> pic) {
        super();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemLayoutId = itemLayoutId;
        this.titles = name;
        this.titles1 = kuchikomi;
        this.ids = pic;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        // 最初だけ View を inflate して、それを再利用する
        if (convertView == null) {
            // more.xml を inflate して convertView とする
            convertView = inflater.inflate(itemLayoutId, parent, false);
            // ViewHolder を生成
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            holder.textView1 = convertView.findViewById(R.id.textView1);
            holder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }
        // holder を使って再利用
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        // holder の imageView にセット
        holder.imageView.setImageResource(ids.indexOf(position));
        // 現在の position にあるファイル名リストを holder の textView にセット
        holder.textView.setText(titles.indexOf(position));
        holder.textView1.setText(titles1.indexOf(position));

        return convertView;
    }

    @Override
    public int getCount() {
        // texts 配列の要素数
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}