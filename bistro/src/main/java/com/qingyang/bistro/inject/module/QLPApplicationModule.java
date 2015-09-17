package com.qingyang.bistro.inject.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

/**
 * Created by QingYang on 15/9/9.
 */
@Module
public class QLPApplicationModule {

    private final Application mApplication;

    public QLPApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Application provideQLPApplication(){
        return mApplication;
    }

}
