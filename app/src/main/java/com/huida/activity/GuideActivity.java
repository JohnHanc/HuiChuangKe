package com.huida.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

import com.huida.R;

/**
 * Created by Han on 2017/10/1.
 */

public class GuideActivity extends BaseActivity {

    //private UpdateVersionBean versionBean;
    private boolean isStep = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    isStep = false;
                    break;
                case 1:
                    isStep = true;
                    break;
            }
        }
    };
    private ValueAnimator valueAnimator;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initData() {
        final Window window = getWindow();
        valueAnimator = ValueAnimator.ofFloat(0.2f, 1f);
        valueAnimator.setDuration(3500);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.alpha = (float) animation.getAnimatedValue();
                window.setAttributes(params);
            }
        });
        valueAnimator.start();
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
               /* String update = AppConstants.SERVE_URL+"index/version/version";
                HashMap<String, String> params = new HashMap<>();
                try {
                    OkHttpUtil.postString(update, params, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            handler.sendEmptyMessage(0);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String result = OkHttpUtil.getResult(response);
                            if(result!=null){
                                Gson gson = new Gson();
                                versionBean = gson.fromJson(result, UpdateVersionBean.class);
                                try {
                                    PackageManager pm = WelcomeActivity.this.getPackageManager();
                                    PackageInfo pi = pm.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
                                    String versionName = pi.versionName;
                                    int i = versionName.compareTo(versionBean.vision);
                                    if(i==0){
                                        handler.sendEmptyMessage(0);
                                    }else if(i==-1){
                                        handler.sendEmptyMessage(1);
                                    }
                                } catch (PackageManager.NameNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void onAnimationEnd(Animator animation) {
/*                boolean aBoolean = SPUtil.getBoolean(AppConstants.IS_OPENMAIN, GuideActivity.this);
                Intent intent;
                if(aBoolean){
                    if(isStep){
                        showIfUpdate(versionBean);
                    }else{
                        intent = new Intent(GuideActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }else{*/
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                //}
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void initLisitenr() {

    }

/*
    private void showIfUpdate(UpdateVersionBean versionBean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("检测到有更新");
        builder.setMessage("是否更新？");
        builder.setNegativeButton("现在更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //TODO  更新逻辑
            }
        });
        builder.setPositiveButton("暂不更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }*/

}
