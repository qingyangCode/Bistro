package com.qingyang.bistro.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qingyang.bistro.R;

/**
 * Created by QingYang on 15/9/8.
 */
public class NearByFragment extends BaseFragment{

    @Override protected View getContentView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_nearby, null);
    }
}
