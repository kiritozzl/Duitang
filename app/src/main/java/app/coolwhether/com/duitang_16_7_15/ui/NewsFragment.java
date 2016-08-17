package app.coolwhether.com.duitang_16_7_15.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.coolwhether.com.duitang_16_7_15.R;

/**
 * Created by Administrator on 2016/8/15.
 */
public class NewsFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfragment,container,false);
        return view;
    }
}
