package com.example.mac.yuejian14;

import rx.Observable;

/**
 * Created by mac on 2018/9/26.
 */

public class UserModel {
    private static UserModel userModel=null;
    public  static   UserModel getIns(){
        if (userModel==null){
            userModel=new  UserModel();
        }
        return userModel;
    }
    public Observable<UserResponse> login(String username, String password){
      return   MyApiFactory.getIns().getService().login(username,password);
    }
    public  Observable<UserResponse>register(String username,String password){
        return MyApiFactory.getIns().getService().register(username,password);
    }
}
