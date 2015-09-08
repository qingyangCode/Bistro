package com.qingyang.bistro;

import com.qingyang.bistro.net.ApiService;
import com.qingyang.mainlibrary.MainConfiguration;
import java.util.Locale;

/**
 * Created by QingYang on 15/9/8.
 */
public class QLPConfig implements MainConfiguration {
    @Override
    public int getLogLevel() {
        return BuildConfig.LOG_LEVEL;
    }

    @Override
    public String getServerUrl() {
        return BuildConfig.SERVER_URL;
    }

    @Override
    public boolean getEnableCrashReport() {
        return BuildConfig.ENABLE_CRASH_REPORT;
    }

    @Override
    public String getMATAdvertiserId() {
        return BuildConfig.MAT_ADVERTISER_ID;
    }

    @Override
    public String getMATConversionId() {
        return BuildConfig.MAT_CONVERSION_ID;
    }

    @Override
    public int getDBVersion() {
        return BuildConfig.DB_VERSION;
    }


    @Override
    public String getUserAgent() {
        //BuildConfig.APP_SPORT_TYPE +
        return  " Android; version:" + BuildConfig.VERSION_NAME + "; "
                + "versioncode:" + BuildConfig.VERSION_CODE + "; "
                + "android:" + android.os.Build.VERSION.RELEASE + "; "
                + "androidcode:" + android.os.Build.VERSION.SDK_INT + "; "
                + "locale:" + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    @Override
    public Class getApiServiceType() {
        return ApiService.class;
    }
}
