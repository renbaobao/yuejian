package com.example.mac.yuejian14.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mac.yuejian14.R;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    protected void toastMsg(String toastMsg) {
        Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
    }


}
