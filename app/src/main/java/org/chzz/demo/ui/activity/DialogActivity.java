package org.chzz.demo.ui.activity;

import android.os.Handler;
import android.os.Message;

import org.chzz.demo.R;
import org.chzz.widget.CHZZLoadDataLayout;

/**
 * Created by copy on 2017/4/18.
 */

public class DialogActivity extends BaseActivity {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    loadDataLayout.setStatus(CHZZLoadDataLayout.SUCCESS);
                    loadDataLayout.setStatus(CHZZLoadDataLayout.SUBMIT,"提交数据中...");
                    handler.sendEmptyMessageDelayed(2, 3000);
                    break;
                case 2:
                    loadDataLayout.setStatus(CHZZLoadDataLayout.DISMISS);
                    break;
            }

        }
    };
    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        setListener();
        loadDataLayout.setStatus(CHZZLoadDataLayout.LOADING);
        handler.sendEmptyMessageDelayed(1, 3000);
    }

    @Override
    protected void setListener() {
        loadDataLayout = (CHZZLoadDataLayout) findViewById(R.id.loadLayout);
    }
}
