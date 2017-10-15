package com.huida.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.huida.R;
import com.huida.activity.DynamicActivity;

/**
 * Created by Liu on 2017/10/14.
 */

public class DyReviewFragment extends BaseFragment {

    private ImageButton back;
    private FragmentManager manager;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_review, null);
        back = (ImageButton) view.findViewById(R.id.iv_review_back);
        return view;
    }

    @Override
    public void initData() {
        manager = getFragmentManager();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicFragment dynamicFragment = DynamicFragment.newInstance("msg");
                FragmentTransaction ft = manager.beginTransaction();
               ft.replace(R.id.fl_dymic,dynamicFragment);
               ft.addToBackStack(null);
               ft .commit();



            }
        });
    }
}
