package org.chzz.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.chzz.demo.ui.activity.BindingRefreshActivity;
import org.chzz.demo.ui.activity.CoordinatorActivity;
import org.chzz.demo.ui.activity.CustomActivity;
import org.chzz.demo.ui.activity.DialogActivity;
import org.chzz.demo.ui.activity.GuideActivity;
import org.chzz.demo.ui.activity.RefreshActivity;
import org.chzz.widget.CHZZLoadDataLayout;

public class MainActivity extends AppCompatActivity {
    CHZZLoadDataLayout loadDataLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
        loadDataLayout.setStatus(CHZZLoadDataLayout.SUCCESS);
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
        Button coordinator = (Button) findViewById(R.id.but_coordinator);
        coordinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
            }
        });
        Button banner = (Button) findViewById(R.id.but_banner);
        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GuideActivity.class));
            }
        });
        Button dialog = (Button) findViewById(R.id.but_dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DialogActivity.class));
            }
        });
    }
}
