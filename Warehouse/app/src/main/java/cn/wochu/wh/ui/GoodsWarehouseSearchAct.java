package cn.wochu.wh.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.search.GoodsWarehouseSearchAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.GetDCWarehouseGoodsInfo2WhSearch;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.DividerItemDecoration;
import cn.wochu.wh.view.FullyLinearLayoutManager;

/**
 * project name：Warehouse
 * class describe：库存查询*
 * create person：dayongxin
 * create time：16/6/14 上午10:38
 * alter person：dayongxin
 * alter time：16/6/14 上午10:38
 * alter remark：
 */
public class GoodsWarehouseSearchAct extends BaseActivity {


    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.rv_main_page)
    RecyclerView rvMainPage;

    private String mGoodsCode;

    private FullyLinearLayoutManager manager;
    private GoodsWarehouseSearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_goods_warehouse_search_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvControl.setText(SharePreUtil.getString(GoodsWarehouseSearchAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_warehouse_search));

        manager = new FullyLinearLayoutManager(this);
        rvMainPage.setLayoutManager(manager);
        rvMainPage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void handleCode(String str) {
        if (CheckGoodsNumUtil.isWochuGoodsNum(str)) {
            mGoodsCode = str;
            handleGoodsCode(str);
        } else {
            ToastCheese(getString(R.string.toast_goods_num_not_null));
        }
    }

    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    private void handleGoodsCode(String mGoodsCode) {
        int warehouseId = SharePreUtil.getInteger(this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        OkHttpClientManager.getAsyn(ApiClient.getWarehouseInfo(mGoodsCode, warehouseId), new OkHttpClientManager.ResultCallback<BaseEntity<GetDCWarehouseGoodsInfo2WhSearch>>() {
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
                    List<GetDCWarehouseGoodsInfo2WhSearch> list = new ArrayList<GetDCWarehouseGoodsInfo2WhSearch>();
                    list.add(new GetDCWarehouseGoodsInfo2WhSearch(response.getDATA().getGoodsName(), response.getDATA().getGoodsCode(), response.getDATA().getActualQty(), response.getDATA().getUsefulQty()));
                    adapter = new GoodsWarehouseSearchAdapter(GoodsWarehouseSearchAct.this, list);
                    rvMainPage.setAdapter(adapter);
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
}
