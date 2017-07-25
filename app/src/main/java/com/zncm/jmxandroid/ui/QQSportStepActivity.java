package com.zncm.jmxandroid.ui;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.DecelerateInterpolator;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.view.QQSportStepView;

public class QQSportStepActivity extends BaseAc {
    Context ctx;
    QQSportStepView mQQSportStepView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        mQQSportStepView = (QQSportStepView) findViewById(R.id.mQQSportStepView);

        mQQSportStepView.setmStepMax(8000);

        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 5000);
        valueAnimator.setDuration(1000);
        /**
         *An interpolator where the rate of change starts out quickly and
         * and then decelerates.
         */
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                /**
                 *  Caused by: java.lang.ClassCastException: java.lang.Float cannot be cast to java.lang.Integer
                 */
                float curStep = (float) animation.getAnimatedValue();
                mQQSportStepView.setmCurrentStep((int) curStep);

            }
        });
        valueAnimator.start();


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_qqsportstep;
    }
}
