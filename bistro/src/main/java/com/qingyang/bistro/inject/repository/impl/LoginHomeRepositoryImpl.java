package com.qingyang.bistro.inject.repository.impl;

import com.qingyang.bistro.inject.repository.LoginHomeRepository;
import com.qingyang.bistro.net.ApiService;

/**
 * Created by QingYang on 15/9/10.
 */
public class LoginHomeRepositoryImpl implements LoginHomeRepository{

    private final ApiService mApiService;

    public LoginHomeRepositoryImpl(ApiService apiService) {
        if (apiService == null)
            throw new IllegalArgumentException("LoginHomeRepositoryImpl service can not be null!");
        this.mApiService = apiService;
    }
}
