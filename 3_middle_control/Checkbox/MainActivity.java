package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 从布局文件中获取名叫ck_system、ck_custom的复选框
        CheckBox ck_system = findViewById(R.id.ck_system);
        CheckBox ck_custom = findViewById(R.id.ck_custom);

        // 给ck_system、ck_custom设置勾选监听器，一旦用户点击复选框，就触发监听器的onCheckedChanged方法
        ck_system.setOnCheckedChangeListener(this);
        ck_custom.setOnCheckedChangeListener(this);
        //下面点击事件会冲突前面的点击事件

        // 给ck_system、ck_custom设置勾选监听器，一旦用户点击复选框，就触发监听器的onCheckedChanged方法
        ck_system.setOnCheckedChangeListener(new CheckListener());
        ck_custom.setOnCheckedChangeListener(new CheckListener());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String desc = String.format("您%s按了这个CheckBox", isChecked ? "勾选" : "取消勾选");
        buttonView.setText(desc);
    }

    // 定义一个勾选监听器，它实现了接口CompoundButton.OnCheckedChangeListener
    private class CheckListener implements CompoundButton.OnCheckedChangeListener {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String desc = String.format("您勾选了控件%d，状态为%b", buttonView.getId(), isChecked);
            //点击复选框时会提示出相关信息
            Toast.makeText(MainActivity.this, desc, Toast.LENGTH_LONG).show();
        }
    }
}