package com.qingyang.bistro.net;

import com.qingyang.bistro.net.request.SignInRequest;
import com.qingyang.bistro.net.request.SignInRequest2;
import com.qingyang.bistro.net.request.UserInfoResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by QingYang on 15/9/8.
 */
public interface ApiService {
    //http://dhc001.pagekite.me/jiuAPP/login/loginController/loginapp.action
    @POST("/jiuAPP/login/loginController/loginapp2.action")
    void signIn(@Body SignInRequest request, Callback<UserInfoResponse> callback);

    @FormUrlEncoded
    @POST("/jiuAPP/login/loginController/loginapp.action")
    UserInfoResponse signIn(@Field("username") String userName, @Field("userpwd") String password);

}
