package com.qingyang.bistro.inject.compontent;

import com.qingyang.bistro.fragments.SignInFragment;
import com.qingyang.bistro.inject.QLPComponent;
import com.qingyang.bistro.inject.module.LoginHomeModule;
import com.qingyang.mainlibrary.inject.PerActivity;
import dagger.Component;

/**
 * Created by QingYang on 15/9/10.
 */

@PerActivity
@Component(
        dependencies = {QLPComponent.class},
        modules = {LoginHomeModule.class}
)
public interface LoginHomeCompontent {

    void injectSignIn(SignInFragment signInFragment);
}
