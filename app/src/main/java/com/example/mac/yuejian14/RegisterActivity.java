package com.example.mac.yuejian14;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.mac.yuejian14.databinding.ActivityRegisterBinding;

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
    }

    private void register() {
        if (TextUtils.isEmpty(binding.userName.getText().toString().trim())) {
            Toast.makeText(this, R.string.username_can_not_null, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(binding.password.getText().toString().trim())) {
            Toast.makeText(this, R.string.password_not_null, Toast.LENGTH_SHORT).show();
            return;
        }
        UserModel.getIns().register(binding.userName.getText().toString().trim(), binding.password.getText().toString().trim())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(userResponse -> {
                    if (!userResponse.getSuccess().equals("0")) {
                        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
                }, throwable -> Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show()
        );
    }
}

