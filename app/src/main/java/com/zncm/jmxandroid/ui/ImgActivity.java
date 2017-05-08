package com.zncm.jmxandroid.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zncm.jmxandroid.R;

public class ImgActivity extends AppCompatActivity {

    LinearLayout container;
    private Animator mCurrentAnimator;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        imageView = (ImageView) findViewById(R.id.imageView);
        container = (LinearLayout) findViewById(R.id.container);

        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.img1));
        final Rect startBounds = new Rect(300, 300, 300, 300);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                imageView.post(new Runnable() {
                    @Override
                    public void run() {
//                        final Rect startBounds = new Rect(0, 0, 200, 200);
                        final Rect finalBounds = new Rect(500, 500, 1080, 1920);
//                        closeBigPhoto(startBounds, finalBounds);

//                        final Rect finalBounds = new Rect(0, 0, 1080, 1920);
//                        imageView.getGlobalVisibleRect(finalBounds);
                        imgAnimator(finalBounds, startBounds, false);
                    }
                });

            }
        });
        imageView.post(new Runnable() {
            @Override
            public void run() {
                final Rect finalBounds = new Rect(500, 500, 1080, 1920);
//                imageView.getGlobalVisibleRect(finalBounds);
                imgAnimator(startBounds, finalBounds, true);
            }
        });


    }


    public void closeBigPhoto(Rect startBounds, Rect finalBounds) {
        final Point globalOffset = new Point();
//        container.getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);


        final float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height()) {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }


        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }

        ObjectAnimator backgroundColor = ObjectAnimator.ofInt(imageView, "backgroundColor", Color.BLACK, Color.TRANSPARENT);

        backgroundColor.setEvaluator(new ArgbEvaluator());

        AnimatorSet set = new AnimatorSet();
        set
                .play(ObjectAnimator.ofFloat(imageView, View.X, startBounds.left))
                .with(ObjectAnimator.ofFloat(imageView, View.Y, startBounds.top))
                .with(ObjectAnimator
                        .ofFloat(imageView, View.SCALE_X, startScale))
                .with(ObjectAnimator
                        .ofFloat(imageView, View.SCALE_Y, startScale))
                .with(backgroundColor);
        set.setDuration(2500);
        set.setInterpolator(new DecelerateInterpolator());

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

                mCurrentAnimator = null;

            }

            @Override
            public void onAnimationCancel(Animator animation) {
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;

    }

    private void imgAnimator(Rect startBounds, Rect finalBounds, boolean isOpen) {

        final Point globalOffset = new Point();
//                imageView.getGlobalVisibleRect(startBounds);
//                container.getGlobalVisibleRect(finalBounds, globalOffset);

//        startBounds.offset(-globalOffset.x, -globalOffset.y);
//        finalBounds.offset(-globalOffset.x, -globalOffset.y);
//        Xutils.debug("startBounds::" + startBounds + " " + finalBounds + " " + globalOffset);
//        float startScale;
//        if ((float) finalBounds.width() / finalBounds.height()
//                > (float) startBounds.width() / startBounds.height()) {
//            startScale = (float) startBounds.height() / finalBounds.height();
//            float startWidth = startScale * finalBounds.width();
//            float deltaWidth = (startWidth - startBounds.width()) / 2;
//            startBounds.left -= deltaWidth;
//            startBounds.right += deltaWidth;
//        } else {
//            startScale = (float) startBounds.width() / finalBounds.width();
//            float startHeight = startScale * finalBounds.height();
//            float deltaHeight = (startHeight - startBounds.height()) / 2;
//            startBounds.top -= deltaHeight;
//            startBounds.bottom += deltaHeight;
//        }


//        if (isOpen) {
//            imageView.setPivotX(0f);
//            imageView.setPivotY(0f);
//        } else {
//            imageView.setPivotX(startBounds.left);
//            imageView.setPivotY(startBounds.top);
//            if (mCurrentAnimator != null) {
//                mCurrentAnimator.cancel();
//            }
//        }
//        AnimatorSet set = new AnimatorSet();
//
//        Xutils.debug("：：：" + startBounds.left + "-" + finalBounds.left +"--"+ startBounds.top + "-" + finalBounds.top);
//
//        if (isOpen) {
//            set
//                    .play(ObjectAnimator.ofFloat(imageView, View.X, startBounds.left,
//                            finalBounds.left))
//                    .with(ObjectAnimator.ofFloat(imageView, View.Y, startBounds.top,
//                            finalBounds.top))
//                    .with(ObjectAnimator.ofFloat(imageView, View.SCALE_X, startScale, 1f))
//                    .with(ObjectAnimator.ofFloat(imageView, View.SCALE_Y, startScale, 1f));
//        } else {
//            set
////                    .play(ObjectAnimator.ofFloat(imageView, View.X, finalBounds.left,
////                            startBounds.left))
////                    .with(ObjectAnimator.ofFloat(imageView, View.Y, finalBounds.top,
////                            startBounds.top));
//                    .play(ObjectAnimator.ofFloat(imageView, View.X, startBounds.left,
//                            finalBounds.left))
//                    .with(ObjectAnimator.ofFloat(imageView, View.Y, startBounds.top,
//                            finalBounds.top))
////                    .with(ObjectAnimator.ofFloat(imageView, View.SCALE_X, startScale, 1f))
////                    .with(ObjectAnimator.ofFloat(imageView, View.SCALE_Y, startScale, 1f));
//                    .with(ObjectAnimator
//                            .ofFloat(imageView, View.SCALE_X, startScale))
//                    .with(ObjectAnimator
//                            .ofFloat(imageView, View.SCALE_Y, startScale));
//        }


        ObjectAnimator translationX = ObjectAnimator.ofFloat(imageView, View.X, startBounds.left, finalBounds.left);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(imageView, View.Y, startBounds.top, finalBounds.top);
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 0f,1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 0f, 1f);


//        ObjectAnimator translationX2 = ObjectAnimator.ofFloat(imageView, "translationX", 300f);
//        ObjectAnimator translationY2 = ObjectAnimator.ofFloat(imageView, "translationY", 300f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(5000);
        set.playTogether(translationX, translationY, scaleX, scaleY);
        set.start();


        set.setDuration(2500);
        set.setInterpolator(new DecelerateInterpolator());
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.setVisibility(View.VISIBLE);
                mCurrentAnimator = null;
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                imageView.setVisibility(View.GONE);
                mCurrentAnimator = null;
            }
        });
        set.start();
        mCurrentAnimator = set;
    }
}
