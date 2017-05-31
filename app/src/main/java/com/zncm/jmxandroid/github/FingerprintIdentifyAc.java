package com.zncm.jmxandroid.github;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wei.android.lib.fingerprintidentify.FingerprintIdentify;
import com.wei.android.lib.fingerprintidentify.base.BaseFingerprint;
import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

/**
 * Created by jiaomx on 2017/5/31.
 */

public class FingerprintIdentifyAc extends BaseAc {

    private TextView mTvTips;
    private boolean mIsCalledStartIdentify = false;
    private FingerprintIdentify mFingerprintIdentify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTvTips = (TextView) findViewById(R.id.mTvTips);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_fingerprint;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mIsCalledStartIdentify) {
            mTvTips.append("\nresume identify if needed");
            mFingerprintIdentify.resumeIdentify();
            return;
        }

        mIsCalledStartIdentify = true;
        mFingerprintIdentify = new FingerprintIdentify(this, new BaseFingerprint.FingerprintIdentifyExceptionListener() {
            @Override
            public void onCatchException(Throwable exception) {
                mTvTips.append("\n" + exception.getLocalizedMessage());
            }
        });

        mTvTips.append("create fingerprintIdentify");
        mTvTips.append("\nisHardwareEnable: " + mFingerprintIdentify.isHardwareEnable());
        mTvTips.append("\nisRegisteredFingerprint: " + mFingerprintIdentify.isRegisteredFingerprint());
        mTvTips.append("\nisFingerprintEnable: " + mFingerprintIdentify.isFingerprintEnable());

        if (!mFingerprintIdentify.isFingerprintEnable()) {
            mTvTips.append("\nSorry →_→");
            return;
        }

        mTvTips.append("\nstart identify\nput your finger on the sensor");
        mFingerprintIdentify.resumeIdentify();
        mFingerprintIdentify.startIdentify(3, new BaseFingerprint.FingerprintIdentifyListener() {
            @Override
            public void onSucceed() {
                mTvTips.append("\nonSucceed");
            }

            @Override
            public void onNotMatch(int availableTimes) {
                mTvTips.append("\nonNotMatch, " + availableTimes + " chances left");
            }

            @Override
            public void onFailed() {
                mTvTips.append("\nonFailed");
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        mTvTips.append("\nrelease");
        mFingerprintIdentify.cancelIdentify();
    }

    public void release(View view) {
        mTvTips.append("\nrelease by click");
        mFingerprintIdentify.cancelIdentify();
    }

}
