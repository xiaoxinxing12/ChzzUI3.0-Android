package org.chzz.demo.ui.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import org.chzz.demo.R;
import org.chzz.widget.CHZZSearchView;

/**
 * Created by copy on 2017/7/26.
 */

public class TestActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private CHZZSearchView searchView;
  int a;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String[] a =new String[]{"a","aa","b"};
            searchView.setSuggestions(a);
            super.handleMessage(msg);
        }
    };
    @Override
    protected void initView() {
setContentView(R.layout.activity_test);
    }

    @Override
    protected void setListener() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        searchView = (CHZZSearchView) findViewById(R.id.search_view);
        searchView.setVoiceSearch(false);
        searchView.setEllipsize(true);
        searchView.setSubmitOnClick(true);
        searchView.setCursorDrawable(R.drawable.color_cursor_white);
        searchView.setOnItemClickListener(this);

       //searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new CHZZSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(TestActivity.this,query+">>>",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(a>0){
                    handler.sendEmptyMessageDelayed(1,1000);
                }
                a=1;

                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(TestActivity.this,"aa",Toast.LENGTH_SHORT).show();
    }
}
