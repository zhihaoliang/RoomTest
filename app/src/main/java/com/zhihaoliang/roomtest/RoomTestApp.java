package com.zhihaoliang.roomtest;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * 创建日期：2018/12/18
 * 描述:应用的Application
 * 作者:支豪亮
 */
public class RoomTestApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        if (BuildConfig.DEBUG) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            StrictMode.ThreadPolicy.Builder threadPolicyBuilder = new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                threadPolicyBuilder.penaltyDeathOnNetwork();
            }
            StrictMode.setThreadPolicy(threadPolicyBuilder.build());
            Stetho.initializeWithDefaults(this);
        }
        LeakCanary.install(this);
    }
}
