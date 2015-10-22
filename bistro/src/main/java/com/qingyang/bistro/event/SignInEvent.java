package com.qingyang.bistro.event;

/**
 * Created by QingYang on 15/9/18.
 */
public class SignInEvent {
    private boolean isloginSuccess;
    public SignInEvent(boolean isloginSuccess) {
        this.isloginSuccess = isloginSuccess;
    }

    public boolean isLoginInSuccess() {
        return isloginSuccess;
    }

}
