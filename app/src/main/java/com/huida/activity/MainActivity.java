package com.huida.activity;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.huida.R;


public class MainActivity extends ActivityGroup {
    private  LinearLayout one,two,three,four,five,bodyView;
    private RadioGroup rg_main;
    private int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("liling", "onCreate: "+"liling" );
        setContentView(R.layout.activity_main);
        initMainView();
        initData();
        showView(flag);

    }
    public void showView(int flag) {
        Log.e("liling", "showView: "+"showview" );
        switch (flag) {
            case 0:
                bodyView.removeAllViews();
                View v = getLocalActivityManager().startActivity("one",
                        new Intent(this, FindPersonActivity.class)).getDecorView();



                bodyView.addView(v);
                break;
            case 1:
                bodyView.removeAllViews();
                bodyView.addView(getLocalActivityManager().startActivity("two",
                        new Intent(this, FindProjectActivity.class))
                        .getDecorView());

                break;
            case 2:
                bodyView.removeAllViews();
                bodyView.addView(getLocalActivityManager().startActivity(
                        "three", new Intent(this, DynamicActivity.class))
                        .getDecorView());


                break;
            case 3:
                bodyView.removeAllViews();
                bodyView.addView(getLocalActivityManager().startActivity(
                        "four", new Intent(this, DuttActivity.class))
                        .getDecorView());

                break;
            case 4:
                bodyView.removeAllViews();
                bodyView.addView(getLocalActivityManager().startActivity(
                        "five", new Intent(this, MineActivity.class))
                        .getDecorView());

                break;
            default:
                break;
        }
    }


    private void initData() {
        Log.e("liling", "initData: "+"initdata");
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.rb_findperson:
                    showView(0);

                        break;
                    case R.id.rb_findproject:
                        showView(1);
                        break;
                    case R.id.rb_dynamic:
                        showView(2);
                        break;
                    case  R.id.rb_butt:
                        showView(3);
                        break;
                    case R.id.rb_mine:
                        showView(4);
                        break;
                }
            }
        });

    }

    private void initMainView() {
        one=(LinearLayout) findViewById(R.id.one);
        two=(LinearLayout) findViewById(R.id.two);
        three=(LinearLayout) findViewById(R.id.three);
        four=(LinearLayout) findViewById(R.id.four);
        five=(LinearLayout) findViewById(R.id.five);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        bodyView=(LinearLayout) findViewById(R.id.body);



    }
}
