package com.qingyang.bistro.activity;

import android.app.Fragment;
import android.os.Bundle;
import com.qingyang.bannerlibrary.ui.swipeBackLayout.SwipeBackLayout;
import com.qingyang.bistro.R;
import com.qingyang.bistro.fragments.SignInFragment;

/**
 * Created by QingYang on 15/9/9.
 */
public class LoginHomeActivity extends BaseActivity {
    private static final int VIBRATE_DURATION = 20;

    //private SwipeBackLayout mSwipeBackLayout;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhome);
        try {
            Fragment fragment = new SignInFragment();
            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //mSwipeBackLayout = getSwipeBackLayout();
        //mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        //mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
        //    @Override public void onScrollStateChange(int state, float scrollPercent) {
        //
        //    }
        //
        //    @Override public void onEdgeTouch(int edgeFlag) {
        //        vibrate(VIBRATE_DURATION);
        //    }
        //
        //    @Override public void onScrollOverThreshold() {
        //
        //    }
        //});
    }




}
