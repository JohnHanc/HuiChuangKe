package com.huida.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.huida.activity.MainActivity;

/**
 * Created by liling on 2017/9/16.
 * 找人页面
 */

public class FindPersonFragment extends BaseFragment {
    public Activity mActivity;

    public FindPersonFragment(MainActivity mainActivity) {
        super();
        this.mActivity=mainActivity;
    }

    @Override
    public View initView() {
        TextView textView = new TextView(mActivity);
        textView.setText("找人");
        textView.setTextSize(18);
        textView.setTextColor(Color.RED);
        Log.e("liling", "initView: 加载子布局" );
        return textView;
    }
}
