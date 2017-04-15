package org.chzz.demo.base;


import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;

import org.chzz.demo.bean.BaseEntity;
import org.chzz.refresh.CHZZRefreshLayout;

import java.util.Map;

/**
 * Interface that every ViewModel must implement
 */
public abstract class BaseViewModel extends BaseObservable {
    protected Activity context;
    protected DataListener dataListener;
    protected boolean isFirst;
    //分页页码
    protected int currentPage = 1;
    //分页大小
    protected int showCount = 20;
    public BaseViewModel() {

    }

    public BaseViewModel(Activity context, DataListener dataListener) {
        this.context = context;
        this.dataListener = dataListener;
    }

    public void onUserVisible() {
    }

    public void onUserVisible(Map<String, Object> data, boolean isFirst) {

    }

    public abstract void destroy();

    public abstract void showInfo();



    public void showError(Context context, CHZZRefreshLayout refreshLayout, String code, String desc) {
    }
    public interface DataListener {
        void result(BaseEntity entity, boolean isFirst);
    }
}
