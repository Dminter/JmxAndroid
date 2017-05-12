package com.zncm.jmxandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zncm.jmxandroid.utils.Xutils;

import java.util.ArrayList;

/**
 * Created by jiaomx on 2017/5/12.
 */

public class AZView extends View {
    ArrayList<String> letters = new ArrayList<>();
    private Paint paint;
    int deviceWidth = Xutils.getDeviceWidth();
    int deviceHeight = Xutils.getDeviceHeight();
    public AZView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setTextSize(Xutils.dip2px(16));
        for (int i = 0; i <26 ; i++) {
            char letter = (char) ('A'+i);
            letters.add(String.valueOf(letter));
        }
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

        Xutils.debug("onDraw------onDraw");



        for (int i = 0; i <letters.size() ; i++) {
            char letter = (char) ('A'+i);
            canvas.drawText(letter+"",deviceWidth-Xutils.dip2px(20),Xutils.dip2px(20)+deviceHeight*i/30,paint);
            Xutils.debug("letter::"+letter+" "+(Xutils.dip2px(20)+deviceHeight*i/30));
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                float fingerY = event.getY();
                int pos = (int) (Xutils.dip2px(20)-fingerY/(deviceHeight/letters.size()));
                Xutils.debug("fingerY::"+fingerY+" "+letters.get(pos));
                break;

        }

        return true;




    }
}
