package com.huida.pager;

import android.app.Activity;
import android.view.View;

import com.huida.R;

/**
 * Created by liling on 2017/9/30.
 */

public class ZaoMengShiPager extends  BasePager {
    public ZaoMengShiPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.xinfen_vp_layout,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
