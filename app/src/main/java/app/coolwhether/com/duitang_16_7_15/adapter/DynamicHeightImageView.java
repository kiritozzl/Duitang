package app.coolwhether.com.duitang_16_7_15.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/8/14.
 */
public class DynamicHeightImageView extends ImageView {
    private double mRatio;

    public DynamicHeightImageView(Context context) {
        super(context);
    }

    public DynamicHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public double getmRatio() {
        return mRatio;
    }

    public void setmRatio(double mRatio) {
        if (mRatio != this.mRatio){
            this.mRatio = mRatio;
            requestLayout();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mRatio > 0.0){
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = (int)(width * mRatio);
            setMeasuredDimension(width,height);
        }
        else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
