/**
 * Copyright 2015 bingoogolapple
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.chzz.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <M> 适配的数据类型
 */
public class CHZZDataBindingAdapter<M> extends RecyclerView.Adapter<CHZZDataBindingHolder> {
    protected final int mItemLayoutId;
    protected Context mContext;
    protected List<M> mData;
    protected CHZZOnItemChildClickListener mOnItemChildClickListener;
    protected CHZZOnItemChildLongClickListener mOnItemChildLongClickListener;
    protected CHZZOnItemChildCheckedChangeListener mOnItemChildCheckedChangeListener;
    protected CHZZOnRVItemClickListener mOnRVItemClickListener;
    protected CHZZOnRVItemLongClickListener mOnRVItemLongClickListener;

    protected RecyclerView mRecyclerView;
    //头部 底部
    private View mHeadViews, mFootViews, foot;
    private List<View> mRandomViews = new ArrayList<View>();
    private SparseArray<Integer> mRandomViews_position = new SparseArray<Integer>();
    protected ViewDataBinding mBinding;
    protected View mItem;
    private boolean isBinding;
    private bindingItemListener mBindingItemListener;

    public CHZZDataBindingAdapter(RecyclerView recyclerView, int itemLayoutId, boolean isBinding) {
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
        mItemLayoutId = itemLayoutId;
        this.isBinding = isBinding;
        mData = new ArrayList<>();
    }

    public CHZZDataBindingAdapter(RecyclerView recyclerView, int itemLayoutId, View headView, View footView, bindingItemListener bindingItemListener) {
        mRecyclerView = recyclerView;
        mContext = mRecyclerView.getContext();
        mItemLayoutId = itemLayoutId;
        mData = new ArrayList<>();
        mHeadViews = headView;
        mFootViews = footView;
        foot = footView;
        this.mBindingItemListener = bindingItemListener;
    }


    public void setItem(View mItem) {
        this.mItem = mItem;
    }

    /**
     * 增加头部
     *
     * @param view
     */
    public void addHeadView(View view) {
        mHeadViews = view;
    }

    /**
     * 增加底部
     *
     * @param view
     */
    public void addFootView(View view) {
        mFootViews = view;
    }

    /**
     * 使用一次 存下来 后续 好查找
     */
    private int index = 0;

    public void addRandomView(View view, int posistion) {
        mRandomViews_position.append(posistion, index);
        index++;
        mRandomViews.add(view);
    }


    @Override
    public int getItemCount() {
        int a = mData.size();
        if (mHeadViews != null)
            a = a + 1;
        if (mFootViews != null)
            a = a + 1;
        return a;
    }

