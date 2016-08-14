package app.coolwhether.com.duitang_16_7_15.adapter;

import android.content.Context;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.coolwhether.com.duitang_16_7_15.R;
import app.coolwhether.com.duitang_16_7_15.entity.TopItem;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/14.
 */
public class TopImageAdapter extends android.support.v4.view.PagerAdapter {
    private List<TopItem> imageSource;
    private Context mContext;
    public final float[] matrix = new float[]{
            1, 0, 0, 0, -30,
            0, 1, 0, 0, -30,
            0, 0, 1, 0, -30,
            0, 0, 0, 1, 0
    };

    public TopImageAdapter(Context mContext) {
        this.mContext = mContext;
        initData();
    }

    private void initData(){
        imageSource = new ArrayList<>();
        imageSource.add(new TopItem(R.drawable.top1, "我所经历的生活", "4月18日 周六"));
        imageSource.add(new TopItem(R.drawable.top2, "橡皮擦初心", "4月18日 周六"));
        imageSource.add(new TopItem(R.drawable.top3, "一只喵的幸福生活", "4月17日 周五"));
        imageSource.add(new TopItem(R.drawable.top4, "手绘电影场景", "4月16日 周四"));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return imageSource.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.top_view_item,container,false);
        container.addView(view);
        ImageView topImg = ButterKnife.findById(view,R.id.top_img);
        TextView time = ButterKnife.findById(view,R.id.top_tv1);
        TextView title = ButterKnife.findById(view,R.id.top_tv2);

        topImg.setColorFilter(new ColorMatrixColorFilter(matrix));
        TopItem item = imageSource.get(position);
        Picasso.with(mContext).load(item.getImageSource()).into(topImg);
        time.setText(item.getTime());
        title.setText(item.getTitle());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
