package cn.wochu.wh.utils;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/16 上午11:04
 * alter person：dayongxin
 * alter time：16/6/16 上午11:04
 * alter remark：
 */
public class CheckGoodsNumUtil {
    public static boolean isWochuGoodsNum(String str) {
        if (str.contains("WOC")) {
            return true;
        }
        return false;
    }
}
