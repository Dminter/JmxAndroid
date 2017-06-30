package com.zncm.jmxandroid.view.pd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.yjing.imageeditlibrary.editimage.view.PaintPath;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by jiaomx on 2017/6/15.
 */

public class PDPaintView extends View {
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    Path path;
    int color = Color.RED;
    float strokeWidth = 20;

      Rect imgRectF = new Rect();


    CopyOnWriteArrayList<PaintPath> mUndoList = new CopyOnWriteArrayList<>();


    public PDPaintView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
    }

    private Paint paintCopy() {
        Paint paintCy = new Paint();
        paintCy.setColor(paint.getColor());
        paintCy.setStrokeWidth(paint.getStrokeWidth());
        paintCy.setAntiAlias(paint.isAntiAlias());
        paintCy.setStrokeJoin(paint.getStrokeJoin());
        paintCy.setStrokeCap(paint.getStrokeCap());
        paintCy.setStyle(paint.getStyle());
        return paintCy;
    }


    public PDPaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (bitmap == null) {
            initBitmap();
        }
    }

    private void initBitmap() {
        bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean flag = super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();

        if (x < imgRectF.left || x > imgRectF.right) {
            return false;
        }

        if (y < imgRectF.top || y > imgRectF.bottom) {
            return false;
        }


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                path.moveTo(x, y);
                flag = true;
                break;
            case MotionEvent.ACTION_UP:
                mUndoList.add(new PaintPath(path, paintCopy()));
                canvas.drawPath(path, paint);
                postInvalidate();
                flag = true;
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                canvas.drawPath(path, paint);
                postInvalidate();
                break;
            case MotionEvent.ACTION_CANCEL:
                break;

        }


        return flag;
    }


    public void setImgRectF(Rect imgRectF) {
        this.imgRectF = imgRectF;
    }

    public void undo() {
        if (mUndoList != null && mUndoList.size() > 0) {
            mUndoList.remove(mUndoList.size() - 1);
            resetCanvas();
            for (PaintPath path : mUndoList
                    ) {
                canvas.drawPath(path.getPath(), path.getPaint());
            }
            invalidate();
        }
    }

    private void resetCanvas() {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        invalidate();
        initBitmap();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, null);
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        this.paint.setColor(color);
    }


    public float getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = strokeWidth;
    }
}
