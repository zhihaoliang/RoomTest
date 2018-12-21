package com.zhihaoliang.roomtest.room;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.zhihaoliang.roomtest.room.pair.KeyAndValue;
import com.zhihaoliang.roomtest.room.pair.KeyAndValueDao;

/**
 * 创建日期：2018/12/18
 * 描述:数据的工具类，需要是单例模式
 * 作者:支豪亮
 */
@Database(entities = {KeyAndValue.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public static AppDatabase instance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application,
                    AppDatabase.class, "database-name").build();
        }
        return instance;
    }


    public abstract KeyAndValueDao getKeyAndValueDao();

}
