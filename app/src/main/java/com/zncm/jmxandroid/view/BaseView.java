package com.zncm.jmxandroid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/5/8.
 */

public class BaseView extends View {
    private Paint paint;

    public BaseView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStrokeWidth(5);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);                          //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);                       //设置画笔为空心
        paint.setStrokeWidth((float) 2.0);             //设置线宽
        canvas.drawColor(Color.WHITE);


        canvas.drawRect(100, 100, 200, 600, paint);         //绘制矩形
        canvas.drawRect(300, 100, 400, 600, paint);         //绘制矩形

        /**
         *@NonNull String text, float x, float y, @NonNull Paint paint
         */
        paint.setTextSize(20);
        canvas.drawText("你好啊", 200, 200, paint);

        /**
         *float cx, float cy, float radius, @NonNull Paint paint
         */
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        canvas.drawCircle(210, 210, 100, paint);
        canvas.drawCircle(210, 210, 50, paint);

        /**
         *float startX, float startY, float stopX, float stopY, @NonNull Paint paint
         */
        canvas.drawLine(100, 100, 400, 100, paint);
        canvas.drawLine(100, 100, 100, 400, paint);
        paint.setColor(Color.YELLOW);
        canvas.drawLine(100, 100, 200, 300, paint);
        paint.setColor(Color.DKGRAY);
        canvas.drawLine(100, 100, 300, 300, paint);


        /**
         *float left, float top, float right, float bottom
         */
        RectF rectF1 = new RectF(100, 100, 400, 400);
        canvas.drawRect(rectF1, paint);
        paint.setColor(Color.BLUE);
        RectF rectF2 = new RectF(200, 200, 400, 400);
        canvas.drawRect(rectF2, paint);

        /**
         *@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter,
         @NonNull Paint paint
         */
        paint.setColor(Color.YELLOW);
        RectF rectF3 = new RectF(100, 400, 400, 500);
//        canvas.drawRect(rectF3,paint);
        canvas.drawArc(rectF3, 180, 180, true, paint);


        /**
         *@NonNull RectF oval, @NonNull Paint paint
         */
        RectF rectF4 = new RectF(100, 500, 600, 600);
        canvas.drawOval(rectF4, paint);


        /**
         *float x0, float y0, float x1, float y1, int colors[], float positions[],
         TileMode tile
         */
//        Shader shader = new LinearGradient(0,0,100,100,new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
//                Color.LTGRAY},null, Shader.TileMode.REPEAT);
//        paint.setShader(shader);
//
//        RectF rectF5 = new RectF(100,600,700,700);
//        canvas.drawOval(rectF5,paint);


        /**
         *扇形
         */
        paint.setColor(Color.BLACK);
        RectF oval2 = new RectF(60, 100, 200, 240);// 设置个新的长方形，扫描测量
        canvas.drawArc(oval2, 270, 90, true, paint);
        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧线
        //画椭圆，把oval改一下
        oval2.set(210, 100, 250, 130);
        canvas.drawOval(oval2, paint);

        Path path  = new Path();
        /**
         *float x, float y
         */
        path.moveTo(80, 200);// 此点为多边形的起点
        path.lineTo(120, 250);
        path.lineTo(80, 250);
        path.close();
        paint.setColor(Color.GREEN);
        canvas.drawPath(path,paint);

        path.reset();
        paint.setStyle(Paint.Style.STROKE);//设置空心
        Path path1=new Path();
        path1.moveTo(180, 200);
        path1.lineTo(200, 200);
        path1.lineTo(210, 210);
        path1.lineTo(200, 220);
        path1.lineTo(180, 220);
        path1.lineTo(170, 210);
        path1.close();//封闭
        canvas.drawPath(path1, paint);


        /**
         *圆角矩形
         */
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        RectF rectF5 = new RectF(100,600,600,800);
//        canvas.drawRect(rectF5,paint);
        canvas.drawRoundRect(rectF5,60,60,paint);

        /**
         *画贝塞尔曲线
         */
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.YELLOW);
        Path path2 = new Path();
        path2.moveTo(100,300);
        /**
         *float x1, float y1, float x2, float y2
         */
        path2.quadTo(150,300,200,400);
        canvas.drawPath(path2,paint);

        /**
         *画点
         * float x, float y, @NonNull Paint paint
         */

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPoint(100,1000,paint);
        canvas.drawPoints(new float[]{60,400,65,400,70,400},paint);


        /**
         *画图片
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        canvas.drawBitmap(bitmap, 100,800, paint);






    }
}
