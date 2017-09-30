package com.huida.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.huida.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Han on 2017/9/30.
 */

public class LoginActivity extends Activity {
    @BindView(R.id.tv_zone)
    TextView mTvZone;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.tv_getCode)
    TextView mTvGetCode;
    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.ib_qq)
    ImageButton mIbQq;
    @BindView(R.id.ib_vx)
    ImageButton mIbVx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_zone, R.id.et_phone, R.id.et_code, R.id.tv_getCode, R.id.bt_login, R.id.ib_qq, R.id.ib_vx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_zone:

                break;
            case R.id.et_phone:
                break;
            case R.id.et_code:
                break;
            case R.id.tv_getCode:
                String number = mEtPhone.getText().toString();


                boolean judge = isMobile(number);
                if (TextUtils.isEmpty(number))
                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                else if (judge == false) {
                    Toast.makeText(this, "手机号格式错误", Toast.LENGTH_SHORT).show();
                }else {
                    
                }
                break;
            case R.id.bt_login:
                break;
            case R.id.ib_qq:
                break;
            case R.id.ib_vx:
                break;
        }
    }

    public static boolean isMobile(String mobiles) {
/*
移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
联通：130、131、132、152、155、156、185、186
电信：133、153、180、189、（1349卫通）/^0?1[3|4|5|7|8][0-9]\d{8}$/
总结起来就是第一位必定为1，第二位必定为3或5或8或7（电信运营商），其他位置的可以为0-9
*/
        String telRegex = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        return mobiles.matches(telRegex);
    }


}
