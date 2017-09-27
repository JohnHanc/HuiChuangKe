package com.huida.pager;

import android.app.Activity;
import android.view.View;

/**
 * Created by liling on 2017/9/25.
 */

public abstract  class BasePager  {
    public Activity mActivity;

    public BasePager(Activity mActivity) {
        this.mActivity = mActivity;
    }
    public abstract View initView();
    public abstract  void  initData();

}
