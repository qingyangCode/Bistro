package com.qingyang.bistro.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.InjectView;
import com.qingyang.bistro.R;
import com.qingyang.bistro.event.SignInEvent;
import com.qingyang.bistro.util.ApiServiceManager;
import com.qingyang.bistro.view.LoginHomeView;
import com.qingyang.mainlibrary.util.CommonProgressDialog;
import de.greenrobot.event.EventBus;

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

    private CommonProgressDialog mProgressDialog;

    @Override protected View getContentView(LayoutInflater inflater) {
        //LoginHomeCompontent component = com.qingyang.bistro.inject.compontent.DaggerLoginHomeCompontent.builder()
        //        .qLPComponent(((QLPApplication) getActivity().getApplication()).getComponent())
        //        .loginHomeModule(new LoginHomeModule(this))
        //        .build();
        //component.injectSignIn(this);
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
                showProgress();
                handleSignIn();
                break;
        }
    }


    private void handleSignIn() {
        String userName = mTvUserName.getText().toString().trim();
        String password = mTvPassword.getText().toString().trim();

        ApiServiceManager.getInstance().signInWithUserName(userName, password);

    }

    @Override public void showProgress() {
        if (mProgressDialog == null)  {
            mProgressDialog = new CommonProgressDialog(getActivity());
            mProgressDialog.setTip(R.string.signin_login);
            mProgressDialog.setCancelable(true);
            mProgressDialog.setCanceledOnTouchOutside(false);
        }
        mProgressDialog.show();
    }

    @Override public void dismissProgress() {
        if (mProgressDialog !=null) {
            mProgressDialog.dismiss();
        }
    }

    @Override public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(SignInEvent event) {
        if (event.isLoginInSuccess()) {
            Toast.makeText(getActivity(), "login result success", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "login result Failed", Toast.LENGTH_LONG).show();
        }
        dismissProgress();
    }
}
