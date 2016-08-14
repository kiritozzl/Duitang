package app.coolwhether.com.duitang_16_7_15.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.coolwhether.com.duitang_16_7_15.R;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/13.
 */
public class PopularFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private ViewPager pagerImages;
    private ClumsyIndicator indicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pf_layout,container,false);
        ButterKnife.bind(this,view);
        View topView = inflater.inflate(R.layout.top_view,(ViewGroup)view,false);
        pagerImages = ButterKnife.findById(topView,R.id.image_pager);
        indicator = ButterKnife.findById(topView,R.id.indicator);

        return view;
    }

    private void initView(){

    }

    @Override
    public void onRefresh() {

    }
}
