package com.qingyang.bistro.net.request;

import com.google.gson.annotations.Expose;

/**
 * Created by QingYang on 15/6/17.
 */
public class SignInRequest2 {

    @Expose
    private String id;
    @Expose
    private String action;
    @Expose
    private String username;
    @Expose
    private String password;

    public SignInRequest2(String username, String passowrd){
        id = "leepet_thread:api";
        action = "login";
        this.username = username;
        //this.userpwd = MD5Util.getMD5String(passowrd);
        this.password = passowrd;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return password;
    }

    public void setUserpwd(String userpwd) {
        this.password = userpwd;
    }

}
