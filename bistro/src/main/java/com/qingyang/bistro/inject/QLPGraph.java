package com.qingyang.bistro.inject;

import com.qingyang.bistro.QLPApplication;
import com.qingyang.bistro.inject.repository.LoginHomeRepository;
import com.qingyang.bistro.net.ApiService;

/**
 * Created by QingYang on 15/9/9.
 */
public interface QLPGraph {

    void injectApplication(QLPApplication application);

    ApiService getApiService();

    LoginHomeRepository getLoginHomeRepostiory();
}
