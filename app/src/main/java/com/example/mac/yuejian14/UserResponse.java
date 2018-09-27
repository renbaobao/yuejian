package com.example.mac.yuejian14;

/**
 * Created by mac on 2018/9/25.
 */

public class UserResponse {
        private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
