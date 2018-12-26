package com.zhihaoliang.roomtest.entity.room.pair;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * 创建日期：2018/12/18
 * 描述:存储键值对的Entity
 * 作者:支豪亮
 */
@Entity
public class KeyAndValue {

    /**
     * 表示true
     */
    public static final String TURE_KEY = "Y";
    /**
     * 表示false
     */
    public static final String FALSE_KEY = "N";

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "_KEY")
    private String key = "key";

    @ColumnInfo(name = "_VALUE")
    private String value;

    @Ignore
    private boolean isSelect;

    @NonNull
    public String getKey() {
        return key;
    }

    public void setKey(@NonNull String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public boolean isValue(){
        return value.equals(TURE_KEY);
    }


}
