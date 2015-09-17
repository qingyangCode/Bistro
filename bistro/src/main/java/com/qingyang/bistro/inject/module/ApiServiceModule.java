package com.qingyang.bistro.inject.module;

import com.qingyang.bistro.net.ApiService;
import com.qingyang.mainlibrary.api.MainApiManager;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by QingYang on 15/9/9.
 */
@Module
public class ApiServiceModule {

    @Provides
    @Singleton
    ApiService provideQLPApiService() {
        return (ApiService)MainApiManager.getInstance().getApiService();
    }
}
