package com.huida.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.huida.R;
import com.huida.activity.DynamicActivity;

/**
 * Created by Liu on 2017/10/15.
 */

public class DynamicFragment extends BaseFragment {

    private RadioGroup rg_dy;
    private FragmentManager manager;
    private String rgflag="state";


    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_dymic, null);
        rg_dy = (RadioGroup)view.findViewById(R.id.rg_dy);
        return view;
    }

    public static DynamicFragment newInstance(String flag) {
        DynamicFragment fragment = new DynamicFragment();
        Bundle args = new Bundle();
        args.putString("rgflag",flag);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (getArguments() != null) {
            Log.e("lrs", "null: ");
            rgflag = getArguments().getString("rgflag");

        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initData() {
        manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        if (rgflag.equals("msg")){
            rg_dy.check(R.id.rb_dy_msg);
            ft.replace(R.id.fl_dy, new DyMsgFragment()).commit();
        }else {
            rg_dy.check(R.id.rb_dy_state);
            ft.replace(R.id.fl_dy, new DyStateFragment()).commit();
        }
       /* rg_dy.check(R.id.rb_dy_state);
        ft.replace(R.id.fl_dy,new DyStateFragment()).commit();*/

        rg_dy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction ft = manager.beginTransaction();
                switch (checkedId){
                    case R.id.rb_dy_state:
                        ft.replace(R.id.fl_dy,new DyStateFragment());
                        break;
                    case R.id.rb_dy_msg:
                        ft.replace(R.id.fl_dy,new DyMsgFragment());
                        break;
                }
                ft.commit();
            }
        });
    }
}
