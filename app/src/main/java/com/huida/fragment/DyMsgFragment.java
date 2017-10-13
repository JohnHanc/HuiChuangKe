package com.huida.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Liu on 2017/9/17.
 */

public class DyMsgFragment extends BaseFragment {
    @Override
    public View initView() {

        TextView textView = new TextView(mActivity);
        textView.setText("消息");
        textView.setTextSize(18);
        textView.setTextColor(Color.RED);
        return textView;
    }
}
