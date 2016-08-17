package app.coolwhether.com.duitang_16_7_15.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.coolwhether.com.duitang_16_7_15.R;
import app.coolwhether.com.duitang_16_7_15.adapter.RecycleViewAdapter;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/15.
 */
public class HotFragment extends Fragment {
    private RecyclerView rcv;
    private StaggeredGridLayoutManager manager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview,container,false);
        ButterKnife.bind(this,view);
        rcv = ButterKnife.findById(view,R.id.recyclerview);
        rcv.setHasFixedSize(true);
        manager = new StaggeredGridLayoutManager(2,1);
        rcv.setLayoutManager(manager);
        RecycleViewAdapter adapter = new RecycleViewAdapter(getActivity(),true);
        rcv.setAdapter(adapter);

        return view;
    }
}
