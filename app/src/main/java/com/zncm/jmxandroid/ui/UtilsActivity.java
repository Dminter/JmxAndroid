package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.rxjava2_retrofit.NetworkUtils;

public class UtilsActivity extends BaseAc {
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;

        TextView mTextView = (TextView) findViewById(R.id.mTextView);
        StringBuffer sbInfo = new StringBuffer();

/**
 *C:\Users\jiaomx>ping www.baidu.com

 正在 Ping www.a.shifen.com [180.97.33.107] 具有 32 字节的数据:
 来自 180.97.33.107 的回复: 字节=32 时间=16ms TTL=54
 来自 180.97.33.107 的回复: 字节=32 时间=15ms TTL=54
 来自 180.97.33.107 的回复: 字节=32 时间=18ms TTL=54
 来自 180.97.33.107 的回复: 字节=32 时间=18ms TTL=54

 180.97.33.107 的 Ping 统计信息:
 数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，
 往返行程的估计时间(以毫秒为单位):
 最短 = 15ms，最长 = 18ms，平均 = 16ms
 */
        sbInfo.append("getDomainAddress：").append(NetworkUtils.getDomainAddress("www.baidu.com")).append("\n");
        sbInfo.append("pingDomain：").append(NetworkUtils.pingDomain("www.baidu.com")).append("\n");
        sbInfo.append("getIPAddress：").append(NetworkUtils.getIPAddress(true)).append("\n");
        sbInfo.append("getNetworkType：").append(NetworkUtils.getNetworkType()).append("\n");


        mTextView.setText(sbInfo);


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_utils;
    }
}
