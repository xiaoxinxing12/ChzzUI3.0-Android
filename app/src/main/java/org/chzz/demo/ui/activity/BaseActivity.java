package org.chzz.demo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.chzz.demo.App;
import org.chzz.demo.R;
import org.chzz.refresh.CHZZMoocStyleRefreshViewHolder;
import org.chzz.widget.CHZZLoadDataLayout;

/**
 * Created by copy on 2017/4/15.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected App mApp;
    protected Toolbar toolbar;
    protected CHZZMoocStyleRefreshViewHolder leftRefreshViewHolder;
    CHZZLoadDataLayout loadDataLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = App.getInstance();
        try {
            initData();
            initView();
            initView(savedInstanceState);
            setListener();
        } catch (Exception t) {
            Toast.makeText(this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    protected abstract void initView();
    protected  void initView(@Nullable Bundle savedInstanceState){

    }
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
