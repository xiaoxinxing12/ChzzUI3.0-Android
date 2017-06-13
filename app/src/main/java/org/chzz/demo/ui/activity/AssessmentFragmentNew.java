package org.chzz.demo.ui.activity;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.chzz.demo.R;
import org.chzz.demo.base.GsonTools;
import org.chzz.demo.bean.DragChild;
import org.chzz.demo.bean.MenuEntityNew;
import org.chzz.dragview.model.DragChildInfo;
import org.chzz.dragview.model.DragIconInfo;
import org.chzz.dragview.view.CHZZDragView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by copy on 2017/4/26.
 * 考核
 */

public class AssessmentFragmentNew extends BaseActivity implements CHZZDragView.DragOnClickListener {

    CHZZDragView mCHZZDragView;
    ArrayList<DragIconInfo> iconInfoList;
    LinearLayout mContent;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_drag);
        mContent = (LinearLayout) findViewById(R.id.ll_content);
    }

    @Override
    protected void setListener() {
        result();
    }


    /**
     * 获取用户权限
     */
    private void loadAppMenuGroupWithPersisson() {


    }


    private void result() {
        MenuEntityNew entity = GsonTools.jsonToBean(json(), MenuEntityNew.class);
        List<MenuEntityNew.MsgBean> list = entity.getMsg();

        for (MenuEntityNew.MsgBean menuBean : list) {
            TextView title = new TextView(this);
            title.setPadding(20, 20, 20, 20);
            title.setText(menuBean.getDescription());
            mContent.addView(title);
            initDragView(mContent, menuBean.getChildMenu());
        }

    }

    /**
     * 初始化菜单
     *
     * @param layout
     * @param entity
     */
    private void initDragView(LinearLayout layout, List<MenuEntityNew.MsgBean.ChildMenuBean> entity) {
        iconInfoList = new ArrayList<>();
        mCHZZDragView = new CHZZDragView(this,true);
        for (int i = 0; i < entity.size(); i++) {
            try {
                MenuEntityNew.MsgBean.ChildMenuBean childMenuBean = entity.get(i);
                iconInfoList.add(new DragIconInfo(childMenuBean.getMenuId(), childMenuBean.getMenuDescribe(), R.mipmap.ic_launcher, DragIconInfo.CATEGORY_EXPAND, new ArrayList<DragChildInfo>()));
                if (null != childMenuBean.getChildMenu())
                    iconInfoList.get(i).setChildList(initChildList(childMenuBean));
            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        }
        mCHZZDragView.setAllInfoList(iconInfoList);
        mCHZZDragView.initIconInfo();
        mCHZZDragView.setDragOnClickListener(this);
        layout.addView(mCHZZDragView);

    }

    /**
     * 初始化子菜单功能
     *
     * @param menuBean
     * @return
     */
    private ArrayList<DragChildInfo> initChildList(MenuEntityNew.MsgBean.ChildMenuBean menuBean) {
        ArrayList<DragChildInfo> childList = new ArrayList<>();
        for (MenuEntityNew.MsgBean.ChildMenuBean bean : menuBean.getChildMenu()) {
            childList.add(new DragChild(bean.getMenuId(), bean.getMenuDescribe(), bean.getMenuDescribe(), bean.getMenuId(), null));
        }

        return childList;
    }


    @Override
    public void dispatchChild(DragChildInfo childInfo) {

    }

    @Override
    public void dispatchSingle(DragIconInfo dragInfo) {
        //父菜单
        Toast.makeText(this,dragInfo.getName(),Toast.LENGTH_SHORT).show();
    }


    private String json() {
        String json = "{\"code\":\"0\",\"desc\":\"success\",\"msg\":[{\"description\":\"日常考核\",\"childMenu\":[{\"menuIcon\":101,\"menuId\":101,\"menuDescribe\":\"培训大岗\",\"childMenu\":[]},{\"menuIcon\":102,\"menuId\":102,\"menuDescribe\":\"拟诊报告\",\"childMenu\":[]},{\"menuIcon\":103,\"menuId\":103,\"menuDescribe\":\"学习登录\",\"childMenu\":[]},{\"menuIcon\":104,\"menuId\":104,\"menuDescribe\":\"教学查房\",\"childMenu\":[]},{\"menuIcon\":105,\"menuId\":105,\"menuDescribe\":\"病例学习\",\"childMenu\":[]},{\"menuIcon\":106,\"menuId\":106,\"menuDescribe\":\"技能学习\",\"childMenu\":[]},{\"menuIcon\":107,\"menuId\":107,\"menuDescribe\":\"技能考核\",\"childMenu\":[]},{\"menuIcon\":108,\"menuId\":108,\"menuDescribe\":\"绩效评定\",\"childMenu\":[{\"menuIcon\":10801,\"menuId\":10801,\"menuDescribe\":\"量化考核\",\"childMenu\":[]},{\"menuIcon\":10802,\"menuId\":10802,\"menuDescribe\":\"主观评价\",\"childMenu\":[]}]},{\"menuIcon\":109,\"menuId\":109,\"menuDescribe\":\"考勤\",\"childMenu\":[]},{\"menuIcon\":110,\"menuId\":110,\"menuDescribe\":\"请假\",\"childMenu\":[]}]},{\"description\":\"评价反馈\",\"childMenu\":[{\"menuIcon\":201,\"menuId\":201,\"menuDescribe\":\"教学评价\",\"childMenu\":[]},{\"menuIcon\":202,\"menuId\":202,\"menuDescribe\":\"教学查房\",\"childMenu\":[]},{\"menuIcon\":203,\"menuId\":203,\"menuDescribe\":\"小讲课\",\"childMenu\":[]},{\"menuIcon\":204,\"menuId\":204,\"menuDescribe\":\"评价科室\",\"childMenu\":[]}]},{\"description\":\"在线考试系统\",\"childMenu\":[{\"menuIcon\":301,\"menuId\":301,\"menuDescribe\":\"在线考试\",\"childMenu\":[]}]}]}";
        return json;
    }
}
