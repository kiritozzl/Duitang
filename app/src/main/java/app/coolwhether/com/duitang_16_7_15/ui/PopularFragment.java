package app.coolwhether.com.duitang_16_7_15.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;

import app.coolwhether.com.duitang_16_7_15.R;
import app.coolwhether.com.duitang_16_7_15.adapter.TopImageAdapter;
import app.coolwhether.com.duitang_16_7_15.adapter.staggerAdapter;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/13.
 */
public class PopularFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private ViewPager pagerImages;
    private ClumsyIndicator indicator;

    private StaggeredGridView staggeredGridView;
    private SwipeRefreshLayout sr_layout;

    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pf_layout,container,false);
        ButterKnife.bind(this,view);
        View topView = inflater.inflate(R.layout.top_view,(ViewGroup)view,false);
        pagerImages = ButterKnife.findById(topView,R.id.image_pager);
        indicator = ButterKnife.findById(topView,R.id.indicator);

        staggeredGridView = ButterKnife.findById(view,R.id.staggeredgridview);
        sr_layout = ButterKnife.findById(view,R.id.sr_layout);
        staggeredGridView.addHeaderView(topView);
        handler = new Handler();
        initView();
        return view;
    }

    private void initView(){
        TopImageAdapter topImageAdapter = new TopImageAdapter(getActivity());
        pagerImages.setAdapter(topImageAdapter);
        indicator.setIndicatorCount(pagerImages);
        staggerAdapter adapter = new staggerAdapter(getActivity(),false);
        staggeredGridView.setAdapter(adapter);

        sr_layout.setOnRefreshListener(this);//需在主activity，implements SwipeRefreshLayout.OnRefreshListener
        sr_layout.setColorSchemeColors(R.color.red);//设置加载时的颜色显示

        pagerImages.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            boolean isHandle = false;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (!isHandle && positionOffsetPixels > 0){
                    sr_layout.setEnabled(false);
                    isHandle = true;
                }
            }

            @Override
            public void onPageSelected(int position) {
                indicator.setmSelectedItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case ViewPager.SCROLL_STATE_IDLE:
                        sr_layout.setEnabled(true);
                        isHandle = false;
                        break;
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sr_layout.setRefreshing(false);
                Toast.makeText(getContext(),"刷新完毕！",Toast.LENGTH_SHORT).show();
            }
        },3000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null){
            int currentItem = savedInstanceState.getInt("pager_current_item");
            pagerImages.setCurrentItem(currentItem);
        }
    }

    //保存imgPager状态
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("pager_current_item",pagerImages.getCurrentItem());
    }
}
