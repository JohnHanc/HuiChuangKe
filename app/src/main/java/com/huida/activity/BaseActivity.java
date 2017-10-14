package com.huida.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by liling on 2017/9/25.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        Log.e("liling", "onCreate: "+getLayoutId() );
        initView();
        initData();
        initLisitenr();

    }

    @Override
    protected void onStart() {
        super.onStart();
      //  initData();
        initLisitenr();
    }


    protected abstract int getLayoutId();

    /**
     * 初始化View
     */
    public abstract void initView() ;

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听器
     */
    protected abstract void initLisitenr();

}
