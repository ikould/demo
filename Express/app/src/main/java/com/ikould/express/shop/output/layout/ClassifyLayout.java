package com.ikould.express.shop.output.layout;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import com.ikould.express.R;
import com.ikould.express.shop.output.BaseLayout;

import butterknife.ButterKnife;

/**
 * 分类
 * <p>
 * Created by ikould on 2018/6/5.
 */
public class ClassifyLayout extends BaseLayout {

    private View mView;

    public ClassifyLayout(Activity activity) {
        mView = LayoutInflater.from(activity).inflate(R.layout.shop_layout_classify, null);
        ButterKnife.bind(this, mView);
        initView();
        initListener();
    }

    @Override
    public View getContentView() {
        return mView;
    }

    private void initView() {

    }

    private void initListener() {

    }
}
