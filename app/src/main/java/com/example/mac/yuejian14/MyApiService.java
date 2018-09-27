package com.example.mac.yuejian14;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mac on 2018/9/25.
 */

public interface MyApiService {
    @GET("User/getUserById")
    Observable<UserResponse> login(@Query("username") String username, @Query("userpassword") String password);
}
