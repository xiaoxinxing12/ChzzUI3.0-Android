package org.chzz.demo.test.aidl;

import java.io.Serializable;

/**
 * Created by copy on 2017/7/10.
 */

public class Book implements Serializable {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
