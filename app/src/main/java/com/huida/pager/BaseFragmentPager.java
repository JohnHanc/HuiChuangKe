package com.huida.pager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by gui on 2017/7/21.
 */

public abstract class BaseFragmentPager extends Fragment implements View.OnClickListener{
    public FragmentActivity mActivity;
    public View rootview;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (FragmentActivity) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = initView();

        return rootview;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
    }
    public abstract View initView();
    public void initData(){

    }
    protected abstract void initListener();
}
