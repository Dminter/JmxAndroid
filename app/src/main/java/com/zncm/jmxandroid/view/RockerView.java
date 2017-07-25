package com.zncm.jmxandroid.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.utils.Xutils;

/**
 * Created by jiaomx on 2017/5/12.
 */

public class RockerView extends View {

    Bitmap bitmapBg;
    Bitmap bitmapOp;
    Paint paint;
    PointF pointF;
    float bitmapBgX;
    float bitmapBgY;
    float bitmapBgR;


    float bitmapOpX;
    float bitmapOpY;
    float bitmapOpR;

    public RockerView(Context context) {
        super(context);
    }

    public RockerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        bitmapBg = BitmapFactory.decodeResource(context.getResources(), R.drawable.op_fangxiang);
        bitmapOp = BitmapFactory.decodeResource(context.getResources(), R.drawable.op_kongzhiqiau);
        paint = new Paint();
        pointF = new PointF((float) bitmapBg.getWidth() / 2, (float) bitmapBg.getHeight() / 2);
        Xutils.debug("pointF::" + pointF);
        bitmapBgX = pointF.x;
        bitmapBgY = pointF.y;

        bitmapOpX = pointF.x;
        bitmapOpY = pointF.y;

//        bitmapBgR =(float) getWidth()/2-


    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(this.mBmpRockerBg, (Rect)null, new Rect((int)(this.mRockerBg_X - this.mRockerBg_R),
// (int)(this.mRockerBg_Y - this.mRockerBg_R), (int)(this.mRockerBg_X + this.mRockerBg_R),
// (int)(this.mRockerBg_Y + this.mRockerBg_R)), (Paint)null);
//        canvas.drawBitmap(this.mBmpRockerBtn, (Rect)null, new Rect((int)(this.mRockerBtn_X - this.mRockerBtn_R), (int)(this.mRockerBtn_Y - this.mRockerBtn_R), (int)(this.mRockerBtn_X + this.mRockerBtn_R), (int)(this.mRockerBtn_Y + this.mRockerBtn_R)), (Paint)null);


//    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect src, @NonNull RectF dst,
//                           @Nullable Paint paint) {


        RectF bgRectF = new RectF(0, 0, bitmapBg.getWidth(), bitmapBg.getHeight());
        RectF opRectF = new RectF((float) (bitmapBg.getWidth() - bitmapOp.getWidth()) / 2, (float) (bitmapBg.getHeight() - bitmapOp.getHeight()) / 2, bitmapOp.getWidth(), bitmapOp.getHeight());

        canvas.drawBitmap(bitmapBg, null, bgRectF, null);
        canvas.drawBitmap(bitmapOp, null, opRectF, null);


    }
}
