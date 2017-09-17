package com.huida.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liling on 2017/9/16.
 * fragment基类
 */

public abstract class BaseFragment extends Fragment {

    public Activity mActivity;
    public View rootview;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootview = initView();
        return rootview;
    }

    @Override
    public void onStart() {
        super.onStart();
        initData();
    }

    abstract public View initView() ;
    public  void  initData(){

    }
}
