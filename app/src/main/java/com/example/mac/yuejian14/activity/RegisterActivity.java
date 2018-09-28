package com.example.mac.yuejian14.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;

import com.example.mac.yuejian14.R;
import com.example.mac.yuejian14.bean.UserModel;
import com.example.mac.yuejian14.databinding.ActivityRegisterBinding;
import com.example.mac.yuejian14.utils.SharpenersUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterActivity extends BaseActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        binding.registerButton.setOnClickListener(v -> register());
        binding.textToLogin.setOnClickListener(v -> startActivity(new Intent(RegisterActivity.this, LoginActivity.class)));
    }

    private void register() {
        String username=binding.userName.getText().toString().trim();
        String password=binding.password.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            toastMsg(getString(R.string.username_can_not_null));
            return;
        }
        if (TextUtils.isEmpty(password)){
            toastMsg(getString(R.string.password_not_null));
            return;
        }
        UserModel.getIns().register(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(userResponse -> {
                    if (!userResponse.getSuccess().equals("0")) {
                        toastMsg("注册成功");
                        SharpenersUtil.getIns().setUsername(username);
                        SharpenersUtil.getIns().setPassword(password);
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else toastMsg("注册失败");
                }, throwable -> toastMsg(throwable.getMessage())
        );
    }
}

