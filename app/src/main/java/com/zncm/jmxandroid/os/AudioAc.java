package com.zncm.jmxandroid.os;

import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jiaomx on 2017/6/1.
 */

public class AudioAc extends BaseAc {

    @BindView(R.id.audioAc)
    TextView audioAc;

    AudioManager audioManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        String str = "audioManager::" + audioManager.getMode() + " " + audioManager.getRingerMode() + " " + audioManager.isMicrophoneMute() + " " + audioManager.isSpeakerphoneOn();
        audioAc.setText("==>>>" + str);

        /**
         *3 2 false true 错误
         * 0 2 false true 正确
         */

        /**
         *这个是正确的扬声器模式，控制不好导致全局模式乱掉，插耳机仍然是外放
         */
        audioManager.setMode(AudioManager.MODE_NORMAL);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        audioManager.setMicrophoneMute(false);
        audioManager.setSpeakerphoneOn(true);

        str = "audioManager::" + audioManager.getMode() + " " + audioManager.getRingerMode() + " " + audioManager.isMicrophoneMute() + " " + audioManager.isSpeakerphoneOn();
        audioAc.setText("==>>>" + str);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_audioac;
    }
}
