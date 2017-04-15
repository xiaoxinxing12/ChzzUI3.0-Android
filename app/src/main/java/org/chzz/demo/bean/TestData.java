package org.chzz.demo.bean;

/**
 * Created by copy on 2017/4/15.
 */

public class TestData extends BaseEntity {
    public TestData(int itemFlag, String title) {
        super(itemFlag);
        this.title = title;
    }

    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
