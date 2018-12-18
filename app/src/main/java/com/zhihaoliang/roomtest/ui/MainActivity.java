package com.zhihaoliang.roomtest.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zhihaoliang.roomtest.R;
import com.zhihaoliang.roomtest.room.AppDatabase;
import com.zhihaoliang.roomtest.room.keyAvalue.KeyAndValue;

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
            case R.id.add:
                add();
                break;
            case R.id.del:
                del();
                break;
            case R.id.update:
                update();
                break;
            case R.id.read:
                read();
                break;
        }
    }

    private void add(){
        KeyAndValue keyAndValue = new KeyAndValue();

        keyAndValue.setKey(mETKey.getText().toString());
        keyAndValue.setValue(mETValue.getText().toString());

        AppDatabase appDatabase = AppDatabase.instance(getApplication());

    }

    private void del(){

    }

    private void update(){

    }

    private void read(){

    }

}
