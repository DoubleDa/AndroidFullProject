package cn.wochu.wh.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.okhttp.Request;

import org.json.JSONArray;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.GoodsOnShelvesRvAdapter;
import cn.wochu.wh.adapter.SpStringAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.GetDCInventoryMoveCodeEntity;
import cn.wochu.wh.entity.GetDCTransOnShelvesEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.DividerItemDecoration;
import cn.wochu.wh.view.FullyLinearLayoutManager;

/**
 * project name：Warehouse
 * class describe：转仓上架*
 * create person：dayongxin
 * create time：16/6/14 下午4:03
 * alter person：dayongxin
 * alter time：16/6/14 下午4:03
 * alter remark：
 */
public class GoodsTransferOnWarehouseAct extends BaseActivity implements AdapterView.OnItemSelectedListener {
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.but_confirm_transfer)
    Button butConfirmTransfer;
    @Bind(R.id.sp_current)
    Spinner spCurrent;
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    private GoodsOnShelvesRvAdapter mGoodsOnShelvesRvAdapter;
    private List<GetDCTransOnShelvesEntity> mList;


    private List<String> moveCodeList;


    private FullyLinearLayoutManager manager;

    private SparseBooleanArray booleanArray = new SparseBooleanArray();

    private String mMoveCode;

    @Override
    protected void handleCode(String str) {
        if (CheckGoodsNumUtil.isWochuGoodsNum(str)) {
            handleMoveCode(str);
        } else {
            ToastCheese(getString(R.string.toast_goods_num_not_null));
        }
    }

    private void handleMoveCode(String str) {
        OkHttpClientManager.getAsyn(ApiClient.getDCTransOnShelvesMoveCode(str), new OkHttpClientManager.ResultCallback<BaseEntity<List<GetDCTransOnShelvesEntity>>>() {

            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<List<GetDCTransOnShelvesEntity>> response) {
                if (response.getRESULT().equals("1")) {
                    if (response.getDATA() != null && response.getDATA().size() > 0) {
                        mList = response.getDATA();
                        mGoodsOnShelvesRvAdapter = new GoodsOnShelvesRvAdapter(GoodsTransferOnWarehouseAct.this, mList);
                        recyclerView.setAdapter(mGoodsOnShelvesRvAdapter);
                        mGoodsOnShelvesRvAdapter.setmOnSelectedItemListener(new GoodsOnShelvesRvAdapter.OnSelectedItemListener() {
                            @Override
                            public void onItemSelectedResult(int index, boolean isSelected) {
                                if (isSelected) {
                                    booleanArray.put(index, true);
                                } else {
                                    booleanArray.put(index, false);
                                }
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_goods_transfer_on_warehouse_layout);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvControl.setText(SharePreUtil.getString(GoodsTransferOnWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_transfer_on));

        manager = new FullyLinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        String warehouseCode = SharePreUtil.getString(GoodsTransferOnWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSECODE, "");
        handleTargetWarehouseCode(warehouseCode);
    }


    @OnClick({R.id.iv_back, R.id.but_confirm_transfer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.but_confirm_transfer:
                if (booleanArray != null && booleanArray.size() > 0) {
                    if (recyclerView != null && recyclerView.getChildCount() > 0) {
                        clickCommitBut();
                    } else {
                        ToastCheese(getString(R.string.toast_but_click_goods_selected));
                    }
                } else {
                    ToastCheese(getString(R.string.toast_but_click_goods_selected));
                }
                break;
        }
    }

    private void clickCommitBut() {
        String userCode = SharePreUtil.getString(GoodsTransferOnWarehouseAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
        if (mList.size() > 0) {
            uploadTransferOnShelves(userCode);
        } else {
            ToastCheese("请选择下架商品!");
        }
    }

    private void uploadTransferOnShelves(String userCode) {
        OkHttpClientManager.postAsyn(ApiClient.postDCTransOnShelves(userCode, mMoveCode), new OkHttpClientManager.ResultCallback<BaseEntity<String>>() {

            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<String> response) {
                if (response.getRESULT().equals("1")) {
                    ToastCheese(getString(R.string.but_confirm_transfer_on_goods_success));
                    mList.clear();
                    mGoodsOnShelvesRvAdapter.notifyDataSetChanged();
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
        JSONArray array = new JSONArray();
        for (int i = 0; i < mList.size(); i++) {
            if (booleanArray.get(i)) {
                array.put(mList.get(i).getGOODSCODE());
            }
        }
        return array.toString();
    }

    private void handleTargetWarehouseCode(String mTargetWarehouseCode) {
        OkHttpClientManager.getAsyn(ApiClient.GetDCInventoryMoveCode(mTargetWarehouseCode), new OkHttpClientManager.ResultCallback<GetDCInventoryMoveCodeEntity>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(GetDCInventoryMoveCodeEntity response) {
                if (response.getRESULT().equals("1")) {
                    moveCodeList = response.getDATA();
                    SpStringAdapter adapter = new SpStringAdapter(moveCodeList, GoodsTransferOnWarehouseAct.this);
                    spCurrent.setAdapter(adapter);
                    spCurrent.setOnItemSelectedListener(GoodsTransferOnWarehouseAct.this);
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
        mMoveCode = moveCodeList.get(position);
        handleMoveCode(mMoveCode);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
