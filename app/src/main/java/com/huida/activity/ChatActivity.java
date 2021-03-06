package com.huida.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huida.R;

/**
 * Created by Liu on 2017/10/15.
 */

public class ChatActivity extends BaseActivity {

    private ImageView back;
    private TextView set;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.iv_chat_back);
        set = (TextView) findViewById(R.id.tv_chat_set);

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 初始化监听器
     */
    @Override
    protected void initLisitenr() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, ChatSetActivity.class);
                startActivity(intent);
            }
        });

    }
}
