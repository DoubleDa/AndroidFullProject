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

import com.apkfuns.logutils.LogUtils;
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
import cn.wochu.wh.adapter.SpOnShelvesAdapter;
import cn.wochu.wh.adapter.off.OffShelvesRvAdapter;
import cn.wochu.wh.adapter.on.OnShelvesRvAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.GetDCWarehouseOffGoodsInfo;
import cn.wochu.wh.entity.OnOffShelvesTypeEntity;
import cn.wochu.wh.entity.off.OffShelvesResultEntity;
import cn.wochu.wh.entity.off.OffShelvesRvEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.DividerItemDecoration;
import cn.wochu.wh.view.FullyLinearLayoutManager;
import cn.wochu.wh.view.WarehouseDialog;

/**
 * project name：Warehouse
 * class describe：商品下架*
 * create person：dayongxin
 * create time：16/6/13 下午1:38
 * alter person：dayongxin
 * alter time：16/6/13 下午1:38
 * alter remark：
 */
public class OrdersOffSaleAct extends BaseActivity implements AdapterView.OnItemSelectedListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.tv_scan_goods_code)
    TextView tvScanGoodsCode;
    @Bind(R.id.sp_obj)
    Spinner spObj;
    @Bind(R.id.rv_main_page)
    RecyclerView rvMainPage;
    @Bind(R.id.but_goods_offSale)
    Button butGoodsOffSale;
    private String mScanResult;
    private GetDCWarehouseOffGoodsInfo mGetDCWarehouseOffGoodsInfo;
    private List<OnOffShelvesTypeEntity> mOnOffShelvesTypeEntitys;

    private String handleType;


    private FullyLinearLayoutManager manager;
    private OffShelvesRvAdapter adapter;

    private List<OffShelvesRvEntity> mList = new ArrayList<OffShelvesRvEntity>();

    @Override
    protected void handleCode(String str) {
        if (CheckGoodsNumUtil.isWochuGoodsNum(str)) {
            if (mList.size() == 0) {
                handleGoodsCode(str);
            } else if (mList.size() > 0) {
                boolean contains = false;
                for (int i = 0; i < mList.size(); i++) {
                    if (str.contains(mList.get(i).getGoodsCode())) {
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
        setContentView(R.layout.act_orders_off_sale_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        getOffShelvesType();
    }

    private void getOffShelvesType() {
        OkHttpClientManager.getAsyn(ApiClient.GetLookUpItemList(Constants.GETLOOKUPITEMLISTTYPEOFF), new OkHttpClientManager.ResultCallback<BaseEntity<List<OnOffShelvesTypeEntity>>>() {

            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<List<OnOffShelvesTypeEntity>> response) {
                if (response.getRESULT().equals("1")) {
                    if (response.getDATA() != null) {
                        mOnOffShelvesTypeEntitys = response.getDATA();
                        SpOnShelvesAdapter adapter = new SpOnShelvesAdapter(mOnOffShelvesTypeEntitys, OrdersOffSaleAct.this);
                        spObj.setAdapter(adapter);
                        spObj.setOnItemSelectedListener(OrdersOffSaleAct.this);
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

    private void initView() {
        tvControl.setText(SharePreUtil.getString(OrdersOffSaleAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_goods_offSale));

        manager = new FullyLinearLayoutManager(this);
        rvMainPage.setLayoutManager(manager);
        rvMainPage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
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
            EditText et = (EditText) layout.findViewById(R.id.tv_off_goods_num);
            if (et.getText().toString().isEmpty() || et.getText().toString().equals("0")) {
                isNull = true;
                break;
            }
        }
        if (isNull) {
            ToastCheese("下架商品数量不能为0或空!");
        } else {
            String userCode = SharePreUtil.getString(OrdersOffSaleAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
            handleGoodsOff(userCode);
        }
    }


    private void handleGoodsOff(String userCode) {
        OkHttpClientManager.postAsyn(ApiClient.postDCOffShelves(userCode, handleType), new OkHttpClientManager.ResultCallback<OffShelvesResultEntity>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(OffShelvesResultEntity response) {
                if (response.getRESULT() != null) {
                    if (response.getRESULT().equals("1")) {
                        ToastCheese(getString(R.string.toast_offSale_success));
                        tvScanGoodsCode.setText("");
                        mList.clear();
                        adapter.notifyDataSetChanged();
                    } else {
                        ToastCheese(response.getMESSAGE());
                    }
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
        int warehouseId = SharePreUtil.getInteger(OrdersOffSaleAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        String opeName = SharePreUtil.getString(OrdersOffSaleAct.this, Constants.SP_ACCOUNT_LOGON_USERNAME, "sa");
        JSONArray array = new JSONArray();
        for (int i = 0; i < rvMainPage.getChildCount(); i++) {
            JSONObject object = new JSONObject();
            LinearLayout layout = (LinearLayout) rvMainPage.getChildAt(i);
            EditText et = (EditText) layout.findViewById(R.id.tv_off_goods_num);
            try {
                object.put("GoodsCode", mList.get(i).getGoodsCode());
                object.put("GoodsId", mList.get(i).getGoodsId());
                object.put("GoodsName", mList.get(i).getGoodsName());
                object.put("WarehouseId", warehouseId);
                object.put("ActualQty", et.getText().toString());
                object.put("OprNO", opeName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            array.put(object);
        }

        return array.toString();
    }

    private void handleGoodsCode(String mScanResult) {
        int WarehouseID = SharePreUtil.getInteger(OrdersOffSaleAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        OkHttpClientManager.getAsyn(ApiClient.getTransferOffShelvesInfo(mScanResult, WarehouseID), new OkHttpClientManager.ResultCallback<BaseEntity<GetDCWarehouseOffGoodsInfo>>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<GetDCWarehouseOffGoodsInfo> response) {
                if (response.getRESULT() != null) {
                    if (response.getRESULT().equals("1")) {
                        if (response.getDATA() != null) {
                            mGetDCWarehouseOffGoodsInfo = response.getDATA();
                            tvScanGoodsCode.setText(mGetDCWarehouseOffGoodsInfo.getGoodsCode());
                            mList.add(new OffShelvesRvEntity(mGetDCWarehouseOffGoodsInfo.getGoodsCode(), mGetDCWarehouseOffGoodsInfo.getGoodsName(), mGetDCWarehouseOffGoodsInfo.getGoodsID(), "1"));
                            adapter = new OffShelvesRvAdapter(OrdersOffSaleAct.this, mList);
                            rvMainPage.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                            adapter.setmOnMyItemClickLitener(new MainActAdapter.OnMyItemClickLitener() {
                                @Override
                                public void onMyItemClick(View view, final int position) {
                                    WarehouseDialog dialog = new WarehouseDialog(OrdersOffSaleAct.this, "确定要删除吗?", "取消", "确定", new WarehouseDialog.OnDialogButListener() {
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
        handleType = mOnOffShelvesTypeEntitys.get(position).getValue();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
