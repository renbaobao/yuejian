package com.example.mac.yuejian14.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mac.yuejian14.R;
import com.example.mac.yuejian14.bean.UserModel;
import com.example.mac.yuejian14.databinding.LoginBinding;
import com.example.mac.yuejian14.utils.SharpenersUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginActivity extends BaseActivity {
    private LoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        binding.loginButton.setOnClickListener(v -> login());
        binding.toRegisterButton.setOnClickListener(v ->startActivity(new Intent(LoginActivity.this,RegisterActivity.class) ) );
        binding.userName.setText(SharpenersUtil.getIns().getUsername());
        binding.password.setText(SharpenersUtil.getIns().getPassword());
    }

    private void login() {
        String username=binding.userName.getText().toString().trim();
        String password=binding.password.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            toastMsg(getString(R.string.username_can_not_null));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            toastMsg(getString(R.string.password_not_null));
            return;
        }
        UserModel.getIns().login(username,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(userResponse -> {
                    if (!userResponse.getUid().equals("0")){
                        toastMsg("登录成功");
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    } else toastMsg("登录失败");
        },throwable -> Toast.makeText(this,throwable.getMessage(), Toast.LENGTH_SHORT).show());

    }
}
