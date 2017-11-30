package com.zncm.jmxandroid.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zncm.jmxandroid.MainActivity;
import com.zncm.jmxandroid.utils.Xutils;

public class BootBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Xutils.debug("11111111111111111111111111111111");
            Xutils.tLong("启动完毕");
//            Intent mainIntent = new Intent(context, MainActivity.class);
//            mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(mainIntent);
            Intent startApp = context.getPackageManager().getLaunchIntentForPackage("com.zncm.jmxandroid");
            context.startActivity(startApp);
        }
    }
}

