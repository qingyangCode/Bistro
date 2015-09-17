package com.qingyang.bistro.inject;

import com.qingyang.bistro.QLPApplication;
import com.qingyang.bistro.inject.module.ApiServiceModule;
import com.qingyang.bistro.inject.module.QLPApplicationModule;
import com.qingyang.bistro.inject.module.RepositoryMoudle;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by QingYang on 15/9/9.
 */
@Singleton
@Component(modules = {QLPApplicationModule.class, ApiServiceModule.class, RepositoryMoudle.class})
public interface QLPComponent extends QLPGraph{

    final static class Initializer {
        public static QLPComponent init(QLPApplication app) {
            return DaggerQLPComponent.builder()
                    .qLPApplicationModule(new QLPApplicationModule(app))
                    .build();
        }
        private Initializer() {} // No instances.
    }
}
