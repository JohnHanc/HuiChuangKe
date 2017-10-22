package com.huida.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.huida.R;

/**
 * Created by Liu on 2017/10/22.
 */

public class SelfDialog extends Dialog {

    /**
     * 创建自定义的dialog，主要学习其实现原理
     * Created by chengguo on 2016/3/22.
     */
        private Button yes;//确定按钮
        private Button no;//取消按钮
        private TextView messageTv;//消息提示文本
        private String titleStr;//从外界设置的title文本
        private String messageStr;//从外界设置的消息文本
        //确定文本和取消文本的显示内容
        private String yesStr, noStr;

        private onNoOnclickListener noOnclickListener;//取消按钮被点击了的监听器
        private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器


    public SelfDialog(@NonNull Context context) {

        super(context,R.style.custom_dialog);

    }


    public SelfDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected SelfDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
         * 设置取消按钮的显示内容和监听
         *
         * @param str
         * @param onNoOnclickListener
         */
        public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {
            if (str != null) {
                noStr = str;
            }
            this.noOnclickListener = onNoOnclickListener;
        }

        /**
         * 设置确定按钮的显示内容和监听
         *
         * @param str
         * @param onYesOnclickListener
         */
        public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {
            if (str != null) {
                yesStr = str;
            }
            this.yesOnclickListener = onYesOnclickListener;
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selfdialog);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);

        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();
    }


        /**
         * 初始化界面的确定和取消监听器
         */
        private void initEvent() {
            //设置确定按钮被点击后，向外界提供监听
            yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (yesOnclickListener != null) {
                        yesOnclickListener.onYesClick();
                    }
                }
            });
            //设置取消按钮被点击后，向外界提供监听
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (noOnclickListener != null) {
                        noOnclickListener.onNoClick();
                    }
                }
            });
        }

        /**
         * 初始化界面控件的显示数据
         */
        private void initData() {
            //如果用户自定了title和message

            if (messageStr != null) {
                messageTv.setText(messageStr);
            }
            //如果设置按钮的文字
            if (yesStr != null) {
                yes.setText(yesStr);
            }
            if (noStr != null) {
                no.setText(noStr);
            }
        }

        /**
         * 初始化界面控件
         */
        private void initView() {
            yes = (Button) findViewById(R.id.yes);
            no = (Button) findViewById(R.id.no);
            messageTv = (TextView) findViewById(R.id.message);
        }


        /**
         * 从外界Activity为Dialog设置dialog的message
         *
         * @param message
         */
        public void setMessage(String message) {
            messageStr = message;
        }


    /**
         * 设置确定按钮和取消被点击的接口
         */
        public interface onYesOnclickListener {
            public void onYesClick();
        }

        public interface onNoOnclickListener {
            public void onNoClick();
        }
    }
