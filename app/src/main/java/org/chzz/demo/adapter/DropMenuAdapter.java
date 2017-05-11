package org.chzz.demo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import org.chzz.demo.model.MenuEntity;
import org.chzz.downmenu.adapter.MenuAdapter;
import org.chzz.downmenu.adapter.SimpleTextAdapter;
import org.chzz.downmenu.interfaces.OnFilterItemClickListener;
import org.chzz.downmenu.typeview.SingleListView;
import org.chzz.downmenu.util.UIUtil;
import org.chzz.downmenu.view.FilterCheckedTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: baiiu
 * date: on 16/1/17 21:14
 * description:
 */
public class DropMenuAdapter implements MenuAdapter {
    private final Context mContext;
    private OnFilterDoneListener onFilterDoneListener;
    private Map<String, MenuEntity> menuList;
    private String[] key;
    private Map<String, View> viewMap = new HashMap<>();

    public DropMenuAdapter(Context context, Map<String, MenuEntity> menuList, String[] key, OnFilterDoneListener onFilterDoneListener) {
        this.mContext = context;
        this.menuList = menuList;
        this.onFilterDoneListener = onFilterDoneListener;
        this.key = key;
    }

    @Override
    public int getMenuCount() {
        return menuList.size();
    }

    public void setMenuList(Map<String, MenuEntity> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String getMenuTitle(int position) {
        return menuList.get(key[position]).getTitle();
    }

    public Map<String, View> getViewMap() {
        return viewMap;
    }

    @Override
    public int getBottomMargin(int position) {
        if (position == 3) {
            return 0;
        }

        return UIUtil.dp(mContext, 140);
    }

    @Override
    public View getView(int position, FrameLayout parentContainer) {
        View view = parentContainer.getChildAt(position);

        switch (menuList.get(key[position]).getCode()) {
            case 0:
                view = createSingleListView(position, key[position], menuList.get(key[position]).getList());
                viewMap.put(key[position], view);
                break;
        }

        return view;
    }

    private View createSingleListView(final int position, final String code, List<MenuEntity.ListEntity> lists) {
        SingleListView<MenuEntity.ListEntity> singleListView = new SingleListView<MenuEntity.ListEntity>(mContext)

                .adapter(new SimpleTextAdapter<MenuEntity.ListEntity>(null, mContext) {
                    @Override
                    public String provideText(MenuEntity.ListEntity string) {
                        return string.getTitle();
                    }

                    @Override
                    protected void initCheckedTextView(FilterCheckedTextView checkedTextView) {
                        int dp = UIUtil.dp(mContext, 15);
                        checkedTextView.setPadding(dp, dp, 0, dp);
                    }
                })
                .onItemClick(new OnFilterItemClickListener<MenuEntity.ListEntity>() {
                    @Override
                    public void onItemClick(MenuEntity.ListEntity item) {

                        onFilterDone(position, code, item.getTitle(), item.getId() + "");
                    }
                });

        List<String> list = new ArrayList<>();
        for (MenuEntity.ListEntity entity : lists) {
            list.add(entity.getTitle());
        }
        singleListView.setList(lists, -1);

        return singleListView;
    }


    private void onFilterDone(int position, String positionTitle, String urlValue) {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(position, "", positionTitle, urlValue);
        }
    }

    private void onFilterDone(int position, String code, String positionTitle, String urlValue) {
        if (onFilterDoneListener != null) {
            onFilterDoneListener.onFilterDone(position, code, positionTitle, urlValue);
        }
    }

    public interface OnFilterDoneListener {
        void onFilterDone(int position, String code, String positionTitle, String urlValue);
    }

}
