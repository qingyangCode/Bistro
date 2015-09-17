package com.qingyang.bistro.fragments;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.qingyang.bistro.R;
import com.qingyang.bistro.activity.LoginHomeActivity;
import com.qingyang.bistro.activity.MainActivity;

/**
 * Created by QingYang on 15/9/8.
 */
public class UserProfileFragment extends BaseFragment implements View.OnClickListener {

    @InjectView(R.id.btn_login)
    Button btn_login;

    @Override protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_userprofile, null);
    }

    @Override protected void initView() {
        super.initView();

    }

    @Override protected void initEvents() {
        super.initEvents();
        btn_login.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(mContext, LoginHomeActivity.class));
                //((MainActivity)mContext).startParallaxSwipeBackActivty(((MainActivity)mContext), new Intent(mContext, LoginHomeActivity.class));
                break;
        }
    }
}
