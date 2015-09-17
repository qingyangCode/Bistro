package com.qingyang.bistro.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.qingyang.bistro.R;
import com.qingyang.bistro.fragments.HomeFragment;
import com.qingyang.bistro.fragments.NearByFragment;
import com.qingyang.bistro.fragments.OrderHomeFragment;
import com.qingyang.bistro.fragments.UserProfileFragment;
import com.qingyang.bistro.ui.wdiget.DraggableFlagView;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by QingYang on 15/9/7.
 */
public class MainActivity extends Activity
        implements DraggableFlagView.OnDraggableFlagViewListener {

    private String TAG = MainActivity.class.getSimpleName();

    private int mCurrentSelectedPosition = -1;

    private View[] mViewBottomTabs;

    private final Class[] mFragments = new Class[] { HomeFragment.class, NearByFragment.class,
            OrderHomeFragment.class, UserProfileFragment.class };
    private final Map<Integer, Fragment> mFragmentMaps = new HashMap<Integer, Fragment>();
    private final int SPACETIME = 2000;
    private long mLastBackPressTime;

    public interface OnFragmentChangedListener {
        void onFragmentChanged();
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        setSelected(0);
        DraggableFlagView near_point = (DraggableFlagView) findViewById(R.id.near_point);
        near_point.setOnDraggableFlagViewListener(this);
        near_point.setText("1");
    }

    private void initView() {
        mViewBottomTabs = new View[] { findViewById(R.id.rl_bottom_1), findViewById(R.id.rl_bottom_2),
                findViewById(R.id.rl_bottom_3), findViewById(R.id.rl_bottom_4) };
    }

    private void initEvents() {
        for (int i = 0; i< mViewBottomTabs.length; i++) {
            final int temp = i;
            mViewBottomTabs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setSelected(temp);
                }
            });
        }
    }

    private void setSelected(int position) {

        if (mCurrentSelectedPosition == position) return;

        //updateTopbarViews(position);

        try {
            Fragment fragment = mFragmentMaps.get(position);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            // hide the old Fragment
            if (mCurrentSelectedPosition != -1) {
                transaction.hide(mFragmentMaps.get(mCurrentSelectedPosition));
            }
            if (fragment == null) {
                fragment = (Fragment) mFragments[position].newInstance();
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
                mFragmentMaps.put(position, fragment);
                transaction.add(R.id.container, fragment, fragment.getClass().getSimpleName()).commit();
                // transaction.replace(R.id.container, fragment).commit();
            } else {
                transaction.show(fragment);
                transaction.commit();
                if (fragment instanceof OnFragmentChangedListener) {
                    OnFragmentChangedListener listener = (OnFragmentChangedListener)fragment;
                    listener.onFragmentChanged();
                }
            }
            mCurrentSelectedPosition = position;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < mViewBottomTabs.length; i++) {
            if (i == position) {
                mViewBottomTabs[i].setSelected(true);
            } else {
                mViewBottomTabs[i].setSelected(false);
            }
        }
    }

    @Override public void onFlagDismiss(DraggableFlagView view) {
        Toast.makeText(this, "onFlagDismiss", Toast.LENGTH_SHORT).show();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        //ImageLoader.getInstance().clearMemoryCache();
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        if (mCurrentSelectedPosition != 0) {
            setSelected(0);
        } else {
            if (System.currentTimeMillis() - mLastBackPressTime > SPACETIME) {
                mLastBackPressTime = System.currentTimeMillis();
                Toast.makeText(getBaseContext(), R.string.main_exit_message, Toast.LENGTH_SHORT).show();
            } else {
                finish();
            }
            // exit 会导致onDestroy方法不被回调。
            // System.exit(0);
        }
    }
}
