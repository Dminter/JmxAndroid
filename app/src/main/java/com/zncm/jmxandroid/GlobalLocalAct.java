package com.zncm.jmxandroid;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GlobalLocalAct extends Activity {
    private int lastX = 0;
    private int lastY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_img2);

        ImageView imageView = (ImageView) findViewById(R.id.img);



        Rect localRect = new Rect();
        imageView.getLocalVisibleRect(localRect);
        ((TextView) findViewById(R.id.local))
                .setText("imageViewlocal" + localRect.toString());

        Rect globalRect = new Rect();
        Point globalOffset = new Point();
        imageView.getGlobalVisibleRect(globalRect, globalOffset);
        ((TextView) findViewById(R.id.global))
                .setText("imageViewglobal" + globalRect.toString());
        ((TextView) findViewById(R.id.offset))
                .setText("imageViewglobalOffset:" + globalOffset.x + "," + globalOffset.y);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();
                        Rect localRect = new Rect();
                        v.getLocalVisibleRect(localRect);
                        ((TextView) findViewById(R.id.local))
                                .setText("local" + localRect.toString());

                        Rect globalRect = new Rect();
                        Point globalOffset = new Point();
                        v.getGlobalVisibleRect(globalRect, globalOffset);
                        ((TextView) findViewById(R.id.global))
                                .setText("global" + globalRect.toString());
                        ((TextView) findViewById(R.id.offset))
                                .setText("globalOffset:" + globalOffset.x + "," + globalOffset.y);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) event.getRawX() - lastX;
                        int dy = (int) event.getRawY() - lastY;

                        int left = v.getLeft() + dx;
                        int top = v.getTop() + dy;
                        int right = v.getRight() + dx;
                        int bottom = v.getBottom() + dy;

                        v.layout(left, top, right, bottom);
                        lastX = (int) event.getRawX();
                        lastY = (int) event.getRawY();

                      localRect = new Rect();
                        v.getLocalVisibleRect(localRect);
                        ((TextView) findViewById(R.id.local))
                                .setText("local" + localRect.toString());

                     globalRect = new Rect();
                        globalOffset = new Point();
                        v.getGlobalVisibleRect(globalRect, globalOffset);
                        ((TextView) findViewById(R.id.global))
                                .setText("global" + globalRect.toString());
                        ((TextView) findViewById(R.id.offset))
                                .setText("globalOffset:" + globalOffset.x + "," + globalOffset.y);
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return true;
            }
        });


    }
}