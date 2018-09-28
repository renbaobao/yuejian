package com.example.mac.yuejian14.internet;

import com.example.mac.yuejian14.bean.UserResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mac on 2018/9/25.
 */

public interface MyApiService {
    @GET("User/getUserById")
    Observable<UserResponse> login(@Query("username") String username, @Query("userpassword") String password);

    @GET("User/userReg")
    Observable<UserResponse> register(@Query("username") String username, @Query("userpassword") String password);
}
