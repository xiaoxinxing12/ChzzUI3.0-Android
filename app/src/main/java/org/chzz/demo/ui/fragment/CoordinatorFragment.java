package org.chzz.demo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.chzz.adapter.CHZZDivider;
import org.chzz.adapter.CHZZRecyclerViewAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.demo.R;
import org.chzz.demo.adapter.CommonRecyclerAdapter;
import org.chzz.demo.bean.TestData;
import org.chzz.demo.ui.activity.CoordinatorActivity;
import org.chzz.refresh.CHZZRefreshLayout;
import org.chzz.widget.CHZZLoadDataLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by copy on 2017/4/17.
 */

public class CoordinatorFragment extends BaseFragment implements CHZZRefreshLayout.CHZZRefreshLayoutDelegate, CHZZRecyclerViewAdapter.IFillDataListener {

    RecyclerView mDataRv;

    CHZZRefreshLayout chzzRefreshLayout;
    CHZZLoadDataLayout mLoadLayout;
    CommonRecyclerAdapter adapter;
    List<TestData> list;
    private int flag;
    private AppBarLayout appBar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        appBar = ((CoordinatorActivity) context).getAppBar();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mLoadLayout.setStatus(CHZZLoadDataLayout.SUCCESS);
                    break;
                case 0:
                    adapter.addMoreData(list);
                    chzzRefreshLayout.endLoadingMore();
                    break;
                case 2:
                    adapter.setData(list);
                    chzzRefreshLayout.endRefreshing();
                    break;
            }

        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.common_refresh_nobar);
        setListener();
        mLoadLayout.setStatus(CHZZLoadDataLayout.SUCCESS);
    }


    protected void setListener() {
        chzzRefreshLayout.setDelegate(this);
       // chzzRefreshLayout.setPullDownRefreshEnable(false);
        //设置刷新头
        chzzRefreshLayout.setRefreshViewHolder(leftRefreshViewHolder);
        //布局管理器
        final LinearLayoutManager layoutManager = new LinearLayoutManager(mApp, GridLayoutManager.VERTICAL, false);
        mDataRv.setLayoutManager(layoutManager);
        mDataRv.addItemDecoration(new CHZZDivider(mApp));
        int[] itemLayout = {R.layout.item_refresh_adapter, R.layout.item_refresh_adapter1, R.layout.item_refresh_adapter3};
        adapter = new CommonRecyclerAdapter(mDataRv, R.layout.item_refresh_adapter, null, null, this, null);
        mDataRv.setAdapter(adapter);
        mDataRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int firstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                    if (firstVisiblePosition == 0) {
                        appBar.setExpanded(true, true);
                    }
                }
            }
        });

        resultData();


    }

    private void resultData() {
        list = new ArrayList<>();
        Random random = new Random();
        TestData t1 = new TestData(0, "1");
        TestData t2 = new TestData(0, "2");
        TestData t3 = new TestData(0, "3");
        TestData t4 = new TestData(0, "4");
        TestData t5 = new TestData(0, "5");
        TestData t6 = new TestData(0, "6");
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
        list.add(t6);
        adapter.setData(list);
    }

    @Override
    public void onCHZZRefreshLayoutBeginRefreshing(CHZZRefreshLayout refreshLayout) {
        handler.sendEmptyMessageDelayed(2, 200);
    }

    @Override
    public boolean onCHZZRefreshLayoutBeginLoadingMore(CHZZRefreshLayout refreshLayout) {
        if (flag > 1) {
            return false;
        }
        handler.sendEmptyMessageDelayed(0, 200);
        flag = flag + 1;
        return true;
    }

    @Override
    public void setFillDataListener(CHZZViewHolderHelper chzzViewHolderHelper, int i, Object t) {
        TestData bean = (TestData) t;
        chzzViewHolderHelper.setText(R.id.tv_title, bean.getTitle());
    }
}
