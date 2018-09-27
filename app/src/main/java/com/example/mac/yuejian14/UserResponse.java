package com.example.mac.yuejian14;

/**
 * Created by mac on 2018/9/25.
 */

public class UserResponse {
        private String uid;
        private  String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

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
