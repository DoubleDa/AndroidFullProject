package cn.wochu.wh.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.MainActAdapter;
import cn.wochu.wh.adapter.SpAdapter;
import cn.wochu.wh.adapter.troff.TransferOffShelvesRvAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.GetDCWarehouseGoodsInfo2WhSearch;
import cn.wochu.wh.entity.GetWarehouseListEntity;
import cn.wochu.wh.entity.troff.TransferOffShelvesEntity;
import cn.wochu.wh.entity.troff.TransferOffShelvesResultEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.utils.StringUtils;
import cn.wochu.wh.view.DividerItemDecoration;
import cn.wochu.wh.view.FullyLinearLayoutManager;
import cn.wochu.wh.view.WarehouseDialog;

/**
 * project name：Warehouse
 * class describe：转仓下架*
 * create person：dayongxin
 * create time：16/6/14 上午10:33
 * alter person：dayongxin
 * alter time：16/6/14 上午10:33
 * alter remark：
 */
public class GoodsTransferWarehouseAct extends BaseActivity implements AdapterView.OnItemSelectedListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.tv_show_current_warehouse)
    TextView tvShowCurrentWarehouse;
    @Bind(R.id.sp_obj)
    Spinner spObj;
    @Bind(R.id.rv_main_page)
    RecyclerView rvMainPage;
    @Bind(R.id.but_confirm_transfer)
    Button butConfirmTransfer;

    private int mToWarehouseID;

    private List<GetWarehouseListEntity> getWarehouseListEntitys = new ArrayList<>();

    private GetDCWarehouseGoodsInfo2WhSearch mGetDCWarehouseGoodsInfo2WhSearch;
    private FullyLinearLayoutManager manager;

    private List<TransferOffShelvesEntity> mList = new ArrayList<>();
    private TransferOffShelvesRvAdapter adapter;


    @Override
    protected void handleCode(String str) {
        if (CheckGoodsNumUtil.isWochuGoodsNum(str)) {
            if (mList.size() == 0) {
                handleGoodsCode(str);
            } else if (mList.size() > 0) {
                boolean contains = false;
                for (int i = 0; i < mList.size(); i++) {
                    if (str.contentEquals(mList.get(i).getGoodsCode())) {
                        contains = true;
                        break;
                    }
                }
                if (contains) {
                    ToastCheese("此商品已经添加成功!");
                } else {
                    handleGoodsCode(str);
                }
            }
        } else {
            ToastCheese(getString(R.string.toast_goods_num_not_null));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_goods_transfer_warehouse_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvControl.setText(SharePreUtil.getString(GoodsTransferWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvShowCurrentWarehouse.setText(SharePreUtil.getString(GoodsTransferWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_transfer));
        uploadWarehouseInfo();

        manager = new FullyLinearLayoutManager(this);
        rvMainPage.setLayoutManager(manager);
        rvMainPage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void uploadWarehouseInfo() {
        OkHttpClientManager.getAsyn(ApiClient.getDCWarehouseInfo(), new OkHttpClientManager.ResultCallback<BaseEntity<List<GetWarehouseListEntity>>>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<List<GetWarehouseListEntity>> response) {
                if (response.getRESULT().equals("1")) {
                    if (response.getDATA() != null && response.getDATA().size() > 0) {
                        List<GetWarehouseListEntity> tempList = response.getDATA();
                        for (int i = 0; i < tempList.size(); i++) {
                            if (tempList.get(i).getWAREHOUSENAME().equals(SharePreUtil.getString(GoodsTransferWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""))) {
                                tempList.remove(i);
                                i--;
                            }
                        }
                        getWarehouseListEntitys.addAll(tempList);
                        SpAdapter adapter = new SpAdapter(getWarehouseListEntitys, GoodsTransferWarehouseAct.this);
                        spObj.setAdapter(adapter);
                        spObj.setOnItemSelectedListener(GoodsTransferWarehouseAct.this);
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
    }

    @OnClick({R.id.iv_back, R.id.but_confirm_transfer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.but_confirm_transfer:
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
            EditText et = (EditText) layout.findViewById(R.id.tv_off_goods_num);
            if (et.getText().toString().isEmpty() || et.getText().toString().equals("0")) {
                isNull = true;
                break;
            }
        }
        if (isNull) {
            ToastCheese("下架商品数量不能为空!");
        } else {
            String userCode = SharePreUtil.getString(GoodsTransferWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
            int fromId = SharePreUtil.getInteger(GoodsTransferWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
            uploadTransferInfo(userCode, fromId, mToWarehouseID);
        }
    }

    private void uploadTransferInfo(String userCode, int fromId, int toId) {
        OkHttpClientManager.postAsyn(ApiClient.postDCTransOffShelves(userCode, fromId, toId), new OkHttpClientManager.ResultCallback<TransferOffShelvesResultEntity>() {

            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(TransferOffShelvesResultEntity response) {
                if (response.getRESULT().equals("1")) {
                    ToastCheese(response.getMESSAGE());
                    mList.clear();
                    adapter.notifyDataSetChanged();
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


    private void handleGoodsCode(String mGoodsCode) {
        int WarehouseID = SharePreUtil.getInteger(GoodsTransferWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        OkHttpClientManager.getAsyn(ApiClient.getTransferOffShelvesInfo(mGoodsCode, WarehouseID), new OkHttpClientManager.ResultCallback<BaseEntity<GetDCWarehouseGoodsInfo2WhSearch>>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<GetDCWarehouseGoodsInfo2WhSearch> response) {
                if (response.getRESULT().equals("1")) {
                    if (response.getDATA() != null) {
                        mGetDCWarehouseGoodsInfo2WhSearch = response.getDATA();
                        mList.add(new TransferOffShelvesEntity(mGetDCWarehouseGoodsInfo2WhSearch.getGoodsCode(), mGetDCWarehouseGoodsInfo2WhSearch.getGoodsName(), mGetDCWarehouseGoodsInfo2WhSearch.getActualQty(), "1"));
                        adapter = new TransferOffShelvesRvAdapter(GoodsTransferWarehouseAct.this, mList);
                        rvMainPage.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        adapter.setmOnMyItemClickLitener(new MainActAdapter.OnMyItemClickLitener() {
                            @Override
                            public void onMyItemClick(View view, final int position) {
                                WarehouseDialog dialog = new WarehouseDialog(GoodsTransferWarehouseAct.this, "确定要删除吗?", "取消", "确定", new WarehouseDialog.OnDialogButListener() {
                                    @Override
                                    public void cancel() {

                                    }

                                    @Override
                                    public void confirm() {
                                        ToastCheese("删除成功!");
                                        mList.remove(position);
                                        adapter.notifyDataSetChanged();
                                    }
                                });
                                dialog.show();
                            }
                        });
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
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mToWarehouseID = getWarehouseListEntitys.get(position).getWAREHOUSEID();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String postJsonFormat() {
        JSONArray array = new JSONArray();
        for (int i = 0; i < rvMainPage.getChildCount(); i++) {
            JSONObject object = new JSONObject();
            LinearLayout layout = (LinearLayout) rvMainPage.getChildAt(i);
            EditText et = (EditText) layout.findViewById(R.id.tv_off_goods_num);
            try {
                object.put("Key", mList.get(i).getGoodsCode());
                object.put("Value", et.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            array.put(object);
        }
        return array.toString();
    }
}
