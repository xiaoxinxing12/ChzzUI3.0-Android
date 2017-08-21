package org.chzz.demo;

import android.app.Application;

import org.chzz.widget.CHZZLoadDataLayout;

/**
 * Created by copy on 2017/4/14.
 */

public class App extends Application {
   static   App sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
        CHZZLoadDataLayout.getBuilder().setLoadingText("加载中...");
    }
    public static App getInstance() {
        return sInstance;
    }


}
