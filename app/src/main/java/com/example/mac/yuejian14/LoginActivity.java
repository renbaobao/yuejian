package com.example.mac.yuejian14;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mac.yuejian14.databinding.LoginBinding;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class LoginActivity extends Activity {
    private LoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.login);
        binding.loginButton.setOnClickListener(v -> login());
        binding.toRegisterButton.setOnClickListener(v ->startActivity(new Intent(LoginActivity.this,RegisterActivity.class) ) );
    }

    private void login() {
        if (TextUtils.isEmpty(binding.userName.getText().toString().trim())) {
            Toast.makeText(this, R.string.username_can_not_null, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(binding.password.getText().toString().trim())) {
            Toast.makeText(this, R.string.password_not_null, Toast.LENGTH_SHORT).show();
            return;
        }
        UserModel.getIns().login(binding.userName.getText().toString().trim(), binding.password.getText().toString().trim())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(userResponse -> {
                    if (!userResponse.getUid().equals("0")){
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    }
            else {
                        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                    }
        },throwable -> {
            Toast.makeText(this,throwable.getMessage(), Toast.LENGTH_SHORT).show();
        });


    }
}
