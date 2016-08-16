package app.coolwhether.com.duitang_16_7_15.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import app.coolwhether.com.duitang_16_7_15.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/14.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.rcv_item_img)
    DynamicHeightImageView dhiv;

    @BindView(R.id.rcv_item_descr)
    TextView decr;

    @BindView(R.id.rcv_item_collbtn)
    Button star_btn;

    @BindView(R.id.rcv_item_thumb)
    ImageView thumb;

    @BindView(R.id.rcv_item_username)
    TextView name;

    @BindView(R.id.rcv_item_collectv)
    TextView colle;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }
}
