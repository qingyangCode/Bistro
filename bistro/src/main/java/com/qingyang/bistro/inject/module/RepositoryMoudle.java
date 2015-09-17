package com.qingyang.bistro.inject.module;

import com.qingyang.bistro.inject.repository.LoginHomeRepository;
import com.qingyang.bistro.inject.repository.impl.LoginHomeRepositoryImpl;
import com.qingyang.bistro.net.ApiService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by QingYang on 15/9/9.
 */
@Module
public class RepositoryMoudle {

    @Provides
    @Singleton LoginHomeRepository provideLoginHomeRespository(ApiService apiService) {
        return new LoginHomeRepositoryImpl(apiService);
    }
}
