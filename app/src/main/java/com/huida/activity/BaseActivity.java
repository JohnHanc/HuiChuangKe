package com.huida.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by liling on 2017/9/16.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view =ininView();
        setContentView(view);

        initData();

    }

    protected  void initData(){

    }

    abstract public  View ininView() ;

}
