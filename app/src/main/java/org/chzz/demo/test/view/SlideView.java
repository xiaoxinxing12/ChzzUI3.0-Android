package org.chzz.demo.test.view;

import android.content.Context;
import android.view.LayoutInflater;

import org.chzz.demo.R;
import org.chzz.picker.view.BasePickerView;

/**
 * Created by copy on 2017/7/11.
 */

public class SlideView  extends BasePickerView {
    public SlideView(Context context) {
        super(context);
        init(context);
    }


  protected  void init(Context context){

      LayoutInflater.from(context).inflate(R.layout.item_play_view, contentContainer);
  }
}
