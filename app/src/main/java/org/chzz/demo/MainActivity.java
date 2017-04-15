package org.chzz.demo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.chzz.demo.ui.BindingRefreshActivity;
import org.chzz.demo.ui.CustomActivity;
import org.chzz.demo.ui.RefreshActivity;
import org.chzz.widget.CHZZLoadDataLayout;

public class MainActivity extends AppCompatActivity {
    CHZZLoadDataLayout loadDataLayout;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            loadDataLayout.setStatus(CHZZLoadDataLayout.SUCCESS);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
        loadDataLayout.setStatus(CHZZLoadDataLayout.LOADING);
        handler.sendEmptyMessageDelayed(1, 3000);
    }

    private void setListener() {
        loadDataLayout = (CHZZLoadDataLayout) findViewById(R.id.loadLayout);
        Button customView = (Button) findViewById(R.id.but_customView);
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomActivity.class));
            }
        });
        Button refreshView = (Button) findViewById(R.id.but_Refresh);
        refreshView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RefreshActivity.class));
            }
        });
        Button bindingRefreshView = (Button) findViewById(R.id.but_bindingRefresh);
        bindingRefreshView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BindingRefreshActivity.class));
            }
        });
    }
}
