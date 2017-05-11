package org.chzz.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.chzz.demo.adapter.DropMenuAdapter;
import org.chzz.demo.model.MenuEntity;
import org.chzz.demo.ui.activity.BindingRefreshActivity;
import org.chzz.demo.ui.activity.CoordinatorActivity;
import org.chzz.demo.ui.activity.CustomActivity;
import org.chzz.demo.ui.activity.DialogActivity;
import org.chzz.demo.ui.activity.GuideActivity;
import org.chzz.demo.ui.activity.RefreshActivity;
import org.chzz.downmenu.DropDownMenu;
import org.chzz.widget.CHZZLoadDataLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements DropMenuAdapter.OnFilterDoneListener {
    CHZZLoadDataLayout loadDataLayout;
    private String[] leaveType = {"全部审核通过审核通过全部审核通过审核通过", "待审核", "审核通过", "审核不通过", "草稿"};
    private String[] leaveType1 = {"全部", "待审核", "审核通过", "审核不通过", "草稿"};
    private int[] leaveTypeIds = {-1, 0, 1, 2, 5};
    DropDownMenu dropDownMenu;
    private String[] key = {"leaveType","leaveType1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dropDownMenu = (DropDownMenu) findViewById(R.id.dropDownMenu);
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
        setLeaveTypeId();
    }

    private void setLeaveTypeId() {
        Map<String, MenuEntity> menuList = new HashMap<>();
        List<MenuEntity.ListEntity> LeaveTypeList = new ArrayList<>();
        MenuEntity LeaveTypeMenu = new MenuEntity();
        for (int i = 0; i < 5; i++) {
            MenuEntity.ListEntity m = new MenuEntity.ListEntity();
            m.setId(leaveTypeIds[i]);
            m.setTitle(leaveType[i]);
            LeaveTypeList.add(m);
        }

        LeaveTypeMenu.setCode(0);
        LeaveTypeMenu.setTitle(LeaveTypeList.get(0).getTitle());
        LeaveTypeMenu.setList(LeaveTypeList);
        menuList.put("leaveType", LeaveTypeMenu);

        List<MenuEntity.ListEntity> LeaveTypeList1 = new ArrayList<>();
        MenuEntity LeaveTypeMenu1 = new MenuEntity();
        for (int i = 0; i < 5; i++) {
            MenuEntity.ListEntity m = new MenuEntity.ListEntity();
            m.setId(leaveTypeIds[i]);
            m.setTitle(leaveType1[i]);
            LeaveTypeList1.add(m);
        }

        LeaveTypeMenu1.setCode(0);
        LeaveTypeMenu1.setTitle(LeaveTypeList1.get(0).getTitle());
        LeaveTypeMenu1.setList(LeaveTypeList1);
        menuList.put("leaveType1", LeaveTypeMenu1);

        DropMenuAdapter dropMenuAdapter = new DropMenuAdapter(this, menuList, key, this);
        dropDownMenu.setMenuAdapter(dropMenuAdapter);
    }

    @Override
    public void onFilterDone(int position, String code, String positionTitle, String urlValue) {

    }
}
