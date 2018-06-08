package com.ikould.express.shop.output;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.adnonstop.frame.fragment.FrameFragment;
import com.ikould.express.R;
import com.ikould.express.shop.output.assist.ContentAssist;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import frame.activity.BaseActivity;


/**
 * describe
 * Created by ikould on 2018/6/5.
 */
public class ShopFragment extends FrameFragment {

    @BindView(R.id.tv_add)
    TextView       tvAdd;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.ll_type)
    LinearLayout   llType;
    @BindView(R.id.fl_main)
    FrameLayout    flMain;
    @BindView(R.id.ll_hot)
    LinearLayout   llHot;
    @BindView(R.id.ll_new)
    LinearLayout   llNew;
    @BindView(R.id.ll_classify)
    LinearLayout   llClassify;

    public static ShopFragment getInstance() {
        return new ShopFragment();
    }

    @Override
    protected void onBaseCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shop_fragment, container, false);
        setContentView(view);
        ButterKnife.bind(this, view);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        ContentAssist.getInstance().init((BaseActivity) getActivity(), flMain, llHot, llNew, llClassify);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ContentAssist.getInstance().clearAll();
    }

    @OnClick(R.id.tv_add)
    public void onViewClicked() {
    }
}
