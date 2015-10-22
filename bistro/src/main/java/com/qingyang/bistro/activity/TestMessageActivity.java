package com.qingyang.bistro.activity;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.InjectView;
import com.qingyang.bistro.R;
import com.qingyang.bistro.util.Constants;

/**
 * Created by QingYang on 15/9/18.
 */
public class TestMessageActivity extends BaseActivity{

    @InjectView(R.id.tv_message)
    TextView mMessage;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testmessage);

        String message = getIntent().getStringExtra(Constants.MESSAGE);
        mMessage.setText(message);
    }
}
