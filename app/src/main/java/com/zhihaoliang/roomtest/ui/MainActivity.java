package com.zhihaoliang.roomtest.ui;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.zhihaoliang.roomtest.R;
import com.zhihaoliang.roomtest.room.AppDatabase;
import com.zhihaoliang.roomtest.room.pair.KeyAndValue;
import com.zhihaoliang.roomtest.room.pair.KeyAndValueDao;
import com.zhihaoliang.roomtest.util.ObservableOnSubscribeCommon;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private EditText mETKey;

    private EditText mETValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mETKey = findViewById(R.id.ETKey);
        mETValue = findViewById(R.id.ETValue);
    }

    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.update:
            case R.id.add:
                if (TextUtils.isEmpty(mETKey.getText().toString()) || TextUtils.isEmpty(mETValue.getText().toString())) {
                    return;
                }
                insertOrUpdate();
                break;
            case R.id.del:
                if (TextUtils.isEmpty(mETKey.getText().toString())){
                    return;
                }
                del();
                break;
            default:
                read(new ReadCallBack() {
                    @Override
                    public void onReadCallBack(List<KeyAndValue> list) {
                        Logger.e(new Gson().toJson(list));
                    }
                });
                break;
        }
    }

    @SuppressLint("CheckResult")
    private void del() {
        Observable.create(new ObservableOnSubscribeCommon<KeyAndValue>() {
            @Override
            public KeyAndValue initSubscribeCont() {
                return initKeyAndValue();
            }
        }).observeOn(Schedulers.io())
                .map(new Function<KeyAndValue, Integer>() {
                    @Override
                    public Integer apply(KeyAndValue keyAndValue) {
                        AppDatabase appDatabase = AppDatabase.instance(getApplication());
                        KeyAndValueDao keyAndValueDao = appDatabase.getKeyAndValueDao();
                        return keyAndValueDao.delete(keyAndValue);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer num) {
                        Logger.e("num %d", num);
                    }
                });
    }


    private void insertOrUpdate() {
        read(new ReadCallBack() {
            @Override
            public void onReadCallBack(List<KeyAndValue> list) {
                insertOrUpdate(list.isEmpty());
            }
        });
    }


    @SuppressLint("CheckResult")
    private void insertOrUpdate(final boolean isInsert) {
        Observable.create(new ObservableOnSubscribeCommon<KeyAndValue>() {
            @Override
            public KeyAndValue initSubscribeCont() {
                return initKeyAndValue();
            }
        }).observeOn(Schedulers.io())
                .map(new Function<KeyAndValue, Long>() {
                    @Override
                    public Long apply(KeyAndValue keyAndValue) {
                        AppDatabase appDatabase = AppDatabase.instance(getApplication());
                        KeyAndValueDao keyAndValueDao = appDatabase.getKeyAndValueDao();
                        return isInsert ? keyAndValueDao.insert(keyAndValue) : keyAndValueDao.update(keyAndValue);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long num) {
                        Logger.e("num %d", num);
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void read(final ReadCallBack readCallBack) {
        Observable.create(new ObservableOnSubscribeCommon<String>() {
            @Override
            public String initSubscribeCont() {
                return mETKey.getText().toString();
            }
        }).observeOn(Schedulers.io())
                .map(new Function<String, List<KeyAndValue>>() {
                    @Override
                    public List<KeyAndValue> apply(String key) {
                        KeyAndValueDao keyAndValueDao = AppDatabase.instance(getApplication()).getKeyAndValueDao();
                        return TextUtils.isEmpty(key) ? keyAndValueDao.loadAll() : keyAndValueDao.loadById(key);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<KeyAndValue>>() {
                    @Override
                    public void accept(List<KeyAndValue> list) {
                        readCallBack.onReadCallBack(list);
                    }
                });
    }

    private interface ReadCallBack {
        void onReadCallBack(List<KeyAndValue> list);
    }

    private KeyAndValue initKeyAndValue() {
        KeyAndValue keyAndValue = new KeyAndValue();
        String value = mETValue.getText().toString();
        if ("true".equals(value)) {
            value = KeyAndValue.TURE_KEY;
        } else if ("false".equals(value)) {
            value = KeyAndValue.FALSE_KEY;
        }
        keyAndValue.setKey(mETKey.getText().toString());
        keyAndValue.setValue(value);
        return keyAndValue;
    }

}
