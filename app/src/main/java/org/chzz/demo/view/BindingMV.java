package org.chzz.demo.view;

import android.content.Context;

import org.chzz.demo.bean.TestData;
import org.chzz.demo.model.BaseModel;

/**
 * Created by copy on 2017/4/15.
 */

public class BindingMV extends BaseModel {
    private Context context;
    private TestData bean;

    public BindingMV(Context context, TestData bean) {
        this.context = context;
        this.bean = bean;
    }

    public void setBean(TestData bean) {
        this.bean = bean;
        notifyChange();
    }

    public TestData getBean() {
        return bean;
    }
}
