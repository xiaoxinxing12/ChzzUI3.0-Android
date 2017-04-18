package org.chzz.demo.ui.activity;

import android.content.Intent;

import org.chzz.banner.CHZZBanner;
import org.chzz.demo.MainActivity;
import org.chzz.demo.R;

/**
 * Created by copy on 2017/4/18.
 */

public class GuideActivity extends BaseActivity {
    private CHZZBanner mBackgroundBanner, mForegroundBanner;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_guide);
        mBackgroundBanner = (CHZZBanner) findViewById(R.id.banner_guide_background);
        mForegroundBanner = (CHZZBanner) findViewById(R.id.banner_guide_foreground);
        processLogic();
    }

    @Override
    protected void setListener() {
        /**
         * 设置进入按钮和跳过按钮控件资源 id 及其点击事件
         * 如果进入按钮和跳过按钮有一个不存在的话就传 0
         * 在 BGABanner 里已经帮开发者处理了防止重复点击事件
         * 在 BGABanner 里已经帮开发者处理了「跳过按钮」和「进入按钮」的显示与隐藏
         */
        mForegroundBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new CHZZBanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void processLogic() {
        // 设置数据源
        mBackgroundBanner.setData(R.mipmap.uoko_guide_background_1, R.mipmap.uoko_guide_background_2, R.mipmap.uoko_guide_background_3);

        mForegroundBanner.setData(R.mipmap.uoko_guide_foreground_1, R.mipmap.uoko_guide_foreground_2, R.mipmap.uoko_guide_foreground_3);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        mBackgroundBanner.setBackgroundResource(android.R.color.white);
    }
}
