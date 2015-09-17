package com.qingyang.bistro;

import com.qingyang.mainlibrary.MainApplication;
import com.qingyang.mainlibrary.MainConfiguration;

import com.qingyang.bistro.inject.QLPComponent;

/**
 * Created by QingYang on 15/9/7.
 */
public class QLPApplication extends MainApplication{
    private MainConfiguration configuration = new QLPConfig();
    private QLPComponent mComponent;

    @Override public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    private void buildComponentAndInject() {
        mComponent = QLPComponent.Initializer.init(this);
        mComponent.injectApplication(this);
    }

    public QLPComponent getComponent() {
        return mComponent;
    }

    @Override public void onUnAuthorized() {
        //TODO 登录cookie 失效
    }

    @Override protected MainConfiguration getConfiguration() {
        return configuration;
    }
}
