package com.qingyang.bistro.net.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.qingyang.bistro.util.MD5Util;

/**
 * Created by QingYang on 15/6/17.
 */
public class SignInRequest {


    @Expose
    private String username;
    @Expose
    private String password;

    public SignInRequest(String username, String passowrd){
        this.username = username;
        this.password = MD5Util.getMD5String(passowrd);

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
