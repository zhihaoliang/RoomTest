package com.zhihaoliang.roomtest.room.pair;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * 创建日期：2018/12/18
 * 描述:存储键值对的Entity
 * 作者:支豪亮
 */
@Dao
public interface KeyAndValueDao {

    @Query("SELECT * FROM KeyAndValue WHERE _KEY=:ky")
    List<KeyAndValue> loadById(String ky);

    @Query("SELECT * FROM KeyAndValue")
    List<KeyAndValue> loadAll();

    @Insert
    long insert(KeyAndValue keyAndValue);

    @Update
    int update(KeyAndValue keyAndValue);

    @Delete
    int delete(KeyAndValue keyAndValue);

}
