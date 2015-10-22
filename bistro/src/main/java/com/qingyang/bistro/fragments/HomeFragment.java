package com.qingyang.bistro.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.qingyang.bannerlibrary.ui.widget.scrollviewpager.CBViewHolderCreator;
import com.qingyang.bannerlibrary.ui.widget.scrollviewpager.ConvenientBanner;
import com.qingyang.bistro.R;
import com.qingyang.bistro.ui.wdiget.NetworkImageHolderView;
import java.util.Arrays;
import java.util.List;

/**
 * Created by QingYang on 15/9/8.
 */
public class HomeFragment extends BaseFragment{

    @InjectView(R.id.mBannerView)
    ConvenientBanner mBannerView;
    @InjectView(R.id.tv_top_bar_title)
    TextView mTvTitle;

    private List<String> networkImages;
    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://d.3987.com/sqmy_131219/001.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };

    @Override protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override protected void initView() {
        super.initView();
        mTvTitle.setText("首页");
    }

    @Override protected void initEvents() {
        super.initEvents();
    }

    @Override protected void onloadData() {
        super.onloadData();
        initBanner();
    }

    private void initBanner() {
        networkImages = Arrays.asList(images);
        mBannerView.setPages(new CBViewHolderCreator() {
            @Override public Object createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages).setPageIndicator(new int[] {R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused}).setPageTransformer(
                ConvenientBanner.Transformer.DefaultTransformer);
    }

    @Override public void onResume() {
        super.onResume();
        //开始自动翻页
        mBannerView.startTurning(5000);
    }

    @Override public void onPause() {
        super.onPause();
        //停止翻页
        mBannerView.stopTurning();
    }
}
