package org.chzz.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.chzz.R;


public class CHZZDivider extends RecyclerView.ItemDecoration {
    private Drawable mDividerDrawable;
    /**
     * item之间分割线的size，默认为1
     */
    private int mItemSize = 1 ;
    /**
     * 绘制item分割线的画笔，和设置其属性
     * 来绘制个性分割线
     */
    private Paint mPaint ;
    public CHZZDivider(Context context) {
        mDividerDrawable = context.getResources().getDrawable(R.mipmap.list_divider);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG) ;
        mPaint.setColor(Color.BLUE);
         /*设置填充*/
        mPaint.setStyle(Paint.Style.FILL);
    }

    // 如果等于分割线的宽度或高度的话可以不用重写该方法
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildPosition(view) == parent.getChildCount() - 1) {
            outRect.set(0, 0, 0, 0);
        } else {
            outRect.set(0, 0, 0, mDividerDrawable.getIntrinsicHeight());
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        drawVertical(c, parent);
       // drawHorizontal(c,parent);
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        View child;
        RecyclerView.LayoutParams layoutParams;
        int top;
        int bottom;
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            child = parent.getChildAt(i);
            layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            top = child.getBottom() + layoutParams.bottomMargin;
            bottom = top + mDividerDrawable.getIntrinsicHeight();
            mDividerDrawable.setBounds(left, top, right, bottom);
            mDividerDrawable.draw(c);
        }
    }
    /**
     * 绘制横向 item 分割线
     * @param canvas
     * @param parent
     */
    private void drawHorizontal(Canvas canvas, RecyclerView parent){
        final int top = parent.getPaddingTop() ;
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom() ;
        int childCount = parent.getChildCount();
        for(int i = 0 ; i < childCount-1 ; i ++){
            final View child = parent.getChildAt( i ) ;
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin ;
            final int right = left + mDividerDrawable.getIntrinsicHeight();
            mDividerDrawable.setBounds(left, top, right, bottom);
            mDividerDrawable.draw(canvas);
        }
    }
}