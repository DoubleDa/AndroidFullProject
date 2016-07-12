package cn.wochu.wh.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Copyright 2016 DoubleDa
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
