package org.chzz.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.chzz.demo.App;
import org.chzz.demo.R;
import org.chzz.refresh.CHZZMoocStyleRefreshViewHolder;

/**
 * Created by copy on 2017/4/15.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected App mApp;
    protected CHZZMoocStyleRefreshViewHolder leftRefreshViewHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = App.getInstance();
        initData();
        init();
        setListener();
    }

    protected abstract void init();

    protected abstract void setListener();

    private void initData() {
        //列表数据
        leftRefreshViewHolder = new CHZZMoocStyleRefreshViewHolder(mApp, true);
        leftRefreshViewHolder.setSpringDistanceScale(2);
        //刷新图标
        leftRefreshViewHolder.setOriginalImage(R.mipmap.ic_launcher);
        //刷新头背景色
        leftRefreshViewHolder.setUltimateColor(R.color.white);

    }
}
