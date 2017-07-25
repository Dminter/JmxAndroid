package com.zncm.jmxandroid.os;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.MyStatusBarUtils;
import com.zncm.jmxandroid.utils.Xutils;
import com.zncm.jmxandroid.view.MyScrollView;

public class BehaviorActivity extends BaseAc {
    Activity ctx;

    ImageView mImageView;
    MyScrollView mScrollView;
    int mImageViewHeight;
    int mToolBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ctx = this;


//        MyStatusBarUtils.setStatusBarColor(ctx,Color.GREEN);
        MyStatusBarUtils.setStatusBarTranslucent(ctx);

        mImageView = (ImageView) findViewById(R.id.mImageView);
        mScrollView = (MyScrollView) findViewById(R.id.mScrollView);

        mImageView.post(new Runnable() {
            @Override
            public void run() {
                mImageViewHeight = mImageView.getMeasuredHeight();
                Xutils.debug("mImageViewHeight::" + mImageViewHeight);
            }
        });


        toolbar.post(new Runnable() {
            @Override
            public void run() {
                mToolBarHeight =toolbar.getMeasuredHeight();
                Xutils.debug("mToolBarHeight=>"+mToolBarHeight);
            }
        });

//        mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//            }
//        });
        mScrollView.setMyScrollChangeListener(new MyScrollView.OnMyScrollChangeListener() {
            @Override
            public void onMyScrollChangeListener(int l, int t, int oldl, int oldt) {

                if (mImageViewHeight == 0) {
                    return;
                }
                float alpha =(float) t / (mImageViewHeight-mToolBarHeight);
                if (alpha > 1) {
                    alpha = 1;
                }
                if (alpha < 0) {
                    alpha = 0;
                }
//                Xutils.debug("alpha:" + alpha+" "+t +" - "+ (mImageViewHeight-mToolBarHeight));
                toolbar.getBackground().setAlpha((int) alpha * 255);

            }
        });


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_behavior;
    }
}
