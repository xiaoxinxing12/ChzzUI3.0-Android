package org.chzz.demo.bean;

import org.chzz.dragview.model.DragChildInfo;

import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/11/10
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/11/10--17:45
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/

public class DragChild extends DragChildInfo {

    private int parentCode;
    private String title;
    private List<MenuEntityNew.MsgBean.ChildMenuBean> childMenu;

    public List<MenuEntityNew.MsgBean.ChildMenuBean> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<MenuEntityNew.MsgBean.ChildMenuBean> childMenu) {
        this.childMenu = childMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getParentCode() {
        return parentCode;
    }

    public void setParentCode(int parentCode) {
        this.parentCode = parentCode;
    }

    public DragChild(int id, String name, String title, int parentCode, List<MenuEntityNew.MsgBean.ChildMenuBean> childMenu) {
        super(id, name);
        this.parentCode = parentCode;
        this.title = title;
        this.childMenu = childMenu;
    }

}
