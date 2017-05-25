package com.zncm.jmxandroid.baseview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.ZoomButton;
import android.widget.ZoomControls;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.Xutils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jiaomx on 2017/5/25.
 */

public class ZoomControlsAc extends BaseAc {
    @BindView(R.id.zoomIn)
    ZoomControls zoomIn;
    @BindView(R.id.zoomButton)
    ZoomButton zoomButton;
    @BindView(R.id.mWebView)
    WebView mWebView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        zoomIn.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xutils.debug("zoomIn");
            }
        });
        zoomIn.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xutils.debug("zoomOut");
            }
        });


        mWebView.loadUrl("https://www.baidu.com/");

        /**
         *不配置，显示不出来任何东西
         */
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_zoomcontrols;
    }
}
