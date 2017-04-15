package org.chzz.refresh;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;

import org.chzz.R;

/**
 * Created by copy on 2017/4/7.
 */

public class CHZZMoocStyleRefreshViewHolder extends CHZZRefreshViewHolder {
    private CHZZMoocStyleRefreshView mMoocRefreshView;
    //顶部图标id
    private int mOriginalImageResId = -1;
    //设置最终生成图片的填充颜色资源
    private int mUltimateColorResId = -1;
    public CHZZMoocStyleRefreshViewHolder(Context mContext, boolean mIsLoadingMoreEnabled) {
        super(mContext, mIsLoadingMoreEnabled);
    }

    @Override
    public View getRefreshHeaderView() {
        if (mRefreshHeaderView == null) {
            mRefreshHeaderView = View.inflate(mContext, R.layout.view_refresh_header_mooc_style, null);
            mRefreshHeaderView.setBackgroundColor(Color.TRANSPARENT);
            if (mRefreshViewBackgroundColorRes != -1) {
                mRefreshHeaderView.setBackgroundResource(mRefreshViewBackgroundColorRes);
            }
            if (mRefreshViewBackgroundDrawableRes != -1) {
                mRefreshHeaderView.setBackgroundResource(mRefreshViewBackgroundDrawableRes);
            }
            mMoocRefreshView = (CHZZMoocStyleRefreshView) mRefreshHeaderView.findViewById(R.id.moocView);
            if (mOriginalImageResId != -1) {
                mMoocRefreshView.setOriginalImage(mOriginalImageResId);
            } else {
                throw new RuntimeException("请调用" + CHZZMoocStyleRefreshViewHolder.class.getSimpleName() + "的setOriginalImage方法设置原始图片资源");
            }
            if (mUltimateColorResId != -1) {
                mMoocRefreshView.setUltimateColor(mUltimateColorResId);
            } else {
                throw new RuntimeException("请调用" + CHZZMoocStyleRefreshViewHolder.class.getSimpleName() + "的setUltimateColor方法设置最终生成图片的填充颜色资源");
            }
        }
        return mRefreshHeaderView;
    }

    @Override
    public void handleScale(float scale, int moveYDistance) {

    }

    @Override
    public void changeToIdle() {

    }

    @Override
    public void changeToPullDown() {

    }

    @Override
    public void changeToReleaseRefresh() {

    }

    /**
     * 设置原始的图片资源
     *
     * @param resId
     */
    public void setOriginalImage(@DrawableRes int resId) {
        mOriginalImageResId = resId;
    }

    /**
     * 设置最终生成图片的填充颜色资源
     *
     * @param resId
     */
    public void setUltimateColor(@ColorRes int resId) {
        mUltimateColorResId = resId;
    }
    @Override
    public void changeToRefreshing() {
        mMoocRefreshView.startRefreshing();
    }

    @Override
    public void onEndRefreshing() {
        mMoocRefreshView.stopRefreshing();
    }
}
