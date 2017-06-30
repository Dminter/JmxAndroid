package com.zncm.jmxandroid.view.pd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.utils.Xutils;

/**
 * Created by jiaomx on 2017/6/16.
 */

public class PDCropImageView extends View {
    Context ctx;


    Paint backgroundPaint;
    Bitmap opBitmap;
    Rect opBitmapRect = new Rect();



    enum InOP {
        IN_NULL, IN_LT, IN_RT,
        IN_LB, IN_RB
    }

    InOP inOP = InOP.IN_NULL;

    enum Status {
        STATUS_NULL, STATUS_MOVE, STATUS_SCALE
    }

    Status status = Status.STATUS_NULL;


    RectF opLeftTop;
    RectF opRightTop;
    RectF opLeftBottom;
    RectF opRightBottom;
    RectF cropRect = new RectF();
    RectF tempRect = new RectF();
    RectF imageRect = new RectF();


    int opWidth = 46;


    RectF outLeft = new RectF();
    RectF outTop = new RectF();
    RectF outRight = new RectF();
    RectF outBottom = new RectF();


    int zoomRate = -1;

    private float oldx, oldy;

    public PDCropImageView(Context context) {
        super(context);
        ctx = context;
        init();
    }

    public PDCropImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        init();
    }


    private void init() {

        backgroundPaint = new Paint();
        backgroundPaint.setColor(Color.parseColor("#B0000000"));
        opBitmap = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.sticker_rotate);
        opBitmapRect.set(0, 0, opBitmap.getWidth(), opBitmap.getHeight());
        opLeftTop = new RectF(0, 0, opWidth, opWidth);
        opRightTop = new RectF(opLeftTop);
        opLeftBottom = new RectF(opLeftTop);
        opRightBottom = new RectF(opLeftTop);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }


        outTop.set(0, 0, w, cropRect.top);
        outLeft.set(0, cropRect.top, cropRect.left, cropRect.bottom);
        outRight.set(cropRect.right, cropRect.top, w, cropRect.bottom);
        outBottom.set(0, cropRect.bottom, w, h);

        canvas.drawRect(outTop, backgroundPaint);
        canvas.drawRect(outLeft, backgroundPaint);
        canvas.drawRect(outRight, backgroundPaint);
        canvas.drawRect(outBottom, backgroundPaint);

        int radius = opWidth >> 1;
        opLeftTop.set(cropRect.left - radius, cropRect.top - radius,
                cropRect.left + radius, cropRect.top + radius);
        opRightTop.set(cropRect.right - radius, cropRect.top - radius,
                cropRect.right + radius, cropRect.top + radius);
        opLeftBottom.set(cropRect.left - radius, cropRect.bottom - radius,
                cropRect.left + radius, cropRect.bottom + radius);
        opRightBottom.set(cropRect.right - radius, cropRect.bottom - radius,
                cropRect.right + radius, cropRect.bottom + radius);
        canvas.drawBitmap(opBitmap, opBitmapRect, opLeftTop, null);
        canvas.drawBitmap(opBitmap, opBitmapRect, opRightTop, null);
        canvas.drawBitmap(opBitmap, opBitmapRect, opLeftBottom, null);
        canvas.drawBitmap(opBitmap, opBitmapRect, opRightBottom, null);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();



        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                InOP tmp = isSelOp(x, y);
                if (tmp != InOP.IN_NULL) {
                    inOP = tmp;
                    status = Status.STATUS_SCALE;
                } else if (cropRect.contains(x, y)) {
                    status = Status.STATUS_MOVE;
                }
                break;
            case MotionEvent.ACTION_UP:
                status = Status.STATUS_NULL;
                break;
            case MotionEvent.ACTION_MOVE:

                if (status == Status.STATUS_SCALE) {
                    tempRect = cropRect;

                    Xutils.debug("-------->>>" + cropRect.left + " " + tempRect.left);

                    switch (inOP) {
                        case IN_LT:
                            cropRect.left = x;
                            cropRect.top = y;
                            break;
                        case IN_RT:
                            cropRect.right = x;
                            cropRect.top = y;
                            break;
                        case IN_LB:
                            cropRect.left = x;
                            cropRect.bottom = y;
                            break;
                        case IN_RB:
                            cropRect.right = x;
                            cropRect.bottom = y;
                            break;
                    }



//                    if (cropRect.width() < opWidth) {
//                        cropRect.left = tempRect.left;
//                        cropRect.right = tempRect.right;
//                    }
//                    Xutils.debug("-------->>2>" + cropRect.left + " " + tempRect.left+" "+cropRect.width() +"   "+ opWidth);
//
//
//                    if (cropRect.height() < opWidth) {
//                        cropRect.top = tempRect.top;
//                        cropRect.bottom = tempRect.bottom;
//                    }


                    if (cropRect.left < imageRect.left) {
                        cropRect.left = imageRect.left;
                    }
                    if (cropRect.right > imageRect.right) {
                        cropRect.right = imageRect.right;
                    }
                    if (cropRect.top < imageRect.top) {
                        cropRect.top = imageRect.top;
                    }
                    if (cropRect.bottom > imageRect.bottom) {
                        cropRect.bottom = imageRect.bottom;
                    }

//                    if (cropRect.left < imageRect.left
//                            || cropRect.right > imageRect.right
//                            || cropRect.top < imageRect.top
//                            || cropRect.bottom > imageRect.bottom
//                            || cropRect.width() < opWidth
//                            || cropRect.height() < opWidth) {
//                        cropRect.set(tempRect);
//                    }




//                    switch (inOP) {
//                        case IN_LT:
//                        case IN_RT:
//                            cropRect.bottom = (cropRect.right - cropRect.left) + cropRect.top;
//                             break;
//                        case IN_LB:
//                        case IN_RB:
//                            cropRect.top = cropRect.bottom
//                                    - (cropRect.right - cropRect.left);
//                            break;
//                    }
//
//
//                    if (cropRect.left < imageRect.left
//                            || cropRect.right > imageRect.right
//                            || cropRect.top < imageRect.top
//                            || cropRect.bottom > imageRect.bottom
//                            || cropRect.width() < opWidth
//                            || cropRect.height() < opWidth) {
//                        cropRect.set(tempRect);
//                    }

                    invalidate();
                    Xutils.debug("zoomRate>>" + zoomRate + " " + cropRect.toString());


                } else if (status == Status.STATUS_MOVE) {
                    tempRect.set(cropRect);// 存贮原有数据，以便还原

                    translateRect(cropRect, x - oldx, y - oldy);
                    // 边界判定算法优化
                    float mdLeft = imageRect.left - cropRect.left;
                    if (mdLeft > 0) {
                        translateRect(cropRect, mdLeft, 0);
                    }
                    float mdRight = imageRect.right - cropRect.right;
                    if (mdRight < 0) {
                        translateRect(cropRect, mdRight, 0);
                    }
                    float mdTop = imageRect.top - cropRect.top;
                    if (mdTop > 0) {
                        translateRect(cropRect, 0, mdTop);
                    }
                    float mdBottom = imageRect.bottom - cropRect.bottom;
                    if (mdBottom < 0) {
                        translateRect(cropRect, 0, mdBottom);
                    }

                    invalidate();
                }


                break;
            case MotionEvent.ACTION_CANCEL:
                break;

        }
        oldx = x;
        oldy = y;

        return true;
    }

    private static final void translateRect(RectF rect, float dx, float dy) {
        rect.left += dx;
        rect.right += dx;
        rect.top += dy;
        rect.bottom += dy;
    }

    private boolean limitZoomRect() {
        /**
         *限制缩放区域
         */

        Xutils.debug("-cropRect.width-" + cropRect.width() + " " + opWidth);


        return true;
    }

    private InOP isSelOp(float x, float y) {
        InOP inOP = InOP.IN_NULL;
        if (opLeftTop.contains(x, y)) {
            inOP = InOP.IN_LT;
        } else if (opRightTop.contains(x, y)) {
            inOP = InOP.IN_RT;
        } else if (opLeftBottom.contains(x, y)) {
            inOP = InOP.IN_LB;
        } else if (opRightBottom.contains(x, y)) {
            inOP = InOP.IN_RB;
        }
        return inOP;
    }

    private static void scaleRect(RectF rect, float scaleX, float scaleY) {
        float w = rect.width();
        float h = rect.height();

        float newW = scaleX * w;
        float newH = scaleY * h;

        float dx = (newW - w) / 2;
        float dy = (newH - h) / 2;

        rect.left -= dx;
        rect.top -= dy;
        rect.right += dx;
        rect.bottom += dy;
    }

//    public void setCropRect(RectF rect) {
//        this.cropRect = rect;
//        imageRect.set(rect);
//        cropRect.set(rect);
//        scaleRect(cropRect, 0.5f, 0.5f);
//        invalidate();
//    }

    public void setImgRectF(RectF rect) {
        this.cropRect = rect;
        imageRect.set(rect);
        cropRect.set(rect);
        scaleRect(cropRect, 0.5f, 0.5f);
        invalidate();
    }



    public Bitmap cropBitmap(Bitmap bitmap){


        Xutils.debug("cropBitmap::"+bitmap.getWidth()+" "+bitmap.getHeight()+" cropRect::"+cropRect.toString()+" "+cropRect.width() +"  "+ cropRect.height());

        /**
         * int x, int y, int width, int height
         */
        Bitmap resultBit = Bitmap.createBitmap(bitmap,
                (int) cropRect.left, (int) ((int) cropRect.top-imageRect.top),
                (int) cropRect.width(), (int) cropRect.height());


        return resultBit;
    }



}
