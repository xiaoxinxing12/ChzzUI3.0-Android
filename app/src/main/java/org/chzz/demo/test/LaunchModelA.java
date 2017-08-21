package org.chzz.demo.test;

import android.view.View;
import android.widget.TextView;

import org.chzz.demo.R;
import org.chzz.demo.test.view.SlideView;
import org.chzz.demo.ui.activity.BaseActivity;

/**
 * Created by copy on 2017/7/10.
 */

public class LaunchModelA extends BaseActivity {
    SlideView slideView;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_launch_model);
        TextView view = (TextView) findViewById(R.id.tv_name);
        view.setText(LaunchModelA.class.getName().toString());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(LaunchModelA.this, LaunchModelB.class));
//                Uri uri=Uri.parse("content://org.chzz.demo.provider");
//                getContentResolver().query(uri,null,null,null,null);

              if(null==slideView) {
                  slideView=new SlideView(LaunchModelA.this);
                  slideView.setCancelable(true);
              }
                slideView.show();

            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
