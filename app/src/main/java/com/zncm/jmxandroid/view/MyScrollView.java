package com.zncm.jmxandroid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by jiaomx on 2017/7/17.
 */

public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (myScrollChangeListener != null) {
            myScrollChangeListener.onMyScrollChangeListener(l, t, oldl, oldt);
        }
    }


    private OnMyScrollChangeListener myScrollChangeListener;


    public interface OnMyScrollChangeListener {
        void onMyScrollChangeListener(int l, int t, int oldl, int oldt);
    }


    public void setMyScrollChangeListener(OnMyScrollChangeListener myScrollChangeListener) {
        this.myScrollChangeListener = myScrollChangeListener;
    }
}
