package com.zncm.jmxandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.zncm.jmxandroid.utils.Xutils;

public class BezierTestView extends View {
    private int screenWidth;
    private Paint mPaint;
    private Path mPath;
    //两个距离的差越小角的高越小
    //最大距离 距离顶端 第一个顶点y
    private int first_y = 60;
    //第一个顶点x
    private int first_x = 0;
    //角的大小宽
    private int horn_size = 50;
    //最小距离距离顶端
    private int minimum_distance = 20;

    public int getMinimum_distance() {
        return minimum_distance;
    }

    public void setMinimum_distance(int minimum_distance) {
        this.minimum_distance = minimum_distance;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getFirst_x() {
        return first_x;
    }

    public int getFirst_y() {
        return first_y;
    }

    public void setFirst_x(int first_x) {
        this.first_x = first_x;
    }

    public void setFirst_y(int first_y) {
        this.first_y = first_y;
    }

    public int getHorn_size() {
        return horn_size;
    }

    public void setHorn_size(int horn_size) {
        this.horn_size = horn_size;
    }

    public BezierTestView(Context context) {
        super(context);
        init();
    }

    public BezierTestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public BezierTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //画笔
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(0xFF412129);
        mPath = new Path();
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        this.screenWidth = wm.getDefaultDisplay().getWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
//        mPath.moveTo(0,90);
//        //mPath.lineTo(0,0);
//        mPath.lineTo(100,50);
//        mPath.lineTo(100*2,90);
//        mPath.lineTo(100*3,50);
//        mPath.lineTo(100*4,90);
//        mPath.lineTo(100*5,50);

        mPath.moveTo(first_x, first_y);
        //mPath.lineTo(50,10);
        for (int i = 1; i <= screenWidth / horn_size; i++) {
            //y前一个大角后一个小
            /**
             *float x, float y
             * 50 _ 20
             100 _ 60
             150 _ 20
             200 _ 60
             250 _ 20
             300 _ 60
             350 _ 20
             400 _ 60
             */
            Xutils.debug(((i * horn_size) + first_x) + " _ " + (i % 2 == 0 ? first_y : minimum_distance));
            mPath.lineTo((i * horn_size) + first_x, i % 2 == 0 ? first_y : minimum_distance);
        }


        mPath.moveTo(first_x, 200 - first_y);
        for (int i = 1; i <= screenWidth / horn_size; i++) {
            mPath.lineTo((i * horn_size) + first_x, 200 - (i % 2 == 0 ? first_y : minimum_distance));
        }

        canvas.drawPath(mPath, mPaint);
    }
}