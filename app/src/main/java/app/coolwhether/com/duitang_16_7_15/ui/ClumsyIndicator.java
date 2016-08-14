package app.coolwhether.com.duitang_16_7_15.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import app.coolwhether.com.duitang_16_7_15.R;

/**
 * Created by Administrator on 2016/8/13.
 */
public class ClumsyIndicator extends View {
    private int mCount;
    private int mSelectedItem;
    private float mRadius;
    private float mSelectedRadius;
    private float mSpace;
    private Paint mPaint;

    public ClumsyIndicator(Context context) {
        super(context);
    }

    public ClumsyIndicator(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public ClumsyIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setSize();
        initPaint();
    }

    private void setSize(){
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        mRadius = 2 * metrics.density;
        mSelectedRadius = 3 * metrics.density;
        mSpace = 12 * metrics.density;
    }

    private void initPaint(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.light_grey));
        mPaint.setStyle(Paint.Style.FILL);
    }

    public void setIndicatorCount(ViewPager viewPager){
        mCount = viewPager.getAdapter().getCount();
        invalidate();
    }

    public void setmSelectedItem(int position){
        mSelectedItem = position;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec){
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        int result;
        if (specMode != MeasureSpec.EXACTLY){
            result = getPaddingBottom() + getPaddingTop() + (int)(mSelectedRadius * 2);
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }else {
            result = specSize;
        }
        return result;
    }

    private int MeasureWidth(int widthMeasureSpec){
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        int result;
        if (specMode != MeasureSpec.EXACTLY){
            result = getPaddingLeft() + getPaddingRight() + (int)(mSpace * mCount);
            if (specMode == MeasureSpec.AT_MOST){
                result = specSize;
            }
        }else {
            result = specSize;
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float y = getHeight() / 2;
        float x = mSpace / 2;
        for (int i = 0;i < mCount;i++){
            if (i == mSelectedItem){
                canvas.drawCircle(x,y,mSelectedRadius,mPaint);
            }else {
                canvas.drawCircle(x,y,mRadius,mPaint);
            }
            x += mSpace;
        }
    }
}
