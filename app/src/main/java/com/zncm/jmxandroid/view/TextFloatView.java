package com.zncm.jmxandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.zncm.jmxandroid.utils.Xutils;

import java.util.ArrayList;

/**
 * Created by jiaomx on 2017/6/15.
 */

public class TextFloatView extends View {

    int textSize = Xutils.dip2px(20);

    TextPaint textPaint;
    Paint boxPaint;

    Rect textRect;
    Rect boxRect;
    Rect deleteRect;
    Rect rotateRect;


    EditText editText;


    int color = Color.RED;

    Context ctx;


    String text;
    ArrayList<String> textList = new ArrayList<>();


    int layoutX = 0;
    int layoutY = 0;
    float lastX = 0;
    float lastY = 0;
    boolean isFirst = true;

    boolean isBoxOp = true;


    public TextFloatView(Context context) {
        super(context);
        ctx = context;
        init();
    }


    public TextFloatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        init();
    }


    private void init() {
        textPaint = new TextPaint();
        textPaint.setColor(color);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(textSize);
        textPaint.setAntiAlias(true);

        boxPaint = new Paint();
        boxPaint.setColor(Color.BLACK);
        boxPaint.setStyle(Paint.Style.STROKE);
        boxPaint.setStrokeWidth(3);
        boxPaint.setAntiAlias(true);


    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (isFirst) {
            isFirst = false;
            layoutX = getMeasuredWidth() / 2;
            layoutY = getMeasuredHeight() / 2;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initText();
        if (!TextUtils.isEmpty(text)) {
            canvas.drawText(text, layoutX, layoutY, textPaint);
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean flag = super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                flag = true;
                break;
            case MotionEvent.ACTION_UP:
                flag = false;
                break;
            case MotionEvent.ACTION_MOVE:
                flag = true;
                float dx = x - lastX;
                float dy = y - lastY;
                layoutX += dx;
                layoutY += dy;
                invalidate();
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_CANCEL:
                break;

        }


        return flag;
    }


    private void initText() {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        textList.clear();
        if (text.contains("\n")) {
            String[] tmps = text.split("\n");
            for (String tmp : tmps
                    ) {
                textList.add(tmp);
            }
        }
    }

    public void setText(String text) {
        this.text = text;
        invalidate();
    }

    public void setColor(int color) {
        this.color = color;
        textPaint.setColor(color);
        invalidate();
    }
}
