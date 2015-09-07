package com.qingyang.bistro;

import com.qingyang.mainlibrary.MainConfiguration;

/**
 * Created by QingYang on 15/9/8.
 */
public class QLPConfig implements MainConfiguration {
    @Override public int getLogLevel() {
        return 0;
    }

    @Override public String getServerUrl() {
        return null;
    }

    @Override public String getUserAgent() {
        return null;
    }

    @Override public Class getApiServiceType() {
        return null;
    }

    @Override public boolean getEnableCrashReport() {
        return false;
    }

    @Override public boolean getEnableEventTracking() {
        return false;
    }

    @Override public String getMATAdvertiserId() {
        return null;
    }

    @Override public String getMATConversionId() {
        return null;
    }

    @Override public String getDBName() {
        return null;
    }

    @Override public int getDBVersion() {
        return 0;
    }
}
