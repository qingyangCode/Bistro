package com.qingyang.bistro;

import android.app.Application;
import com.qingyang.mainlibrary.MainApplication;
import com.qingyang.mainlibrary.MainConfiguration;

/**
 * Created by QingYang on 15/9/7.
 */
public class QLPApplication extends MainApplication{
    private MainConfiguration configuration = new QLPConfig();



    @Override public void onCreate() {
        super.onCreate();

    }

    @Override public void onUnAuthorized() {
        //TODO 登录cookie 实效
    }

    @Override protected MainConfiguration getConfiguration() {
        return configuration;
    }
}
