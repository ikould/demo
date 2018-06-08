package com.ikould.express.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.adnonstop.frame.util.KeyBoardUtils;
import com.ikould.express.R;
import com.ikould.express.collect.output.CollectFragment;
import com.ikould.express.shop.output.ShopFragment;
import com.ikould.express.user.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import frame.activity.BaseActivity;
import frame.view.check.CheckLinearLayout;

public class MainActivity extends BaseActivity {

    public static final int TABLE_COLLECT = 0x01;
    public static final int TABLE_SHOP    = 0x02;
    public static final int TABLE_MY      = 0x03;

    @BindView(R.id.fl_main)
    FrameLayout       flMain;
    @BindView(R.id.cll_collect)
    CheckLinearLayout cllCollect;
    @BindView(R.id.cll_shop)
    CheckLinearLayout cllShop;
    @BindView(R.id.cll_my)
    CheckLinearLayout cllMy;


    @Override
    protected void onBaseCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        cllCollect.setCheck(true);
        setImmersive(true);
        replaceTable(TABLE_COLLECT);// 默认收藏页面
    }

    @OnClick({R.id.cll_collect, R.id.cll_shop, R.id.cll_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cll_collect:
                replaceTable(TABLE_COLLECT);
                Log.d("MainActivity", "onViewClicked: cll_collect");
                break;
            case R.id.cll_shop:
                replaceTable(TABLE_SHOP);
                Log.d("MainActivity", "onViewClicked: cll_shop");
                break;
            case R.id.cll_my:
                replaceTable(TABLE_MY);
                Log.d("MainActivity", "onViewClicked: cll_my");
                break;
        }
    }

    public void replaceTable(int tableIndex) {
        switch (tableIndex) {
            case TABLE_COLLECT:
                replaceFragment(R.id.fl_main, CollectFragment.getInstance(), true);
                break;
            case TABLE_SHOP:
                replaceFragment(R.id.fl_main, ShopFragment.getInstance(), true);
                break;
            case TABLE_MY:
                replaceFragment(R.id.fl_main, MyFragment.getInstance(), true);
                break;
        }
    }

    /**
     * 更换Fragment
     */
    public void replaceFragment(int id, Fragment fragment, boolean isDoAnim) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (isDoAnim) {
            fragmentTransaction.setCustomAnimations(R.anim.collect_anim_in_right, R.anim.collect_anim_out_left);
        }
        fragmentTransaction.replace(id, fragment);
        KeyBoardUtils.closeKeyboard(this);
        try {
            fragmentTransaction.commitNow();
        } catch (Exception e) {
            fragmentTransaction.commitAllowingStateLoss();
        }
    }
}
