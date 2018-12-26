package com.zhihaoliang.roomtest.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.zhihaoliang.roomtest.R;
import com.zhihaoliang.roomtest.entity.logic.JumpLogic;



public class MainActivity extends AppCompatActivity {

    private static final JumpLogic[] LIST = new JumpLogic[]{
            new JumpLogic("com.zhihaoliang.roomtest.ui.RoomActivity", "数据库Room，增删改查操作")
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcylerToActivity = findViewById(R.id.rcyler_to_activity);
        rcylerToActivity.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        rcylerToActivity.setAdapter(new MyAdpater());
    }

    class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {

        @NonNull
        @Override
        public MyAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View item = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_list_item_activated_1, viewGroup, false);
            return new ViewHolder(item);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdpater.ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(LIST[i].getDes());
        }

        @Override
        public int getItemCount() {
            return LIST.length;
        }

        protected class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            private ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(android.R.id.text1);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        goToActivity(LIST[getAdapterPosition()].getJumpClass());
                    }
                });
            }
            private void goToActivity(String name) {

                try {
                    Intent intent = new Intent(getBaseContext(), getClass().getClassLoader().loadClass(name));
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    Logger.e(e.getMessage());
                }

            }
        }

    }


}
