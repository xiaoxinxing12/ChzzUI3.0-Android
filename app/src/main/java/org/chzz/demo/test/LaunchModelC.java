package org.chzz.demo.test;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import org.chzz.demo.R;
import org.chzz.demo.ui.activity.BaseActivity;

/**
 * Created by copy on 2017/7/10.
 */

public class LaunchModelC extends BaseActivity {
    @Override
    protected void initView() {
        setContentView(R.layout.activity_launch_model);
        TextView view = (TextView) findViewById(R.id.tv_name);
        view.setText(LaunchModelC.class.getName().toString());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LaunchModelC.this, LaunchModelB.class));
            }
        });
    }

    @Override
    protected void setListener() {

    }
}
