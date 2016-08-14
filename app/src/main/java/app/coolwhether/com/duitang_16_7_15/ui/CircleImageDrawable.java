package app.coolwhether.com.duitang_16_7_15.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/8/13.
 */
public class CircleImageDrawable extends Drawable {
    private Bitmap mBitmap;
    private Paint mPaint;
    private int mWidth;

    public CircleImageDrawable(Bitmap mBitmap) {
        this.mBitmap = mBitmap;
        mPaint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);
        mWidth = Math.min(mBitmap.getWidth(),mBitmap.getHeight());
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(mWidth / 2,mWidth / 2,mWidth / 2,mPaint);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicHeight() {
        return mWidth;
    }

    @Override
    public int getIntrinsicWidth() {
        return mWidth;
    }
}
