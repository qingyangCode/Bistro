package com.qingyang.bistro.inject.interactor.impl;

import com.qingyang.bistro.inject.interactor.LoginHomeInteractor;
import com.qingyang.bistro.inject.repository.LoginHomeRepository;

/**
 * Created by QingYang on 15/9/10.
 */
public class LoginHomeInteractorImpl implements LoginHomeInteractor{

    private final LoginHomeRepository mRepository;

    public LoginHomeInteractorImpl(LoginHomeRepository loginHomeRespotry) {
        this.mRepository = loginHomeRespotry;
    }
}
