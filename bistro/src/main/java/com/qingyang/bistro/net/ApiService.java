package com.qingyang.bistro.net;

import com.qingyang.bistro.net.request.SignInRequest;
import com.qingyang.bistro.net.request.UserInfoResponse;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by QingYang on 15/9/8.
 */
public interface ApiService {

    @POST("/plugin.php?id=leepet_thread:api&action=login")
    void signIn(@Body SignInRequest request, Callback<UserInfoResponse> callback);

}
