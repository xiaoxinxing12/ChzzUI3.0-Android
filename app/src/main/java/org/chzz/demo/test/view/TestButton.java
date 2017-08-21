package org.chzz.demo.test.view;

import android.content.Context;
import android.view.MotionEvent;

/**
 * Created by copy on 2017/7/26.
 */

public class TestButton extends android.support.v7.widget.AppCompatButton {
    public TestButton(Context context) {
        super(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
