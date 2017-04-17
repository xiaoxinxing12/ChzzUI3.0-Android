package org.chzz.demo.ui.fragment;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.chzz.demo.App;
import org.chzz.demo.R;
import org.chzz.refresh.CHZZMoocStyleRefreshViewHolder;

/**
 * Created by copy on 2017/4/17.
 */

public abstract class BaseFragment extends Fragment {
    protected View mContentView;
    protected App mApp = App.getInstance();
    protected CHZZMoocStyleRefreshViewHolder leftRefreshViewHolder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initData();
        initView(savedInstanceState);
        return mContentView;
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected void setContentView(@LayoutRes int layoutResID) {
        mContentView = LayoutInflater.from(mApp).inflate(layoutResID, null);
    }

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
