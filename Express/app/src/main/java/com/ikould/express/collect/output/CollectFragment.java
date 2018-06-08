package com.ikould.express.collect.output;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adnonstop.frame.fragment.FrameFragment;
import com.ikould.express.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * describe
 * Created by ikould on 2018/6/5.
 */
public class CollectFragment extends FrameFragment {

    @BindView(R.id.tv_add)
    TextView tvAdd;

    public static CollectFragment getInstance() {
        return new CollectFragment();
    }

    @Override
    protected void onBaseCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collect_fragment, container, false);
        setContentView(view);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.tv_add)
    public void onViewClicked() {
    }
}
