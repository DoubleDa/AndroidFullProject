package cn.wochu.wh.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
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
import cn.wochu.wh.adapter.thrid.ThridOrderSearchAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.off.OffShelvesResultEntity;
import cn.wochu.wh.entity.search.DCJDORDERDETAILItem;
import cn.wochu.wh.entity.search.ThridOrderSearchEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.FullyLinearLayoutManager;

/**
 * project name：Warehouse
 * class describe：第三方订单查询*
 * create person：dayongxin
 * create time：16/6/14 下午4:49
 * alter person：dayongxin
 * alter time：16/6/14 下午4:49
 * alter remark：
 */
public class ThridOrderSearchAct extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.rv_main_page)
    RecyclerView rvMainPage;
    @Bind(R.id.tv_order_num)
    TextView tvOrderNum;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.but_goods_offSale)
    Button butGoodsOffSale;
    @Bind(R.id.tv_order_state)
    TextView tvOrderState;
    private FullyLinearLayoutManager manager;
    private ThridOrderSearchAdapter adapter;
    private List<ThridOrderSearchEntity.DCJDORDERDETAILItemEntity> list;
    private String orderNo;
    /**
     * 商品条码状态
     */
    private SparseBooleanArray booleanArray = new SparseBooleanArray();


    /**
     * 订单三种状态
     */
    //可下架-->0  已下架-->1  已取消-->2
    private int ORDER_STATE = -1;

    /**
     * @param str
     */

    @Override
    protected void handleCode(String str) {
        if (CheckGoodsNumUtil.isWochuGoodsNum(str)) {
            /**
             * 商品编码
             */
            if (orderNo != null && !orderNo.isEmpty()) {
                if (ORDER_STATE == 0) {
                    handleGoodsCode(str);
                } else if (ORDER_STATE == 1) {
                    ToastCheese(getString(R.string.toast_order_has_off_shelf));
                } else if (ORDER_STATE == 2) {
                    ToastCheese(getString(R.string.toast_order_has_cancel_shelf));
                }
            } else {
                ToastCheese(getString(R.string.toast_please_scan_goodscode_before));
            }
        } else {
            /**
             * 订单编码
             */
            handleOrderNo(str);
            booleanArray.clear();
            butGoodsOffSale.setEnabled(false);
        }
    }

    private void handleGoodsCode(String str) {
        if (getGoodsCodeListIndex(str) != -1) {
            LinearLayout layout = (LinearLayout) rvMainPage.getChildAt(getGoodsCodeListIndex(str));

            TextView goodsCodeTv = (TextView) layout.findViewById(R.id.tv_goods_code);
            TextView goodsName = (TextView) layout.findViewById(R.id.tv_goods_name);
            TextView goodsNum = (TextView) layout.findViewById(R.id.tv_goods_num);

            goodsCodeTv.setTextColor(Color.parseColor("#008B00"));
            goodsName.setTextColor(Color.parseColor("#008B00"));
            goodsNum.setTextColor(Color.parseColor("#008B00"));


            booleanArray.put(getGoodsCodeListIndex(str), true);
            if (booleanArray.size() == rvMainPage.getChildCount() && ORDER_STATE == 0) {
                butGoodsOffSale.setEnabled(true);
            }
        } else {
            ToastCheese(getString(R.string.data_error));
        }
    }


    /**
     * 获取元素在List中的索引
     *
     * @param str
     * @return
     */
    private int getGoodsCodeListIndex(String str) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (str.contains(list.get(i).getGOODSCODE())) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void handleOrderNo(String orderNum) {
        OkHttpClientManager.getAsyn(ApiClient.getDCJDOrderInfo(orderNum), new OkHttpClientManager.ResultCallback<BaseEntity<ThridOrderSearchEntity>>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {
                LogUtils.i(e.toString());
            }

            @Override
            public void onResponse(BaseEntity<ThridOrderSearchEntity> response) {
                if (response.getRESULT().equals("1")) {
                    tvOrderNum.setText(response.getDATA().getORDERCODE() + "");
                    if (response.getDATA().getSTATUS().equals(Constants.ORDER_STATE_UNABLE)) {
                        //已下架
                        tvOrderState.setText("已下架");
                        ORDER_STATE = 1;
                    } else if (response.getDATA().getSTATUS().equals(Constants.ORDER_STATE_ENABLE)) {
                        //可下架
                        tvOrderState.setText("可下架");
                        ORDER_STATE = 0;
                    } else if (response.getDATA().getSTATUS().equals(Constants.ORDER_STATE_CANCELED)) {
                        //已取消
                        tvOrderState.setText("已取消");
                        ORDER_STATE = 2;
                    }
                    orderNo = response.getDATA().getORDERCODE();
                    list = response.getDATA().getDCJDORDERDETAILItem();
                    adapter = new ThridOrderSearchAdapter(ThridOrderSearchAct.this, list);
                    rvMainPage.setAdapter(adapter);
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
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_thrid_order_search_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        tvControl.setText(SharePreUtil.getString(ThridOrderSearchAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_thrid_search));

        manager = new FullyLinearLayoutManager(this);
        rvMainPage.setLayoutManager(manager);
        butGoodsOffSale.setEnabled(false);
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
                    ToastCheese(getString(R.string.toast_but_click_order_empty));
                }
                break;
        }
    }

    private void clickCommitBut() {
        String userCode = SharePreUtil.getString(ThridOrderSearchAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
        handleGoodsOff(userCode, "京东到家下架");
    }


    private void handleGoodsOff(String userCode, String handleType) {
        OkHttpClientManager.postAsyn(ApiClient.setJDOffShelves(orderNo, userCode, handleType), new OkHttpClientManager.ResultCallback<OffShelvesResultEntity>() {
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
                        ToastCheese("第三方订单下架成功!");
                        tvOrderState.setText("");
                        tvOrderNum.setText("");
                        list.clear();
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
        int warehouseId = SharePreUtil.getInteger(ThridOrderSearchAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        String opeName = SharePreUtil.getString(ThridOrderSearchAct.this, Constants.SP_ACCOUNT_LOGON_USERNAME, "sa");
        JSONArray array = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            JSONObject object = new JSONObject();
            try {
                object.put("GoodsCode", list.get(i).getGOODSCODE());
                object.put("GoodsName", list.get(i).getGOODSNAME());
                object.put("WarehouseId", warehouseId);
                object.put("ActualQty", list.get(i).getGOODSNUMBER());
                object.put("OprNO", opeName);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            array.put(object);
        }
        return array.toString();
    }
}
