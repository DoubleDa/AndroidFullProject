package cn.wochu.wh.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/23 下午3:37
 * alter person：dayongxin
 * alter time：16/6/23 下午3:37
 * alter remark：
 */
public class VersionUtils {
    public static String getVersionName(Context context) {
        String packName = context.getPackageName();
        try {
            String versionName = context.getPackageManager().getPackageInfo(packName, PackageManager.GET_CONFIGURATIONS).versionName;
            return versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

}
