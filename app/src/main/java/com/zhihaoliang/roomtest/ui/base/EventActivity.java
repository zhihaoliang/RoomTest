package com.zhihaoliang.roomtest.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * 创建日期：2018/12/24
 * 描述:用于Event Bus为基类
 * 作者:支豪亮
 */
public class EventActivity extends AppCompatActivity {

    private BaseActivity.EventHandler[] mEventHandlers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEventHandlers = onEventHandlers();
        for (EventHandler eventHandler : mEventHandlers) {
            EventBus.getDefault().register(eventHandler);
        }
    }

    /**
     * eventbus消息响应方法的再封装
     */
    public static abstract class EventHandler<T> {
        // 集成的方法一定要写@Subscribe注解
        @Subscribe
        public abstract void onEvent(T event);
    }

    /**
     * 如果acitiviy需要响应eventbus消息，需要重写此方法。
     * 返回参数是EventHandler数组，每一类Event需要一个EventHandler
     */
    public BaseActivity.EventHandler[] onEventHandlers() {
        return new EventHandler[0];
    }

    @Override
    protected void onDestroy() {
        for (EventHandler eventHandler : mEventHandlers) {
            EventBus.getDefault().unregister(eventHandler);
        }
        super.onDestroy();
    }
}
