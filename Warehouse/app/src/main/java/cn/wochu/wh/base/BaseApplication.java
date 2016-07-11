package cn.wochu.wh.base;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午4:58
 * alter person：dayongxin
 * alter time：16/6/12 下午4:58
 * alter remark：
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    private void init() {
        LogUtils.configAllowLog = true;
        LogUtils.configTagPrefix = "***Warehouse***";
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }
}
