package com.qingyang.bistro.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

/**
 * Created by QingYang on 15/9/9.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = getContentView(inflater);
        ButterKnife.inject(this, view);
        return view;
    }

    protected abstract View getContentView(LayoutInflater inflater);


    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initEvents();
        onloadData();
    }


    protected void initView() {}

    protected void initEvents() {}

    protected void onloadData() {}

    @Override public void onStart() {
        super.onStart();
    }

    @Override public void onResume() {
        super.onResume();
    }

    @Override public void onPause() {
        super.onPause();
    }

    @Override public void onStop() {
        super.onStop();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
    }

    @Override public void onDestroy() {
        super.onDestroy();
    }
}
