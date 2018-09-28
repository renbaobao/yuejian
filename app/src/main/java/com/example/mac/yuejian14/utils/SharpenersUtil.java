package com.example.mac.yuejian14.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mac.yuejian14.App;

/**
 * Created by mac on 2018/9/28.
 */

public class SharpenersUtil {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private  static SharpenersUtil sharpenersUtil =null;
    public static SharpenersUtil getIns(){
        if (sharpenersUtil==null){
            sharpenersUtil=new SharpenersUtil();
        }
        return null;
    }
    public SharpenersUtil(){
        sharedPreferences= App.getContext().getSharedPreferences("YJ", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public void setUsername(String username){
        editor.putString("username",username);
        editor.commit();
    }
    public String getUsername(){
        return sharedPreferences.getString("username",null);
    }
    public void setPassword(String password){
        editor.putString("password",password);
        editor.commit();
    }
    public String getPassword(){
        return sharedPreferences.getString("password",null);
    }
}
