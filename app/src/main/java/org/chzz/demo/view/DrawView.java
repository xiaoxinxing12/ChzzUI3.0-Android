package org.chzz.demo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import org.chzz.demo.R;

/**
 * Created by copy on 2017/4/14.
 */

public class DrawView extends View {
    private float mWidth, mHeight;   //屏幕的宽高
    private float mRectWidth, mRectHeight;   //单个按键的宽高
    private boolean isInit;
    private int mRound = 6;
    private Context mContext;
    private onNumberClickListener onNumberClickListener;
    private String number;
    private float x1, y1, x2, y2,clickX,clickY;
    private int type;//0按下 1弹起

    public DrawView(Context context) {
        super(context);
        mContext = context;
    }

    public void setOnNumberClickListener(DrawView.onNumberClickListener onNumberClickListener) {
        this.onNumberClickListener = onNumberClickListener;
    }

    private void init() {
        mWidth = getWidth();
        mHeight = getHeight();
        mRectWidth = (mWidth - 40) / 3;   //每个按键左右间距10
        mRectHeight = (mHeight - 100) / 8;//每个按键上下间距10
        isInit = true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (!isInit) {
            init();
        }
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        //float left,float top,float right,float bottom,float rx,float ry,Paint paint
        //第一排
        canvas.drawRoundRect(10, mHeight / 2 + 10, 10 + mRectWidth, mHeight / 2 + 10 + mRectHeight, mRound, mRound, paint);
        canvas.drawRoundRect(20 + mRectWidth, mHeight / 2 + 10, 20 + mRectWidth * 2, mHeight / 2 + 10 + mRectHeight, mRound, mRound, paint);
        canvas.drawRoundRect(30 + mRectWidth * 2, mHeight / 2 + 10, 30 + mRectWidth * 3, mHeight / 2 + 10 + mRectHeight, mRound, mRound, paint);
        //第二排
        canvas.drawRoundRect(10, mHeight / 2 + 20 + mRectHeight, 10 + mRectWidth, mHeight / 2 + 20 + mRectHeight * 2, mRound, mRound, paint);
        canvas.drawRoundRect(20 + mRectWidth, mHeight / 2 + 20 + mRectHeight, 20 + mRectWidth * 2, mHeight / 2 + 20 + mRectHeight * 2, mRound, mRound, paint);
        canvas.drawRoundRect(30 + mRectWidth * 2, mHeight / 2 + 20 + mRectHeight, 30 + mRectWidth * 3, mHeight / 2 + 20 + mRectHeight * 2, mRound, mRound, paint);
        //第三排
        canvas.drawRoundRect(10, mHeight / 2 + 30 + mRectHeight * 2, 10 + mRectWidth, mHeight / 2 + 30 + mRectHeight * 3, mRound, mRound, paint);
        canvas.drawRoundRect(20 + mRectWidth, mHeight / 2 + 30 + mRectHeight * 2, 20 + mRectWidth * 2, mHeight / 2 + 30 + mRectHeight * 3, mRound, mRound, paint);
        canvas.drawRoundRect(30 + mRectWidth * 2, mHeight / 2 + 30 + mRectHeight * 2, 30 + mRectWidth * 3, mHeight / 2 + 30 + mRectHeight * 3, mRound, mRound, paint);
        //第四排
        paint.setColor(Color.GRAY);
        canvas.drawRoundRect(10, mHeight / 2 + 40 + 3 * mRectHeight, 10 + mRectWidth, mHeight / 2 + 40 + 4 * mRectHeight, mRound, mRound, paint);
        paint.setColor(Color.WHITE);
        canvas.drawRoundRect(20 + mRectWidth, mHeight / 2 + 40 + 3 * mRectHeight, 20 + 2 * mRectWidth, mHeight / 2 + 40 + 4 * mRectHeight, mRound, mRound, paint);
        paint.setColor(Color.GRAY);
        canvas.drawRoundRect(30 + 2 * mRectWidth, mHeight / 2 + 40 + 3 * mRectHeight, 30 + 3 * mRectWidth, mHeight / 2 + 40 + 4 * mRectHeight, mRound, mRound, paint);

        //画文字
        paint.setColor(getResources().getColor(R.color.colorPrimary));
        paint.setTextSize(60);
        canvas.drawText("1", mRectWidth / 2, mHeight / 2 + 30 + mRectHeight / 2, paint);
        canvas.drawText("2", mRectWidth + 10 + mRectWidth / 2, mHeight / 2 + 30 + mRectHeight / 2, paint);
        canvas.drawText("3", mRectWidth * 2 + 10 + mRectWidth / 2, mHeight / 2 + 30 + mRectHeight / 2, paint);

        canvas.drawText("4", mRectWidth / 2, mHeight / 2 + 40 + mRectHeight / 2 + mRectHeight, paint);
        canvas.drawText("5", mRectWidth + 10 + mRectWidth / 2, mHeight / 2 + 40 + mRectHeight / 2 + mRectHeight, paint);
        canvas.drawText("6", mRectWidth * 2 + 10 + mRectWidth / 2, mHeight / 2 + 40 + mRectHeight / 2 + mRectHeight, paint);

        canvas.drawText("7", mRectWidth / 2, mHeight / 2 + 50 + mRectHeight / 2 + mRectHeight * 2, paint);
        canvas.drawText("8", mRectWidth + 10 + mRectWidth / 2, mHeight / 2 + 50 + mRectHeight / 2 + mRectHeight * 2, paint);
        canvas.drawText("9", mRectWidth * 2 + 10 + mRectWidth / 2, mHeight / 2 + 50 + mRectHeight / 2 + mRectHeight * 2, paint);

        canvas.drawText(".", mRectWidth / 2, mHeight / 2 + 50 + mRectHeight / 2 + mRectHeight * 3, paint);
        canvas.drawText("0", mRectWidth + 10 + mRectWidth / 2, mHeight / 2 + 50 + mRectHeight / 2 + mRectHeight * 3, paint);
        canvas.drawText("删除", mRectWidth * 2 + mRectWidth / 2, mHeight / 2 + 50 + mRectHeight / 2 + mRectHeight * 3, paint);

        if(type==1){
            paint.setColor(getResources().getColor(R.color.colorPrimary));
            canvas.drawRoundRect(x1,y1,x2,y2,mRound,mRound,paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(60);
            canvas.drawText(number,clickX,clickY,paint);
        }
        if(type==2){
          //  paint.setColor(Color.WHITE);
           // canvas.drawRoundRect(x1,y1,x2,y2,mRound,mRound,paint);
            paint.setColor(Color.BLUE);
            paint.setTextSize(60);
            canvas.drawText(number,clickX,clickY,paint);
        }
        clickX = 0;
        clickY = 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                type=2;
                if (null != onNumberClickListener && null != number) {
                    if (number.equals("delete")) {
                        onNumberClickListener.onNumberDelete();
                    } else {
                        onNumberClickListener.onNumberReturn(number + "");
                    }
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_DOWN:

                handleTouch(x, y);
                return true;

        }
        return false;
    }

    private void handleTouch(float x, float y) {
        if (y < mHeight / 2) {
            return;
        }
        if (mHeight / 2 < y && y < mHeight / 2 + mRectHeight) {
            if (x < mRectWidth + 10) {
                x1 = 10;
                y1 = mHeight / 2 + 10;
                x2 = 10 + mRectWidth;
                y2 = mHeight / 2 + mRectHeight+10;
                clickX=mRectWidth/2;
                clickY=mHeight / 2 + 30 + mRectHeight / 2;
                number = "1";
            }
            if (mRectWidth + 20 < x && x < mRectWidth * 2 + 10) {
                number = "2";
            }
            if (mRectWidth * 2 + 30 < x && x < mRectWidth * 3 + 10) {
                number = "3";
            }
        }
        if (mHeight / 2 + mRectHeight + 10 < y && y < mHeight / 2 + mRectHeight * 2 + 10) {
            if (x < mRectWidth + 10) {
                number = "4";
            }
            if (mRectWidth + 20 < x && x < mRectWidth * 2 + 10) {
                number = "5";
            }
            if (mRectWidth * 2 + 30 < x && x < mRectWidth * 3 + 10) {
                number = "6";
            }
        }
        if (mHeight / 2 + mRectHeight * 2 + 20 < y && y < mHeight / 2 + mRectHeight * 3 + 30) {
            if (x < mRectWidth + 10) {
                number = "7";
            }
            if (mRectWidth + 20 < x && x < mRectWidth * 2 + 10) {
                number = "8";
            }
            if (mRectWidth * 2 + 30 < x && x < mRectWidth * 3 + 10) {
                number = "9";
            }
        }
        if (mHeight / 2 + mRectHeight * 3 + 30 < y && y < mHeight / 2 + mRectHeight * 4 + 40) {
            if (x < mRectWidth + 10) {
                number = ".";
            }
            if (mRectWidth + 20 < x && x < mRectWidth * 2 + 10) {
                number = "0";
            }
            if (mRectWidth * 2 + 30 < x && x < mRectWidth * 3 + 10) {
                number = "delete";
            }
        }
        type=1;
        invalidate();
    }

    public interface onNumberClickListener {
        //回调点击的数字
        public void onNumberReturn(String number);

        //删除键的回调
        public void onNumberDelete();
    }
}
