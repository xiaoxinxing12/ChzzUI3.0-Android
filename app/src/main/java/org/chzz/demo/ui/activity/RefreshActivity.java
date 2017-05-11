package org.chzz.demo.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.chzz.adapter.CHZZDivider;
import org.chzz.adapter.CHZZOnRVItemClickListener;
import org.chzz.adapter.CHZZRecyclerViewAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.demo.R;
import org.chzz.demo.adapter.CommonRecyclerAdapter;
import org.chzz.demo.bean.TestData;
import org.chzz.refresh.CHZZRefreshLayout;
import org.chzz.widget.CHZZLoadDataLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by copy on 2017/4/15.
 */

public class RefreshActivity extends BaseActivity implements CHZZRefreshLayout.CHZZRefreshLayoutDelegate, CHZZRecyclerViewAdapter.IFillDataListener, CHZZOnRVItemClickListener {


    TextView tvTitle;

    RecyclerView mDataRv;

    CHZZRefreshLayout chzzRefreshLayout;
    CHZZLoadDataLayout mLoadLayout;
    CommonRecyclerAdapter adapter;
    List<TestData> list;
    int flag;
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
    protected void initView() {
        setContentView(R.layout.common_refresh);
        mLoadLayout.setStatus(CHZZLoadDataLayout.LOADING);

    }

    @Override
    protected void setListener() {
        View header = View.inflate(this, R.layout.item_header, null);
        View mFootViews = View.inflate(this, R.layout.item_header, null);
        chzzRefreshLayout.setDelegate(this);
        //设置刷新头
        chzzRefreshLayout.setRefreshViewHolder(leftRefreshViewHolder);
        //布局管理器
        mDataRv.setLayoutManager(new GridLayoutManager(mApp, 1, GridLayoutManager.VERTICAL, false));
        mDataRv.addItemDecoration(new CHZZDivider(mApp));
        int[] itemLayout = {R.layout.item_refresh_adapter, R.layout.item_refresh_adapter1, R.layout.item_refresh_adapter3};
        adapter = new CommonRecyclerAdapter(mDataRv, R.layout.item_refresh_adapter, header, mFootViews, this, null);
        mDataRv.setAdapter(adapter);
        resultData();
        adapter.setOnRVItemClickListener(this);
        // chzzRefreshLayout.setCustomHeaderView(header,true);

    }


    protected  void resultData() {
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
        handler.sendEmptyMessageDelayed(1, 3000);
    }

    @Override
    public void onCHZZRefreshLayoutBeginRefreshing(CHZZRefreshLayout refreshLayout) {
        handler.sendEmptyMessageDelayed(2, 2000);
    }

    @Override
    public boolean onCHZZRefreshLayoutBeginLoadingMore(CHZZRefreshLayout refreshLayout) {
        if (flag > 0) {
            return false;
        }
        handler.sendEmptyMessageDelayed(0, 200);
        flag = 1;
        return true;
    }

    @Override
    public void setFillDataListener(CHZZViewHolderHelper chzzViewHolderHelper, int i, Object t) {
        TestData bean = (TestData) t;
        chzzViewHolderHelper.setText(R.id.tv_title, bean.getTitle());
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        TestData bean = (TestData) adapter.getItem(position);
        Toast.makeText(this, bean.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
