package com.example.userprofile23_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.userprofile23_1.bean.Words;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Words> data;
    private Context context;

    public MyAdapter(List<Words> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        TextView textView = view.findViewById(R.id.collect_item);
        textView.setText(data.get(i).getWord() + "\n" + data.get(i).getTranslate());
        return view;
    }
}
