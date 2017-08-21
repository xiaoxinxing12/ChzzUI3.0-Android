package org.chzz.demo.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import org.chzz.demo.R;
import org.chzz.demo.ui.activity.BaseActivity;

/**
 * Created by copy on 2017/7/10.
 */

public class OnSaveInstanceStateActivity extends BaseActivity {
    EditText mTest ;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_onsaveinstancestate);
        mTest= (EditText) findViewById(R.id.et_test);
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        if(null!=savedInstanceState){

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("test","1111");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String a  =savedInstanceState.getString("test");
    }

    @Override
    protected void setListener() {

    }
}
