package com.ikould.express;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;

import com.adnonstop.frame.application.FrameApplication;
import com.adnonstop.frame.config.FrameAppConfig;
import com.adnonstop.frame.database.DbBean;
import com.adnonstop.frame.util.PLog;
import com.adnonstop.frame.util.PackageUtil;

/**
 * 唯一的Application
 */

public class CoreApplication extends FrameApplication {

    // 网络请求版本(当前调用）
    public static String netRequestCode = "1.0.0";
    /**
     * 字体样式
     */
    public Typeface PFRegularTypeface;
    public Typeface PFMediumTypeface;
    public Typeface PFHeavyTypeface;

    // App启动Application时间
    public         long            startAppTime;
    // 配置是否初始化
    private        boolean         isConfigInit;
    // 设备id
    private        String          deviceId;
    // 数据库实体类
    public         DbBean          dbBean;
    // 调用Application实体类
    private static CoreApplication instance;

    public static CoreApplication getInstance() {
        return instance;
    }

    @Override
    protected void onBaseCreate() {
        instance = this;
        PLog.d("CoreApplication", "onBaseCreate: ");
        startAppTime = System.currentTimeMillis();
        PFRegularTypeface = Typeface.DEFAULT;
        PFMediumTypeface = Typeface.DEFAULT;
        PFHeavyTypeface = Typeface.DEFAULT;
        initConfig();
    }

    /**
     * 初始化配置，由WelcomeActivity获取权限后统一调用
     */
    public boolean initConfig() {
        PLog.d("CoreApplication", "initConfig: isConfigInit = " + isConfigInit);
        if (!isConfigInit && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            PLog.d("CoreApplication", "initConfig: ");
            isConfigInit = true;
            deviceId = /*PhoneTools.getIMEI(this)*/"abcd1234";
            // SharedPreference 初始化
            FrameAppConfig.getInstance().init(this);
            // 初始化数据库
            initDb();
            // 崩溃拦截
            setCrashHandlerEnable(true);
            // 网络请求版本
            netRequestCode = PackageUtil.getVersionName(this);
            return true;
        }
        return isConfigInit;
    }

    /**
     * 初始化数据库
     */
    private void initDb() {
        /*
         * App版本 1.6.0 -> 数据库版本 1
         * App版本 1.6.1 -> 数据库版本 2
         * App版本 1.6.5 -> 数据库版本 3
         * App版本 1.7.0 -> 数据库版本 4
         */
        dbBean = new DbBean(this, "ArtCamera", 4);
    }
}
