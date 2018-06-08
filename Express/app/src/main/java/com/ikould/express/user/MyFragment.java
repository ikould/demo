package com.ikould.express.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adnonstop.frame.fragment.FrameFragment;
import com.ikould.express.R;

import butterknife.ButterKnife;

/**
 * describe
 * Created by ikould on 2018/5/30.
 */
public class MyFragment extends FrameFragment {

    public static MyFragment getInstance() {
        return new MyFragment();
    }

    @Override
    protected void onBaseCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        setContentView(view);
        ButterKnife.bind(this, view);
    }
}
