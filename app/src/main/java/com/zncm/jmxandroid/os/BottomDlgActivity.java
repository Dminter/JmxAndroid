package com.zncm.jmxandroid.os;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

import java.util.ArrayList;

/**
 *android.support.design.widget  BottomSheetDialog
 */
public class BottomDlgActivity extends BaseAc {
    Context ctx;
    BottomSheetDialog bottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;

        findViewById(R.id.showBottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                showBottomDlg();


            }
        });

    }

    private void showBottomDlg() {

        bottomSheetDialog = new BottomSheetDialog(ctx);

        View view = LayoutInflater.from(ctx).inflate(R.layout.activity_bottomdlg_sheet1,null);
        initList(view);

        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.show();

    }

    private void initList(View view) {
        RecyclerView menuRecyclerView = (RecyclerView) view.findViewById(R.id.menuRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(ctx,LinearLayoutManager.VERTICAL,false);
        menuRecyclerView.setLayoutManager(manager);

        ArrayList<String> items = new ArrayList<>();
        items.add("编辑");
        items.add("删除");
        items.add("收藏");
        items.add("复制");
        items.add("笔记本");
        MyMenuAdapter adapter = new MyMenuAdapter(items);
        menuRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_bottomdlg;
    }
}
