package org.chzz.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.chzz.demo.R;
import org.chzz.demo.view.DrawView;


public class CustomActivity extends AppCompatActivity implements DrawView.onNumberClickListener {
    LinearLayout linearLayout;
    TextView mTv;
    StringBuffer stringBuffer = new StringBuffer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        linearLayout = (LinearLayout) findViewById(R.id.ll_content);
        mTv = (TextView) findViewById(R.id.tv_number);
        drawView();
    }

    private void drawView() {
        DrawView view = new DrawView(this);
        linearLayout.addView(view);
        view.setOnNumberClickListener(this);
    }

    @Override
    public void onNumberReturn(String number) {
        Toast.makeText(this, number, Toast.LENGTH_SHORT).show();
        stringBuffer.append(number);
        mTv.setText(stringBuffer);
    }

    @Override
    public void onNumberDelete() {
        if(stringBuffer.length()>0)
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        mTv.setText(stringBuffer);
    }
}
