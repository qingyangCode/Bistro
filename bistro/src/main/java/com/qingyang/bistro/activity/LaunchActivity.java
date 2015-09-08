package com.qingyang.bistro.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.qingyang.bistro.R;
import java.util.List;

/**
 * Created by QingYang on 15/9/7.
 */
public class LaunchActivity extends Activity{

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AsyncTask<Void, Void, Void> loading = new AsyncTask<Void, Void, Void>() {

            @Override protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(1500);
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        };

        loading.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }
}
