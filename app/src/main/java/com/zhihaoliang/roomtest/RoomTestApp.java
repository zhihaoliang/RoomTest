package com.zhihaoliang.roomtest;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

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
        Stetho.initializeWithDefaults(this);
    }
}
