package com.huida.fragment;

import android.view.View;
import android.widget.TextView;

import com.huida.activity.FindProjectActivity;

/**
 * Created by liling on 2017/9/25.
 */

public class XiFenFragment extends BaseFragment {
    public XiFenFragment(FindProjectActivity findProjectActivity) {
        super();
    }


    @Override
    public View initView() {
        TextView textView=new TextView(mActivity);
        textView.setText("细分");
        textView.setTextSize(20);
        return textView;
    }
}
