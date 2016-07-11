package cn.wochu.wh.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreUtil {

    private static final String CONFIG = "config";

    //存储boolean类型的属性
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        sp.edit().putBoolean(key, value).commit();
    }

    //取得boolean类型的属性值
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        return sp.getBoolean(key, defValue);
    }

    //存储String类型的属性
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        sp.edit().putString(key, value).commit();
    }

    //取得String类型的属性值
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        return sp.getString(key, defValue);
    }

    //存储int类型的属性
    public static void putInteger(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        sp.edit().putInt(key, value).commit();
    }

    public static void putFloat(Context context, String key, float value) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        sp.edit().putFloat(key, value).commit();
    }

    //取得int类型的属性值
    public static int getInteger(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        return sp.getInt(key, defValue);
    }

    public static float getFloate(Context context, String key, float defValue) {
        SharedPreferences sp = context.getSharedPreferences(CONFIG, 0);
        return sp.getFloat(key, defValue);
    }
}
