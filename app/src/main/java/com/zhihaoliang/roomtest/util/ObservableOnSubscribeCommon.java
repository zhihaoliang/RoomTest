package com.zhihaoliang.roomtest.util;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * 创建日期：2018/12/18
 * 描述: 通用的观察者的发送者
 * 作者:支豪亮
 */
public abstract class ObservableOnSubscribeCommon<T> implements ObservableOnSubscribe {

    public ObservableOnSubscribeCommon(){

    }

    @Override
    public void subscribe(ObservableEmitter emitter) throws Exception {
        emitter.onNext(initSubscribeCont());
    }


    public abstract T initSubscribeCont();


}
