package cn.wochu.wh.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * project name：PrefixStorageProject
 * class describe：
 * create person：dayongxin
 * create time：16/6/7 上午11:16
 * alter person：dayongxin
 * alter time：16/6/7 上午11:16
 * alter remark：
 */
public class ToastUtil {
    private static Toast toast = null;
    private static Toast currentToast;
    private static View toastView;

    /**
     * 图片消息提示
     *
     * @param context
     * @param imgResId
     * @param charSequence
     * @param duration
     */
    public static void imageToast(Context context, int imgResId, CharSequence charSequence, int duration) {
        // 创建一个Toast提示消息
        toast = Toast.makeText(context, charSequence, duration);
        // 设置Toast提示消息在屏幕上的位置
        toast.setGravity(Gravity.CENTER, 0, 0);
        // 获取Toast提示消息里原有的View
        View view = toast.getView();
        // 创建一个ImageView
        ImageView imageView = new ImageView(context);
        // 为ImageView设置图片
        imageView.setImageResource(imgResId);
        // 创建一个ViewGroup容器
        LinearLayout ll = new LinearLayout(context);
        // 向LinearLayout中添加ImageView和Toast原有的View
        ll.addView(imageView);
        ll.addView(view);
        // 将LineLayout容器设置为toast的View
        toast.setView(ll);
        // 显示消息
        toast.show();
    }

    /**
     * 使用同1个toast,避免多toast重复问题
     *
     * @param context
     * @param text
     * @param duration
     * @return
     */
    public static Toast makeText(Context context, CharSequence text) {
        if (currentToast == null) {
            currentToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toastView = currentToast.getView();
        }
        if (toastView != null) {
            currentToast.setView(toastView);
            currentToast.setText(text);
            currentToast.setDuration(Toast.LENGTH_SHORT);
        }
        return currentToast;
    }
}
