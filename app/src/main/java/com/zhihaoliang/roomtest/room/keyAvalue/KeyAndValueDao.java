package com.zhihaoliang.roomtest.room.keyAvalue;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

/**
 * 创建日期：2018/12/18
 * 描述:存储键值对的Entity
 * 作者:支豪亮
 */
@Dao
public interface KeyAndValueDao {

    @Query("SELECT * FROM KeyAndValue")
    List<KeyAndValue> readAll();

    @Query("SELECT * FROM KeyAndValue Where id = :id")
    List<KeyAndValue> getById(int id);

    @Insert
    boolean insert(KeyAndValue keyAndValue);

    @Update
    boolean update(KeyAndValue keyAndValue);

}
