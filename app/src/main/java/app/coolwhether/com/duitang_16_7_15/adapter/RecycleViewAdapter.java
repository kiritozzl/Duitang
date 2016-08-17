package app.coolwhether.com.duitang_16_7_15.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import app.coolwhether.com.duitang_16_7_15.R;
import app.coolwhether.com.duitang_16_7_15.entity.PopularMainItem;
import app.coolwhether.com.duitang_16_7_15.support.BitmapUtils;

/**
 * Created by Administrator on 2016/8/14.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context mContext;
    private List<PopularMainItem> itemList;
    private boolean isReverse;
    private static final String TAG = "RecycleViewAdapter";

    public RecycleViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public RecycleViewAdapter(Context mContext, boolean isReverse) {
        this.mContext = mContext;
        this.isReverse = isReverse;
        initData();
    }

    private void initData() {
        int[] imageSource = {R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7,
                R.drawable.pic8, R.drawable.pic9};
        String[] descriptionArray = {"萤火之森", "龙族--我们都是小怪兽，终有一天会被正义的奥特曼杀死", "废物利用", "不一样的剪纸", "微型休憩空间",
                "#壁纸#", "简笔画分享", "创意生活", "英伦风", "机智的立夏在学习蹭WiFi"};

        int[] thumbImageArray = {R.drawable.thumb0, R.drawable.thumb1, R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4};
        String[] userNameArray = {"默念那曾时", "来自原始森林的帝企鹅", "年华逝水", "荒年信徒", "红秀",
                "水若印心", "千离", "乖兽", "我不是Candy", "千年老妖"};
        String[] collectPlace = {"超轻粘土", "龙族", "大白", "文字控", "虫不知",
                "布纸喜欢你", "百味美食堂", "备忘录的秘密", "吃吃吃", "插画那些事"};

        itemList = new ArrayList<PopularMainItem>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            PopularMainItem item = new PopularMainItem();
            item.setImgId(imageSource[i]);
            item.setImgDesci(descriptionArray[i]);
            item.setCollectNumber(random.nextInt(500));
            item.setThumbImgId(thumbImageArray[i % 5]);
            item.setUserName(userNameArray[i]);
            item.setCollect(collectPlace[i]);
            itemList.add(item);

        }
        if (isReverse) Collections.reverse(itemList);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        PopularMainItem item = itemList.get(position);
        holder.dhiv.setmRatio(BitmapUtils.getRatios(mContext,item.getImgId()));
        Picasso.with(mContext).load(item.getImgId()).into(holder.dhiv);
        holder.decr.setText(item.getImgDesci());
        //int转为String，否则出错
        holder.star_btn.setText(item.getCollectNumber() + "");
        Picasso.with(mContext).load(item.getThumbImgId()).into(holder.thumb);
        holder.name.setText(item.getUserName());
        holder.colle.setText("收集到 " + item.getCollect());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_item,parent,false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }
}