    @Override
    public CHZZDataBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CHZZDataBindingHolder viewHolder = null;
        if (viewType < 1 && mHeadViews != null) {
            //头部
            viewHolder = new CHZZDataBindingHolder(mBinding, mHeadViews);
        } else if (viewType > mData.size() && mFootViews != null && mHeadViews != null) {
            //底部
            viewHolder = new CHZZDataBindingHolder(mBinding, mFootViews);
        } else if (viewType >= mData.size() && mFootViews != null && mHeadViews == null) {
            //底部
            viewHolder = new CHZZDataBindingHolder(mBinding, mFootViews);
        } else {
            //正常
            setBindingItem(parent);
            viewHolder = new CHZZDataBindingHolder(mBinding, mItem);
        }

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(CHZZDataBindingHolder viewHolder, int position) {
        if (mHeadViews == null && mFootViews == null && mData != null) {
            fillData(viewHolder.getViewHolderHelper(), position, getItem(position));
        }
        if (mHeadViews != null && mFootViews == null && 0 < position && position < getItemCount() && mData.size() > 0) {
            fillData(viewHolder.getViewHolderHelper(), position - 1, getItem(position - 1));
        }
        if (mHeadViews != null && mFootViews != null && 0 < position && position < getItemCount() - 1 && mData.size() > 0) {
            fillData(viewHolder.getViewHolderHelper(), position - 1, getItem(position - 1));
        }
        if (mHeadViews == null && mFootViews != null && position < getItemCount() - 1 && mData.size() > 0) {
            fillData(viewHolder.getViewHolderHelper(), position, getItem(position));
        }


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public M getItem(int position) {
        return mData.get(position);
    }

    /**
     * 获取数据集合
     *
     * @return
     */
    public List<M> getData() {
        return mData;
    }

    /**
     * 在集合头部添加新的数据集合（下拉从服务器获取最新的数据集合，例如新浪微博加载最新的几条微博数据）
     *
     * @param data
     */
    public void addNewData(List<M> data) {
        if (data != null) {
            mData.addAll(0, data);
            notifyItemRangeInserted(0, data.size());
        }
    }

    /**
     * 填充item数据
     *
     * @param helper
     * @param position
     * @param model
     */
    protected void fillData(CHZZViewHolderHelper helper, int position, M model) {
        if (mBindingItemListener != null)
            mBindingItemListener.setFillDataListener(helper, position, model);
    }

    /**
     * 在集合尾部添加更多数据集合（上拉从服务器获取更多的数据集合，例如新浪微博列表上拉加载更晚时间发布的微博数据）
     *
     * @param data
     */
    public void addMoreData(List<M> data) {
        if (data != null) {
            if (foot != null) {
                mFootViews = null;
                notifyItemChanged(getItemCount());
            }
            mData.addAll(mData.size(), data);
            if (foot != null) {
                addFootView(foot);
            }
            notifyItemRangeInserted(mData.size(), data.size());
        }
    }

    /**
     * 设置全新的数据集合，如果传入null，则清空数据列表（第一次从服务器加载数据，或者下拉刷新当前界面数据表）
     *
     * @param data
     */
    public void setData(List<M> data) {
        if (data != null) {
            mData = data;
        } else {
            mData.clear();
        }
        if (foot != null) {
            addFootView(foot);
        }
        notifyDataSetChanged();
    }

    /**
     * 清空数据列表
     */
    public void clear() {
        mData.clear();
        notifyDataSetChanged();
    }

    /**
     * 删除指定索引数据条目
     *
     * @param position
     */
    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 删除指定数据条目
     *
     * @param model
     */
    public void removeItem(M model) {
        removeItem(mData.indexOf(model));
    }

    /**
     * 在指定位置添加数据条目
     *
     * @param position
     * @param model
     */
    public void addItem(int position, M model) {
        mData.add(position, model);
        notifyItemInserted(position);
    }

    /**
     * 在集合头部添加数据条目
     *
     * @param model
     */
    public void addFirstItem(M model) {
        addItem(0, model);
    }

    /**
     * 在集合末尾添加数据条目
     *
     * @param model
     */
    public void addLastItem(M model) {
        addItem(mData.size(), model);
    }

    /**
     * 替换指定索引的数据条目
     *
     * @param location
     * @param newModel
     */
    public void setItem(int location, M newModel) {
        mData.set(location, newModel);
        notifyItemChanged(location);
    }

    /**
     * 替换指定数据条目
     *
     * @param oldModel
     * @param newModel
     */
    public void setItem(M oldModel, M newModel) {
        setItem(mData.indexOf(oldModel), newModel);
    }

    /**
     * 移动数据条目的位置
     *
     * @param fromPosition
     * @param toPosition
     */
    public void moveItem(int fromPosition, int toPosition) {
        mData.add(toPosition, mData.remove(fromPosition));
        notifyItemMoved(fromPosition, toPosition);
    }

    public void setBindingItem(ViewGroup parent) {
        mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                mItemLayoutId, parent,
                false);
        mBindingItemListener.setBingItem(mBinding);
    }


    public interface bindingItemListener<M> {
        public void setFillDataListener(CHZZViewHolderHelper chzzViewHolderHelper, int i, M t);

        public void setBingItem(ViewDataBinding mBinding);
    }

}