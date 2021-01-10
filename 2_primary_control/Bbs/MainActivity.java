package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {
    private TextView tv_bbs;
    private TextView tv_control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_control = findViewById(R.id.tv_control);
        // 给tv_control设置点击监听器
        tv_control.setOnClickListener(this);
        // 给tv_control设置长按监听器
        tv_control.setOnLongClickListener(this);

        tv_bbs = findViewById(R.id.tv_bbs);
        tv_bbs.setOnClickListener(this);
        tv_bbs.setOnLongClickListener(this);
//        tv_bbs.setGravity(Gravity.LEFT | Gravity.BOTTOM);
//        // 设置tv_bbs高度为八行文字那么高
//        tv_bbs.setLines(8);
//        // 设置tv_bbs最多显示八行文字
//        tv_bbs.setMaxLines(8);
        // 设置tv_bbs内部文本的移动方式为滚动形式
        tv_bbs.setMovementMethod(new ScrollingMovementMethod());
    }

    private String[] mChatStr = {"你吃饭了吗？","今天天气真好呀。","我中奖了！","我们去看电影吧","晚上干甚好呢"};
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs) {
            // 生成一个0到4之间的随机数
            int random = (int)(Math.random() * 10) % 5;
            // 拼接聊天的文本内容
            String newstr = String.format("%s\n%s %s",
                    tv_bbs.getText().toString() , getNowTime(), mChatStr[random]);
            // 设置文本视图tv_bbs的文本内容
            tv_bbs.setText(newstr);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.tv_control || v.getId() == R.id.tv_bbs) {
            tv_bbs.setText("");
        }
        return true;
    }

    public static String getNowTime() {//设置当前时间
        SimpleDateFormat s_format = new SimpleDateFormat("HH:mm:ss");
        return s_format.format(new Date());
    }
}