  package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    // 定义自动完成的提示文本数组
    private String[] hintArray = {"第一", "第一次", "第一次写代码", "第一次领工资", "第二", "第二个"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 从布局文件中获取名叫ac_text的自动完成编辑框
        AutoCompleteTextView ac_text = findViewById(R.id.ac_text);
        // 声明一个自动完成时下拉展示的数组适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.item_dropdown, hintArray);
        // 设置自动完成编辑框的数组适配器
        ac_text.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {

    }
}