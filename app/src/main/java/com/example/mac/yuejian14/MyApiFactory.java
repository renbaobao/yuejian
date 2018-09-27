package com.example.mac.yuejian14;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mac on 2018/9/25.
 */

public class MyApiFactory {
    private static MyApiFactory myApiFactory = null;

    public static MyApiFactory getIns() {
        if (myApiFactory == null)
            myApiFactory = new MyApiFactory();
        return myApiFactory;
    }

    public MyApiService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getClient())
                .baseUrl("http://10.0.2.2/neu12_yuejian/index.php/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MyApiService service = retrofit.create(MyApiService.class);
        return service;
    }

    public OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        builder.connectTimeout(60, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        return client;
    }
}
