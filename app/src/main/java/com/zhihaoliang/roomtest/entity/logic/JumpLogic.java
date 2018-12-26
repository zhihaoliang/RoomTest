package com.zhihaoliang.roomtest.entity.logic;

import android.support.annotation.NonNull;

/**
 * 创建日期：2018/12/25
 * 描述:表示Activity的跳转的问题
 * 作者:支豪亮
 */
public class JumpLogic {

    private String des;

    private String jumpClass;

    public JumpLogic(@NonNull String jumpClass, @NonNull String des) {
        this.jumpClass = jumpClass;
        this.des = String.format("%s-->%s", jumpClass.substring(jumpClass.lastIndexOf(".")), des);
    }

    public String getDes() {
        return des;
    }

    public String getJumpClass() {
        return jumpClass;
    }
}
