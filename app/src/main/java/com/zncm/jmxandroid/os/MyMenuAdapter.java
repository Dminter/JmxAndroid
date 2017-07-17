package com.zncm.jmxandroid.os;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.utils.Xutils;

import java.util.ArrayList;

/**
 * Created by jiaomx on 2017/7/13.
 */

class MyMenuAdapter extends RecyclerView.Adapter<MyMenuAdapter.MyViewHolder> {

    public ArrayList<String> items = new ArrayList<>();

    public MyMenuAdapter(ArrayList<String> items) {
        this.items = items;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.textView.setText(items.get(i));
        myViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xutils.debug("textView-show::" + items.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;


        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
