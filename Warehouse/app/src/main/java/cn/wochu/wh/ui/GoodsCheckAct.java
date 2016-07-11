package cn.wochu.wh.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.check.GoodsCheckActAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.check.GoodsCheckEntity;
import cn.wochu.wh.entity.check.GoodsCheckResultEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.FullyLinearLayoutManager;
import cn.wochu.wh.view.WarehouseDialog;

/**
 * project name：Warehouse
 * class describe：库存盘点*
 * create person：dayongxin
 * create time：16/6/14 上午10:34
 * alter person：dayongxin
 * alter time：16/6/14 上午10:34
 * alter remark：
 */
public class GoodsCheckAct extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.tv_scan_goods_code)
    TextView tvScanGoodsCode;
    @Bind(R.id.rv_main_page)
    RecyclerView rvMainPage;
    @Bind(R.id.but_goods_offSale)
    Button butGoodsOffSale;

    private FullyLinearLayoutManager manager;
    private List<GoodsCheckEntity> checkList = new ArrayList<>();
    private GoodsCheckActAdapter checkAdapter;

    @Override
    protected void handleCode(String str) {
        if (CheckGoodsNumUtil.isWochuGoodsNum(str)) {
            if (checkList.size() == 0) {
                handleScanGoodsCode(str);
            } else if (checkList.size() > 0) {
                boolean contains = false;
                for (int i = 0; i < checkList.size(); i++) {
                    if (str.contains(checkList.get(i).getGoodsCode())) {
                        contains = true;
                        break;
                    }
                }
                if (contains) {
                    ToastCheese("此商品已经添加成功!");
                } else {
                    handleScanGoodsCode(str);
                }
            }
        } else {
            ToastCheese(getString(R.string.toast_goods_num_not_null));
        }
    }

    private void handleScanGoodsCode(final String result) {
        int warehouseId = SharePreUtil.getInteger(this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        OkHttpClientManager.getAsyn(ApiClient.getWarehouseInfo(result, warehouseId), new OkHttpClientManager.ResultCallback<BaseEntity<GoodsCheckEntity>>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<GoodsCheckEntity> response) {
                if (response.getRESULT().equals("1")) {
                    GoodsCheckEntity goodsCheckEntity = response.getDATA();
                    tvScanGoodsCode.setText(goodsCheckEntity.getGoodsCode() + "");
                    checkList.add(new GoodsCheckEntity(goodsCheckEntity.getGoodsID(), goodsCheckEntity.getGoodsName(), goodsCheckEntity.getGoodsCode(), goodsCheckEntity.getActualQty(), goodsCheckEntity.getUsefulQty()));
                    checkAdapter = new GoodsCheckActAdapter(GoodsCheckAct.this, checkList);
                    rvMainPage.setAdapter(checkAdapter);
                    checkAdapter.notifyDataSetChanged();
                    checkAdapter.setmOnMyItemClickLitener(new GoodsCheckActAdapter.OnMyItemClickLitener() {
                        @Override
                        public void onMyItemClick(View view, final int position) {
                            WarehouseDialog dialog = new WarehouseDialog(GoodsCheckAct.this, "确定要删除吗?", "取消", "确定", new WarehouseDialog.OnDialogButListener() {
                                @Override
                                public void cancel() {

                                }

                                @Override
                                public void confirm() {
                                    ToastCheese("删除成功!");
                                    checkList.remove(position);
                                    checkAdapter.notifyDataSetChanged();
                                }
                            });
                            dialog.show();
                        }
                    });
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_goods_check_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvControl.setText(SharePreUtil.getString(GoodsCheckAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_goods_chaeck_search));

        manager = new FullyLinearLayoutManager(this);
        rvMainPage.setLayoutManager(manager);
    }


    @OnClick({R.id.iv_back, R.id.but_goods_offSale})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.but_goods_offSale:
                if (rvMainPage != null && rvMainPage.getChildCount() > 0) {
                    clickCommitBut();
                } else {
                    ToastCheese(getString(R.string.toast_but_click_goods_empty));
                }
                break;
        }
    }

    private void clickCommitBut() {
        boolean isNull = false;
        for (int i = 0; i < rvMainPage.getChildCount(); i++) {
            LinearLayout layout = (LinearLayout) rvMainPage.getChildAt(i);
            EditText et = (EditText) layout.findViewById(R.id.et_actual_warehouse);
            if (et.getText().toString().isEmpty()) {
                isNull = true;
                break;
            }
        }
        if (isNull) {
            ToastCheese("库存盘点数量不能为空!");
        } else {
            String userCode = SharePreUtil.getString(GoodsCheckAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
            uploadCheckWarehouseData(userCode);
        }
    }

    private void uploadCheckWarehouseData(String userCode) {
        LogUtils.i(postJsonFormat());
        OkHttpClientManager.postAsyn(ApiClient.postCheckWarehouseData(userCode), new OkHttpClientManager.ResultCallback<GoodsCheckResultEntity>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(GoodsCheckResultEntity response) {
                if (response.getRESULT().equals("1")) {
                    ToastCheese("库存盘点成功!");
                    tvScanGoodsCode.setText("");
                    checkList.clear();
                    checkAdapter.notifyDataSetChanged();
                } else {
                    ToastCheese(response.getMESSAGE());
                }
            }

            @Override
            public void onAfter() {
                super.onAfter();
                hideLoadingDialog();
            }
        }, postJsonFormat());
    }

    private String postJsonFormat() {
        int warehouseId = SharePreUtil.getInteger(GoodsCheckAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        String opeName = SharePreUtil.getString(GoodsCheckAct.this, Constants.SP_ACCOUNT_LOGON_USERNAME, "sa");
        JSONArray array = new JSONArray();
        for (int i = 0; i < rvMainPage.getChildCount(); i++) {
            JSONObject object = new JSONObject();
            LinearLayout layout = (LinearLayout) rvMainPage.getChildAt(i);
            EditText et = (EditText) layout.findViewById(R.id.et_actual_warehouse);
            try {
                object.put("GoodsID", checkList.get(i).getGoodsID());
                object.put("GoodsCode", checkList.get(i).getGoodsCode());
                object.put("GoodsName", checkList.get(i).getGoodsName());
                object.put("WarehouseID", warehouseId);
                object.put("ActualQty", et.getText().toString());
                object.put("OprNO", opeName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            array.put(object);
        }
        return array.toString();
    }
}
