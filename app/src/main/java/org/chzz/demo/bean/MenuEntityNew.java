package org.chzz.demo.bean;

import java.util.List;

/**
 * Created by copy on 2017/6/1.
 */

public class MenuEntityNew extends BaseEntity {


    /**
     * code : 0
     * msg : [{"description":"日常考核","childMenu":[{"menuIcon":108,"menuId":108,"menuDescribe":"绩效评定","childMenu":[{"menuIcon":10801,"menuId":10801,"menuDescribe":"量化考核","childMenu":[]},{"menuIcon":10802,"menuId":10802,"menuDescribe":"主观评价","childMenu":[]},{"menuIcon":10804,"menuId":10804,"menuDescribe":"出科成绩","childMenu":[]}]},{"menuIcon":109,"menuId":109,"menuDescribe":"考勤","childMenu":[]},{"menuIcon":110,"menuId":110,"menuDescribe":"请假","childMenu":[]}]},{"description":"评价反馈","childMenu":[{"menuIcon":201,"menuId":201,"menuDescribe":"评价带教","childMenu":[]},{"menuIcon":202,"menuId":202,"menuDescribe":"评价学员","childMenu":[]},{"menuIcon":207,"menuId":207,"menuDescribe":"评价科室","childMenu":[]}]}]
     */


    private List<MsgBean> msg;

    public MenuEntityNew(int itemFlag) {
        super(itemFlag);
    }

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * description : 日常考核
         * childMenu : [{"menuIcon":108,"menuId":108,"menuDescribe":"绩效评定","childMenu":[{"menuIcon":10801,"menuId":10801,"menuDescribe":"量化考核","childMenu":[]},{"menuIcon":10802,"menuId":10802,"menuDescribe":"主观评价","childMenu":[]},{"menuIcon":10804,"menuId":10804,"menuDescribe":"出科成绩","childMenu":[]}]},{"menuIcon":109,"menuId":109,"menuDescribe":"考勤","childMenu":[]},{"menuIcon":110,"menuId":110,"menuDescribe":"请假","childMenu":[]}]
         */

        private String description;
        private List<ChildMenuBean> childMenu;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<ChildMenuBean> getChildMenu() {
            return childMenu;
        }

        public void setChildMenu(List<ChildMenuBean> childMenu) {
            this.childMenu = childMenu;
        }

        public static class ChildMenuBean {
            /**
             * menuIcon : 108
             * menuId : 108
             * menuDescribe : 绩效评定
             * childMenu : [{"menuIcon":10801,"menuId":10801,"menuDescribe":"量化考核","childMenu":[]},{"menuIcon":10802,"menuId":10802,"menuDescribe":"主观评价","childMenu":[]},{"menuIcon":10804,"menuId":10804,"menuDescribe":"出科成绩","childMenu":[]}]
             */

            private int menuIcon;
            private int menuId;
            private String menuDescribe;
            private List<ChildMenuBean> childMenu;

            public int getMenuIcon() {
                return menuIcon;
            }

            public void setMenuIcon(int menuIcon) {
                this.menuIcon = menuIcon;
            }

            public int getMenuId() {
                return menuId;
            }

            public void setMenuId(int menuId) {
                this.menuId = menuId;
            }

            public String getMenuDescribe() {
                return menuDescribe;
            }

            public void setMenuDescribe(String menuDescribe) {
                this.menuDescribe = menuDescribe;
            }

            public List<ChildMenuBean> getChildMenu() {
                return childMenu;
            }

            public void setChildMenu(List<ChildMenuBean> childMenu) {
                this.childMenu = childMenu;
            }

        }
    }
}
