package org.chzz.demo.bean;

/**
 * Created by copy on 2017/4/15.
 */

public class BaseEntity {
    protected int itemFlag;

    public BaseEntity(int itemFlag) {
        this.itemFlag = itemFlag;
    }

    public int getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(int itemFlag) {
        this.itemFlag = itemFlag;
    }
}
