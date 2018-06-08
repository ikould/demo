package com.ikould.express.shop.output;

import android.view.View;

/**
 * 基类Layout
 *
 * @author ikould on 2018/3/16.
 */

public abstract class BaseLayout {

    /**
     * 获取ContentView
     */
    public abstract View getContentView();

    /**
     * 显示 需要可以重写
     */
    public void showAnim(boolean isStartAnim) {
    }

    /**
     * 隐藏 需要可以重写
     */
    public void dismissAnim(boolean isStartAnim) {
    }
}
