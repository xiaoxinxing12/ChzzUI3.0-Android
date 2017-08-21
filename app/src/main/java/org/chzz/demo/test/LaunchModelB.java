package org.chzz.demo.test;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import org.chzz.demo.R;
import org.chzz.demo.ui.activity.BaseActivity;

/**
 * Created by copy on 2017/7/10.
 */

public class LaunchModelB extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.activity_launch_model);
        TextView view = (TextView) findViewById(R.id.tv_name);
        view.setText(LaunchModelB.class.getName().toString());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchModelB.this, LaunchModelC.class));
            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
