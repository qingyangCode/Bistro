package com.qingyang.bistro.inject.module;

import com.qingyang.bistro.inject.interactor.LoginHomeInteractor;
import com.qingyang.bistro.inject.interactor.impl.LoginHomeInteractorImpl;
import com.qingyang.bistro.inject.presenter.LoginHomePresenter;
import com.qingyang.bistro.inject.presenter.impl.LoginHomePresenterImpl;
import com.qingyang.bistro.inject.repository.LoginHomeRepository;
import com.qingyang.bistro.inject.repository.impl.LoginHomeRepositoryImpl;
import com.qingyang.bistro.net.ApiService;
import com.qingyang.bistro.view.LoginHomeView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by QingYang on 15/9/10.
 */
@Module
public class LoginHomeModule {

    private LoginHomeView mLoginHomeView;

    public LoginHomeModule(LoginHomeView loginHomeView) {
        this.mLoginHomeView = loginHomeView;
    }

    @Provides
    LoginHomeView provideLoginHomeView() {
        return mLoginHomeView;
    }

    @Provides
    LoginHomePresenter provideLoginHomePresenter(LoginHomeView loginHomeView, LoginHomeInteractor loginHomeInteractor) {
        return new LoginHomePresenterImpl(loginHomeView, loginHomeInteractor);
    }

    @Provides
    LoginHomeInteractor provideLoginHomeInteractor(LoginHomeRepository repository) {
        return new LoginHomeInteractorImpl(repository);
    }

}
