package org.chzz.demo.ui.activity;


import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import org.chzz.demo.R;
import org.chzz.demo.ui.fragment.CoordinatorFragment;

/**
 * Created by copy on 2017/4/17.
 */

public class CoordinatorActivity extends BaseActivity {
    private Class[] mFragmentClasses = new Class[]{CoordinatorFragment.class,CoordinatorFragment.class, CoordinatorFragment.class, CoordinatorFragment.class, CoordinatorFragment.class, CoordinatorFragment.class,  CoordinatorFragment.class, CoordinatorFragment.class};



    TabLayout tabLayout;

    ViewPager viewPager;

    AppBarLayout appBar;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_coordinator);

    }

    public AppBarLayout getAppBar() {
        return appBar;
    }

    @Override
    protected void setListener() {
        ContentPagerAdapter contentPagerAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(contentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(contentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ContentPagerAdapter extends FragmentStatePagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return Fragment.instantiate(CoordinatorActivity.this, mFragmentClasses[position].getName());
        }

        @Override
        public int getCount() {
            return mFragmentClasses.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentClasses[position].getSimpleName().replace("Fragment", "");
        }
    }

}
