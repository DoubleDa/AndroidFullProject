package cn.wochu.wh.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * project name：PrefixStorageProject
 * class describe：PDA广播接收器
 * create person：dayongxin
 * create time：16/6/7 下午3:05
 * alter person：dayongxin
 * alter time：16/6/7 下午3:05
 * alter remark：
 */
public abstract class PDAReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String str = null;
        if (action.equals("com.android.scancontext")) {
            //“前台输出”不打勾时，不会发送此Intent
            str = intent.getStringExtra("Scan_context");
        } else if (action.equals("com.android.scanservice.scancontext")) {
            str = intent.getStringExtra("Scan_context");
        }

        //分发条码处理
        dispathCode(str);
    }

    /**
     * 将扫描到的字符串信息输出
     *
     * @param str
     */
    protected abstract void dispathCode(String str);
}
