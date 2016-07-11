package cn.wochu.wh.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.squareup.okhttp.Request;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.AccountLogOnEntity;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.utils.VersionUtils;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午4:57
 * alter person：dayongxin
 * alter time：16/6/12 下午4:57
 * alter remark：
 */
public class LoginAct extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.but_login)
    Button butLogin;
    @Bind(R.id.tv_version)
    TextView tvVersion;
    @Bind(R.id.tv_copyright)
    TextView tvCopyright;
    @Bind(R.id.tv_wochu)
    TextView tvWochu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login_login_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ivBack.setVisibility(View.INVISIBLE);
        tvControl.setVisibility(View.INVISIBLE);
        tvTitle.setText(getString(R.string.tv_title_login));
        tvVersion.setText("当前版本: " + VersionUtils.getVersionName(this));
    }

    @Override
    protected void handleCode(String str) {
        ToastCheese(str);
    }


    @OnClick({R.id.iv_back, R.id.tv_control, R.id.but_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_login:
                if (baseHasNet()) {
                    handleUserLogin();
                }
                break;
        }
    }

    private void handleUserLogin() {
        String userName = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
            OkHttpClientManager.getAsyn(ApiClient.getAccountLogOn(userName, password), new OkHttpClientManager.ResultCallback<BaseEntity<AccountLogOnEntity>>() {
                @Override
                public void onBefore(Request request) {
                    super.onBefore(request);
                    showLoadingDialog(getString(R.string.toast_data_loading));
                }

                @Override
                public void onError(Request request, Exception e) {

                }

                @Override
                public void onResponse(BaseEntity<AccountLogOnEntity> response) {
                    if (response.getRESULT() != null && response.getDATA() != null) {
                        if (response.getRESULT().equals("1")) {
                            if (response.getDATA().getWAREHOUSECODE() != null) {
                                ToastCheese(getString(R.string.toast_login_success));
                                SharePreUtil.putInteger(LoginAct.this, Constants.SP_ACCOUNT_LOGON_USERID, response.getDATA().getUSERID());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, response.getDATA().getUSERCODE());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_PASSWORD, response.getDATA().getPASSWORD());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_USERNAME, response.getDATA().getUSERNAME());
                                SharePreUtil.putInteger(LoginAct.this, Constants.SP_ACCOUNT_LOGON_ENTITYSTATE, response.getDATA().getEntityState());
                                SharePreUtil.putBoolean(LoginAct.this, Constants.SP_ACCOUNT_LOGON_SELECTED, response.getDATA().isSelected());
                                SharePreUtil.putInteger(LoginAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, response.getDATA().getWAREHOUSEID());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSECODE, response.getDATA().getWAREHOUSECODE());
                                SharePreUtil.putString(LoginAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, response.getDATA().getWAREHOUSENAME());
                                intentTo(LoginAct.this, MainPageAct.class);
                                finish();
                            } else {
                                ToastCheese("无权限登录!");
                            }
                        }
                    } else {
                        ToastCheese(response.getMESSAGE());
                    }
                }

                @Override
                public void onAfter() {
                    super.onAfter();
                    hideLoadingDialog();
                }
            });
        } else {
            ToastCheese(getString(R.string.toast_username_password_error));
        }
    }
}
