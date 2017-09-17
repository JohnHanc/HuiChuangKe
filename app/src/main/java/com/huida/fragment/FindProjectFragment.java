package com.huida.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.huida.activity.MainActivity;

/**
 * Created by liling on 2017/9/16.
 * 找项目页面
 */

public class FindProjectFragment extends BaseFragment {
    public Activity mActivity;

    public FindProjectFragment(MainActivity mainActivity) {
        super();
        this.mActivity=mainActivity;
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mActivity);
        textView.setText("找项目");
        textView.setTextSize(18);
        textView.setTextColor(Color.RED);
        return textView;
    }
}
