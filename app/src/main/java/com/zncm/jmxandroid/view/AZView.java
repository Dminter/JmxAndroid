package com.zncm.jmxandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zncm.jmxandroid.utils.Xutils;

/**
 * Created by jiaomx on 2017/5/12.
 */

public class AZView extends View {
    private Paint paint;

    public AZView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStrokeWidth(5);
    }

    public AZView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AZView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i <26 ; i++) {
            char letter = (char) ('a'+i);
            Xutils.debug("letter::"+letter);
            canvas.drawText(letter+"",100,100,paint);
        }


    }
}
