package app.coolwhether.com.duitang_16_7_15;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;

import com.astuetz.PagerSlidingTabStrip;

import java.lang.reflect.Field;

import app.coolwhether.com.duitang_16_7_15.adapter.PagerAdapter;
import app.coolwhether.com.duitang_16_7_15.ui.CircleImageDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.slidingTab)
    PagerSlidingTabStrip tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager
        .LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setActionBar();
        viewPager.setOffscreenPageLimit(4);
        //当继承AppCompatActivity时才能使用getSupportFragmentManager()
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    private void setActionBar(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.user_default_face);
        ActionBar actionBar = getActionBar();
        actionBar.setTitle("用户");
        actionBar.setIcon(new CircleImageDrawable(bitmap));
        actionBar.setHomeButtonEnabled(true);
        setOverflowShowingAlways();
    }

    private void setOverflowShowingAlways(){
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKeyField.setAccessible(true);
            menuKeyField.setBoolean(viewConfiguration,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
