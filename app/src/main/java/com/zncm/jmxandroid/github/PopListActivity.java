package com.zncm.jmxandroid.github;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.github.view.PopupList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PopListActivity extends BaseAc {
    Context ctx;

    RecyclerView popRecyclerView;
    ArrayList<String> list;
    List<String> popupMenuItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;


        TextView popList = (TextView) findViewById(R.id.popList);
        popRecyclerView = (RecyclerView) findViewById(R.id.popRecyclerView);


        popupMenuItemList.add("复制");
        popupMenuItemList.add("转发");
        popupMenuItemList.add("删除");


        new PopupList(this).bind(popList, popupMenuItemList, new PopupList.PopupListListener() {
            @Override
            public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                return true;
            }

            @Override
            public void onPopupListClick(View contextView, int contextPosition, int position) {
                Toast.makeText(ctx, contextPosition + "," + position, Toast.LENGTH_SHORT).show();
            }
        });


        popRecyclerView.setHasFixedSize(true);
        popRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        list = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            list.add(new Random().nextLong() + "");
        }

        popRecyclerView.setAdapter(new MyAdapter(list));

    }



    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public ArrayList<String>  datas = null;
        public MyAdapter(ArrayList<String> datas) {
            this.datas = datas;
        }
        //创建新View，被LayoutManager所调用
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_item,viewGroup,false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }
        //将数据与界面进行绑定的操作
        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
            viewHolder.mTextView.setText(datas.get(position));
            viewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new PopupList(ctx).bind(v, popupMenuItemList, new PopupList.PopupListListener() {
                        @Override
                        public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                            return true;
                        }

                        @Override
                        public void onPopupListClick(View contextView, int contextPosition, int pos) {
                            Toast.makeText(ctx, contextPosition + "," + pos+" , "+position+" "+viewHolder.mTextView.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });
        }
        //获取数据的数量
        @Override
        public int getItemCount() {
            return datas.size();
        }
        //自定义的ViewHolder，持有每个Item的的所有界面元素
         class ViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView;
            public ViewHolder(View view){
                super(view);
                mTextView = (TextView) view.findViewById(R.id.textView);
            }
        }
    }
    @Override
    protected int getLayoutResource() {
        return R.layout.activity_poplist;
    }
}
