package com.zncm.jmxandroid.hook;

import android.content.Context;
import android.content.Intent;

import com.zncm.jmxandroid.utils.Xutils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by jiaomx on 2017/5/3.
 */

public class HookStartActivityUtils {

    private Context myContext;
    private Class<?> myProxyClass;

    public HookStartActivityUtils(Context myContext, Class<?> myProxyClass) {
        this.myContext = myContext;
        this.myProxyClass = myProxyClass;
    }

    public void hookStartActivity() throws Exception {

        Class<?> myClass = Class.forName("android.app.IActivityManager");
        Class<?> activityManagerNativeClass = Class.forName("android.app.ActivityManagerNative");
        Field gDefaultField = activityManagerNativeClass.getDeclaredField("gDefault");
        //设置权限
        gDefaultField.setAccessible(true);
        Object gDefault = gDefaultField.get(null);
        Class<?> singletonClass = Class.forName("android.util.Singleton");
        Field mInstanceField = singletonClass.getDeclaredField("mInstance");
        mInstanceField.setAccessible(true);
        Object mInstance = mInstanceField.get(gDefault);
        /**
         *InvocationHandler  谁去执行
         *
         */
        mInstance = Proxy.newProxyInstance(HookStartActivityUtils.class.getClassLoader(), new Class[]{myClass}, new startActivityInvocationHandler(mInstance));
        mInstanceField.set(gDefault, mInstance);

    }

    private class startActivityInvocationHandler implements InvocationHandler {

        Object object;

        public startActivityInvocationHandler(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Xutils.debug("invoke::" + method.getName());
            if (method.getName().equals("startActivity")) {
                Intent oriInent = (Intent) args[2];
                Intent safeIntent = new Intent(myContext, myProxyClass);
                args[2] = safeIntent;
                safeIntent.putExtra("oriInent", oriInent);

            }


            return method.invoke(object, args);
        }
    }

}
