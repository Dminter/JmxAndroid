package com.zncm.jmxandroid.view;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jiaomx on 2017/5/8.
 */

public class BubbleView extends View {

    private AnimatorSet animatorSet;
    private Paint paint;

    public BubbleView(Context context) {
        super(context);
        init();
    }

    private void init() {

        animatorSet = new AnimatorSet();
        initPaint();

    }

    private void initPaint() {
        paint = new Paint();
        paint.setStrokeWidth(5);
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BubbleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


}
