package app.coolwhether.com.duitang_16_7_15.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/15.
 */
public class ErrorFragment extends Fragment {

    public static ErrorFragment newInstance(String data) {

        Bundle args = new Bundle();
        args.putString("tv",data);
        ErrorFragment fragment = new ErrorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv = new TextView(getContext());
        tv.setText(getArguments().getString("tv"));
        return tv;
    }
}
