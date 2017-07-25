package com.zncm.jmxandroid.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/5/12.
 *
 * QQ运动动画
 */

public class QQSportStepView extends View {
    private  int outerColor;
    private  int innerColor;
    private  int borderWidth;
    private  int stepTextSize;
    private  int stepTextColor;

    int mCurrentStep = 50;
    int mStepMax =200;
    Paint paint;
    Paint innerPaint;
    Paint textPaint;


    public QQSportStepView(Context context) {
        super(context);
    }

    public QQSportStepView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.QQStepView);
        outerColor = typedArray.getColor(R.styleable.QQStepView_outerColor,outerColor);
        innerColor = typedArray.getColor(R.styleable.QQStepView_innerColor,innerColor);
        borderWidth = (int) typedArray.getDimension(R.styleable.QQStepView_borderWidth,borderWidth);
        stepTextSize = (int) typedArray.getDimension(R.styleable.QQStepView_stepTextSize,stepTextSize);
        stepTextColor = typedArray.getColor(R.styleable.QQStepView_stepTextColor,stepTextColor);
        typedArray.recycle();

        paint = new Paint();
//        paint.setColor(outerColor);

        int[] mGradientColors = {Color.GREEN, Color.YELLOW, Color.RED};
        Shader shader = new SweepGradient(0,1000,mGradientColors,null);

        paint.setShader(shader);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(borderWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        innerPaint = new Paint();
        innerPaint.setColor(innerColor);
        innerPaint.setStrokeWidth(borderWidth);
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setStrokeCap(Paint.Cap.ROUND);
        innerPaint.setAntiAlias(true);

        textPaint = new Paint();

        Shader shader2 = new SweepGradient(0,1000,mGradientColors,null);
        textPaint.setShader(shader2);
        textPaint.setColor(stepTextColor);
        textPaint.setTextSize(stepTextSize);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setAntiAlias(true);
    }

    public QQSportStepView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth()/2;
        int radius = getWidth()/2-borderWidth/2;
        RectF rectF = new RectF(center-radius,center-radius,center+radius,center+radius);
        canvas.drawArc(rectF,135,270,false,paint);


        if (mStepMax==0){
            return;
        }
        float sweepAngle = (float)mCurrentStep/mStepMax;
        canvas.drawArc(rectF,135,sweepAngle*270,false,innerPaint);


        String stepText = mCurrentStep+"";
        Rect textRect = new Rect();
        textPaint.getTextBounds(stepText,0,stepText.length(),textRect);
        int dx = getWidth()/2-textRect.width()/2;

        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        int dy = (fontMetricsInt.bottom-fontMetricsInt.top)/2-fontMetricsInt.bottom;
        int baseLine = getHeight()/2+dy;
        canvas.drawText(stepText,dx,baseLine,textPaint);




    }


    public void setmCurrentStep(int mCurrentStep) {
        this.mCurrentStep = mCurrentStep;
        invalidate();
    }

    public void setmStepMax(int mStepMax) {
        this.mStepMax = mStepMax;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width>height?height:width,width>height?height:width);


    }
}
