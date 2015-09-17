package com.qingyang.bistro.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.qingyang.bistro.R;
import com.qingyang.bistro.fragments.SignInFragment;

/**
 * Created by QingYang on 15/9/9.
 */
public class LoginHomeActivity extends BaseActivity{

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginhome);
        try {
            Fragment fragment = new SignInFragment();
            getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
