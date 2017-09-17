package com.huida.activity;

import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.huida.R;
import com.huida.fragment.BaseFragment;
import com.huida.fragment.ButtJointFragment;
import com.huida.fragment.DynamicFragment;
import com.huida.fragment.FindPersonFragment;
import com.huida.fragment.FindProjectFragment;
import com.huida.fragment.MineFragment;

import java.util.ArrayList;

/**
 * 5个radiobutton  1个帧布局
 */

public class MainActivity extends BaseActivity {

    private FrameLayout fl_main;
    private RadioGroup rg_main;
    private ArrayList<BaseFragment> fragmentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //

    }

    @Override
    public View ininView() {
        View view = View.inflate(this, R.layout.activity_main, null);
        fl_main = (FrameLayout) view.findViewById(R.id.fl_main);
        rg_main = (RadioGroup) view.findViewById(R.id.rg_main);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //默认 找人 选中
        rg_main.check(R.id.rb_findperson);

        //添加5个fragment
        fragmentlist = new ArrayList<BaseFragment>();
        fragmentlist.add(new FindPersonFragment(this));
        fragmentlist.add(new FindProjectFragment(this));
        fragmentlist.add(new DynamicFragment(this));
        fragmentlist.add(new ButtJointFragment(this));
        fragmentlist.add(new MineFragment(this));
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_main,fragmentlist.get(0));
        fragmentTransaction.add(fragmentlist.get(1),"");
        fragmentTransaction.add(fragmentlist.get(2),"");
        fragmentTransaction.add(fragmentlist.get(3),"");
        fragmentTransaction.add(fragmentlist.get(4),"");
        fragmentTransaction.commit();

//        fl_main.addView(fragmentlist.get(0).rootview);
//       if (fl_main.getChildCount()==0){
//            View rootView = fragmentlist.get(0).rootview;
//           fl_main.removeAllViews();
//            fl_main.addView(rootView);
//
//
//
//        }


        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                fl_main.removeAllViews();
                switch (i){
                    case R.id.rb_findperson:

                        //找人
                        fl_main.addView(fragmentlist.get(0).rootview);
                        break;
                    case R.id.rb_findproject:
                        //找项目
                        rg_main.check(R.id.rb_findproject);
                        fl_main.addView(fragmentlist.get(1).rootview);

                        break;
                    case R.id.rb_dynamic:
                        //动态
                        rg_main.check(R.id.rb_dynamic);
                        fl_main.addView(fragmentlist.get(2).rootview);
                        break;
                    case R.id.rb_butt:
                        //对接
                        rg_main.check(R.id.rb_butt);
                        fl_main.addView(fragmentlist.get(3).rootview);
                        break;
                    case R.id.rb_mine:
                        //我的
                        rg_main.check(R.id.rb_mine);
                        fl_main.addView(fragmentlist.get(4).rootview);
                        break;
                }
            }
        });

    }
}
