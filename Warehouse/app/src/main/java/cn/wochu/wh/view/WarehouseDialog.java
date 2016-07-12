package cn.wochu.wh.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cn.wochu.wh.R;

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
public class WarehouseDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private String title;
    private String cancel;
    private String confirm;
    private OnDialogButListener onDialogButListener;

    private TextView mTv_dialog_title;
    private Button mBut_dialog_cancel;
    private Button mBut_dialog_confirm;

    public WarehouseDialog(Context context, String title, String cancel, String confirm, OnDialogButListener onDialogButListener) {
        super(context, R.style.WochuDialog);
        this.mContext = context;
        this.title = title;
        this.cancel = cancel;
        this.confirm = confirm;
        this.onDialogButListener = onDialogButListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_dialog_cancel:
                onDialogButListener.cancel();
                dismiss();
                break;
            case R.id.but_dialog_confirm:
                onDialogButListener.confirm();
                dismiss();
                break;
        }
    }

    public interface OnDialogButListener {
        public void cancel();

        public void confirm();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_dialog_layout);
        setCancelable(false);
        initView();
        initData();
    }

    private void initData() {
        mTv_dialog_title.setText(title);
        mBut_dialog_cancel.setText(cancel);
        mBut_dialog_confirm.setText(confirm);
        mBut_dialog_cancel.setOnClickListener(this);
        mBut_dialog_confirm.setOnClickListener(this);
    }

    private void initView() {
        mTv_dialog_title = (TextView) findViewById(R.id.tv_dialog_title);
        mBut_dialog_cancel = (Button) findViewById(R.id.but_dialog_cancel);
        mBut_dialog_confirm = (Button) findViewById(R.id.but_dialog_confirm);
    }
}
