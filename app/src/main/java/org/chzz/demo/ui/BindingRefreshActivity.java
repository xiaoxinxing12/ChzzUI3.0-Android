package org.chzz.demo.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import org.chzz.adapter.CHZZDataBindingAdapter;
import org.chzz.adapter.CHZZViewHolderHelper;
import org.chzz.demo.R;
import org.chzz.demo.bean.TestData;
import org.chzz.demo.databinding.ActivityRefreshBinding;
import org.chzz.demo.databinding.ItemRepoBinding;
import org.chzz.demo.view.BindingMV;
import org.chzz.refresh.CHZZMoocStyleRefreshViewHolder;
import org.chzz.refresh.CHZZRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by copy on 2017/4/15.
 */

public class BindingRefreshActivity extends BaseActivity implements CHZZRefreshLayout.CHZZRefreshLayoutDelegate, CHZZDataBindingAdapter.bindingItemListener {
    CHZZDataBindingAdapter adapter;
    private ActivityRefreshBinding binding;
    private ItemRepoBinding itemRepoBinding;
    List<TestData> list;

    @Override
    protected void init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_refresh);

    }

    @Override
    protected void setListener() {
        View head = View.inflate(this, R.layout.item_header, null);

        adapter = new CHZZDataBindingAdapter(binding.rvRecyclerviewData, R.layout.item_repo, head, head, this);
        //  adapter.addHeadView(head);
        binding.rlRecyclerview.setDelegate(this);
        CHZZMoocStyleRefreshViewHolder leftRefreshViewHolder = new CHZZMoocStyleRefreshViewHolder(mApp, true);
        leftRefreshViewHolder.setSpringDistanceScale(2);
        //刷新图标
        leftRefreshViewHolder.setOriginalImage(R.mipmap.ic_launcher);
        //刷新头背景色
        leftRefreshViewHolder.setUltimateColor(R.color.white);
        binding.rlRecyclerview.setRefreshViewHolder(leftRefreshViewHolder);
        binding.rvRecyclerviewData.setLayoutManager(new GridLayoutManager(mApp, 1, GridLayoutManager.VERTICAL, false));
        binding.rvRecyclerviewData.setAdapter(adapter);
        resultData();
    }

    private void resultData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestData t = new TestData(i, i + "");
            t.setTitle(i + "");
            list.add(t);
        }
        adapter.setData(list);
    }

    @Override
    public void setFillDataListener(CHZZViewHolderHelper chzzViewHolderHelper, int i, Object t) {
        TestData bean = (TestData) t;
        itemRepoBinding = (ItemRepoBinding) chzzViewHolderHelper.getmBinding();
        if (itemRepoBinding.getViewModel() == null) {
            itemRepoBinding.setViewModel(new BindingMV(this, bean));
        } else {
            itemRepoBinding.getViewModel().setBean(bean);
        }
    }

    @Override
    public void setBingItem(ViewDataBinding binding) {
        ItemRepoBinding b = (ItemRepoBinding) binding;
        adapter.setItem(b.cardView);
    }

    @Override
    public void onCHZZRefreshLayoutBeginRefreshing(CHZZRefreshLayout refreshLayout) {

    }

    @Override
    public boolean onCHZZRefreshLayoutBeginLoadingMore(CHZZRefreshLayout refreshLayout) {
        return false;
    }


}
