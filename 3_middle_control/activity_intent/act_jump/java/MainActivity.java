package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG = "MainActivity";
    private TextView tv_life; // 声明一个文本视图对象
    private String mStr = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_act_next).setOnClickListener(this);
        tv_life = findViewById(R.id.tv_life);
        refreshLife("onCreate");
    }

    private void refreshLife(String desc) {
        Log.d(TAG, desc);
        mStr = String.format("%s%s %s %s\n", mStr, DateUtil.getNowTimeDetail(), TAG, desc);
        tv_life.setText(mStr);
    }

    @Override
    protected void onStart() { // 开始活动页面
        refreshLife("onStart");
        super.onStart();
    }

    @Override
    protected void onStop() { // 停止活动页面
        refreshLife("onStop");
        super.onStop();
    }

    @Override
    protected void onResume() { // 恢复活动页面
        refreshLife("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() { // 暂停活动页面
        refreshLife("onPause");
        super.onPause();
    }

    protected void onRestart() { // 重启活动页面
        refreshLife("onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() { // 销毁活动页面
        refreshLife("onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_act_next) {
            // 准备跳到下个活动页面ActNextActivity
            Intent intent = new Intent(this, com.example.checkbox.ActNextActivity.class);
            // 期望接收下个页面的返回数据
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { // 接收返回数据
        super.onActivityResult(requestCode, resultCode, data);
        String nextLife = data.getStringExtra("life");
        refreshLife("\n" + nextLife);
        refreshLife("onActivityResult");
    }

}