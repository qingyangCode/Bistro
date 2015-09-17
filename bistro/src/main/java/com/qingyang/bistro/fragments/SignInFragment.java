package com.qingyang.bistro.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.qingyang.bistro.QLPApplication;
import com.qingyang.bistro.R;
//import com.qingyang.bistro.inject.compontent.LoginHomeCompontent;
//import com.qingyang.bistro.inject.module.LoginHomeModule;
import com.qingyang.bistro.inject.compontent.LoginHomeCompontent;
import com.qingyang.bistro.inject.module.LoginHomeModule;
import com.qingyang.bistro.util.ApiServiceManager;
import com.qingyang.bistro.view.LoginHomeView;

/**
 * Created by QingYang on 15/9/9.
 */
public class SignInFragment extends BaseFragment implements View.OnClickListener,LoginHomeView {

    @InjectView(R.id.tv_top_bar_title)
    TextView mTvTitle;
    @InjectView(R.id.tv_userName)
    TextView mTvUserName;
    @InjectView(R.id.tv_pwssword)
    TextView mTvPassword;
    @InjectView(R.id.btn_signIn)
    Button mBtnSignIn;

    @Override protected View getContentView(LayoutInflater inflater) {
        LoginHomeCompontent component = com.qingyang.bistro.inject.compontent.DaggerLoginHomeCompontent.builder()
                .qLPComponent(((QLPApplication) getActivity().getApplication()).getComponent())
                .loginHomeModule(new LoginHomeModule(this))
                .build();
        component.injectSignIn(this);
        return inflater.inflate(R.layout.fragment_signin, null);
    }

    @Override protected void initView() {
        super.initView();
        mTvTitle.setText(R.string.loginhome_signin);
    }

    @Override protected void initEvents() {
        super.initEvents();
        mBtnSignIn.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signIn:
                handleSignIn();
                break;
        }
    }

    private void handleSignIn() {
        String userName = mTvUserName.getText().toString().trim();
        String password = mTvPassword.getText().toString().trim();

        ApiServiceManager.getInstance().signInWithUserName(userName, password);

    }
}
