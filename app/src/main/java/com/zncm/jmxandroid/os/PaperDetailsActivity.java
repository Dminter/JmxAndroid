package com.zncm.jmxandroid.os;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.StatusBarUtils;

public class PaperDetailsActivity extends BaseAc {
    Activity ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;

        final Toolbar toolbar = (Toolbar) findViewById(R.id.mToolbar);
//        StatusBarUtils.setTranslucentImageHeader(ctx,0,toolbar);
        toolbar.setTitleTextColor(Color.TRANSPARENT);
        toolbar.inflateMenu(R.menu.menu_search);

        final CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.mCollapsingToolbarLayout);

        mCollapsingToolbarLayout.setTitle("");
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);


        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.mAppBarLayout);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()){
                    toolbar.setTitleTextColor(getResources().getColor(R.color.white));
                    mCollapsingToolbarLayout.setTitle("AppbarLayout");
                }else{
                    mCollapsingToolbarLayout.setTitle("");
                }
            }
        });

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_paperdetails;
    }
}
