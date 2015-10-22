package com.qingyang.bistro;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.qingyang.mainlibrary.MainApplication;
import com.qingyang.mainlibrary.MainConfiguration;

import com.qingyang.bistro.inject.QLPComponent;

/**
 * Created by QingYang on 15/9/7.
 */
public class QLPApplication extends MainApplication{
     public static MainConfiguration sConfiguration = new QLPConfig();
    private QLPComponent mComponent;

    @Override public MainConfiguration getConfiguration() {
        return sConfiguration;
    }

    @Override public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
        initImageLoader();
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


    public static MainConfiguration getsConfiguration() {
        return sConfiguration;
    }

    //初始化网络图片缓存库
    private void initImageLoader(){
        //网络图片例子,结合常用的图片缓存库UIL,你可以根据自己需求自己换其他网络图片库
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
                showImageForEmptyUri(R.mipmap.ic_default_adimage)
                .cacheInMemory(true).cacheOnDisk(true).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        ImageLoader.getInstance().init(config);
    }

}
