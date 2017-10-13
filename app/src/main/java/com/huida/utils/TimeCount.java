package com.huida.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

public class TimeCount extends CountDownTimer {
    private TextView tvCode;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimeCount(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tvCode = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
//        tvCode.setBackgroundResource(R.drawable.regist_suc);
        tvCode.setTextSize(13);
        tvCode.setText("(" + millisUntilFinished / 1000 + "秒)重新获取");
        tvCode.setClickable(false);
    }

    @Override
    public void onFinish() {
//        tvCode.setBackgroundResource(R.drawable.regist_suc);
        tvCode.setTextSize(13);
        tvCode.setText("获取验证码");
        tvCode.setClickable(true);
    }
}