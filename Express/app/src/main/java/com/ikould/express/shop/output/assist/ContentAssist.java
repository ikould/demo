package com.ikould.express.shop.output.assist;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ikould.express.shop.output.BaseLayout;
import com.ikould.express.shop.output.layout.ClassifyLayout;
import com.ikould.express.shop.output.layout.HotLayout;
import com.ikould.express.shop.output.layout.NewLayout;

import frame.activity.BaseActivity;
import frame.view.check.CheckTextView;

/**
 * 最新、最热、分类内容替换协助类
 * <p>
 * Created by ikould on 2018/6/5.
 */
public class ContentAssist {

    public static final int TYPE_HOT      = 0x01;
    public static final int TYPE_NEW      = 0x02;
    public static final int TYPE_CLASSIFY = 0x03;

    // ====== 单例 ======

    private volatile static ContentAssist instance;

    public static ContentAssist getInstance() {
        if (instance == null) {
            synchronized (ContentAssist.class) {
                if (instance == null) {
                    instance = new ContentAssist();
                }
            }
        }
        return instance;
    }

    private ContentAssist() {
    }

    // ====== 操作 ======

    private BaseActivity mActivity;
    private FrameLayout  flMain;
    private LinearLayout llHot;
    private LinearLayout llNew;
    private LinearLayout llClassify;
    private LinearLayout lastType;

    // ========== 公开方法 ==========

    /**
     * 初始化
     */
    public void init(BaseActivity mActivity, FrameLayout flMain, LinearLayout llHot, LinearLayout llNew, LinearLayout llClassify) {
        this.mActivity = mActivity;
        this.flMain = flMain;
        this.llHot = llHot;
        this.llNew = llNew;
        this.llClassify = llClassify;
        initListener();
        switchContent(TYPE_HOT);
    }

    /**
     * 切换内容
     */
    public void switchContent(int type) {
        BaseLayout layout;
        setCheck(lastType, false);
        flMain.removeAllViews();
        switch (type) {
            case TYPE_HOT:
                setCheck(llHot, true);
                lastType = llHot;
                layout = new HotLayout(mActivity);
                flMain.addView(layout.getContentView());
                break;
            case TYPE_NEW:
                setCheck(llNew, true);
                lastType = llNew;
                layout = new NewLayout(mActivity);
                flMain.addView(layout.getContentView());
                break;
            case TYPE_CLASSIFY:
                setCheck(llClassify, true);
                lastType = llClassify;
                layout = new ClassifyLayout(mActivity);
                flMain.addView(layout.getContentView());
                break;
        }
    }

    /**
     * 清空所有
     */
    public void clearAll() {
        mActivity = null;
        llHot = null;
        llNew = null;
        llClassify = null;
        lastType = null;
    }

    // ========== 私有方法 ==========

    /**
     * 初始化监听
     */
    private void initListener() {
        llHot.setOnClickListener(v -> {
            switchContent(TYPE_HOT);
        });
        llNew.setOnClickListener(v -> {
            switchContent(TYPE_NEW);
        });
        llClassify.setOnClickListener(v -> {
            switchContent(TYPE_CLASSIFY);
        });
    }

    /**
     * 设置三种状态
     */
    private void setCheck(LinearLayout llType, boolean isChecked) {
        if (llType == null)
            return;
        int count = llType.getChildCount();
        if (count > 0) {
            View view = llType.getChildAt(0);
            if (view instanceof CheckTextView) {
                ((CheckTextView) view).setCheck(isChecked);
            }
            if (count > 1) {
                View view1 = llType.getChildAt(1);
                view1.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
            }
        }
    }
}
