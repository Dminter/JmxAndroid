package com.zncm.jmxandroid.utils.common.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by jiaomx on 2017/7/12.
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private Context context;

    private List<T> items;

    public CommonAdapter(Context context, List<T> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if (items != null && items.size() > 0) {
            return items.size();
        } else {

            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (items != null && items.size() > 0) {
            return items.get(position);
        } else {

            return null;
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return convertView(position, convertView, parent);
    }

    protected abstract View convertView(int position, View convertView, ViewGroup parent);
}
