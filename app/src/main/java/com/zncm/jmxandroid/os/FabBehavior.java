package com.zncm.jmxandroid.os;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.zncm.jmxandroid.utils.Xutils;

/**
 * Created by jiaomx on 2017/7/19.
 */

public class FabBehavior extends FloatingActionButton.Behavior {
    boolean isOut =false;
    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes== ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

        Xutils.debug("onNestedScroll::"+dyConsumed+" "+dyUnconsumed);

        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        // 而且向上的时候是出来，向下是隐藏

        if(dyConsumed > 0){
            if(!isOut) {
                // 往上滑动，是隐藏 , 加一个标志位 已经往下走了
                int translationY = ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).bottomMargin + child.getMeasuredHeight();
                child.animate().translationY(translationY).setDuration(500).start();
                isOut = true;
            }
        }else{
            if(isOut) {
                // 往下滑动
                child.animate().translationY(0).setDuration(500).start();
                isOut = false;
            }
        }
    }
}
