package com.example.mac.yuejian14;

import android.app.Application;
import android.content.Context;

/**
 * Created by mac on 2018/9/28.
 */

public class App extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
