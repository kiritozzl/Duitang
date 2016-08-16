package app.coolwhether.com.duitang_16_7_15.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import app.coolwhether.com.duitang_16_7_15.ui.DiscoverFragment;
import app.coolwhether.com.duitang_16_7_15.ui.ErrorFragment;
import app.coolwhether.com.duitang_16_7_15.ui.HotFragment;
import app.coolwhether.com.duitang_16_7_15.ui.NewsFragment;
import app.coolwhether.com.duitang_16_7_15.ui.PopularFragment;

/**
 * Created by Administrator on 2016/7/18.
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private String []title = {"热门","发现","动态","消息"};

    public PagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PopularFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new HotFragment();
            case 3:
                return new NewsFragment();
            default:
                return ErrorFragment.newInstance(position + "");
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
