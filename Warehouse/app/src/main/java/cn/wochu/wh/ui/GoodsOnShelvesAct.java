package cn.wochu.wh.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import java.util.Iterator;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.MainActAdapter;
import cn.wochu.wh.adapter.SpOnShelvesAdapter;
import cn.wochu.wh.adapter.on.OnShelvesRvAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.BaseEntity;
import cn.wochu.wh.entity.GetDCWarehouseGoodsInfoEntity;
import cn.wochu.wh.entity.OnOffShelvesTypeEntity;
import cn.wochu.wh.entity.SetDCOnShelvesEntity;
import cn.wochu.wh.entity.on.OnShelvesRvEntity;
import cn.wochu.wh.entity.on.OnShelvesUploadEntity;
import cn.wochu.wh.net.ApiClient;
import cn.wochu.wh.net.OkHttpClientManager;
import cn.wochu.wh.utils.CheckGoodsNumUtil;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.DividerItemDecoration;
import cn.wochu.wh.view.FullyLinearLayoutManager;
import cn.wochu.wh.view.WarehouseDialog;

/**
 * project name：Warehouse
 * class describe：商品上架*
 * create person：dayongxin
 * create time：16/6/15 下午1:53
 * alter person：dayongxin
 * alter time：16/6/15 下午1:53
 * alter remark：
 */
public class GoodsOnShelvesAct extends BaseActivity implements AdapterView.OnItemSelectedListener {
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
    private GetDCWarehouseGoodsInfoEntity mGetDCWarehouseGoodsInfoEntity;
    private String handleType;

    private List<OnOffShelvesTypeEntity> mOnOffShelvesTypeEntitys;
    private FullyLinearLayoutManager manager;

    private OnShelvesRvAdapter mOnShelvesRvAdapter;

    private List<OnShelvesRvEntity> mList = new ArrayList<OnShelvesRvEntity>();

    private List<OnShelvesUploadEntity> mUploadList = new ArrayList<>();

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

    private void handleGoodsCode(final String mGoodsCode) {
        OkHttpClientManager.getAsyn(ApiClient.getDCOnWarehouseGoodsInfo(mGoodsCode), new OkHttpClientManager.ResultCallback<BaseEntity<GetDCWarehouseGoodsInfoEntity>>() {

            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(BaseEntity<GetDCWarehouseGoodsInfoEntity> response) {
                if (response.getRESULT().equals("1")) {
                    if (response.getDATA() != null) {
                        mGetDCWarehouseGoodsInfoEntity = response.getDATA();
                        tvScanGoodsCode.setText(mGetDCWarehouseGoodsInfoEntity.getGOODSCODE());
                        OnShelvesRvEntity onShelvesRvEntity = new OnShelvesRvEntity(mGetDCWarehouseGoodsInfoEntity.getGOODSID(), mGetDCWarehouseGoodsInfoEntity.getGOODSNAME(), mGetDCWarehouseGoodsInfoEntity.getGOODSCODE(), "1", mGetDCWarehouseGoodsInfoEntity.getUNITNAME());
                        mList.add(onShelvesRvEntity);
                        mOnShelvesRvAdapter = new OnShelvesRvAdapter(GoodsOnShelvesAct.this, mList);
                        rvMainPage.setAdapter(mOnShelvesRvAdapter);
                        mOnShelvesRvAdapter.notifyDataSetChanged();
                        mOnShelvesRvAdapter.setmOnMyItemClickLitener(new MainActAdapter.OnMyItemClickLitener() {
                            @Override
                            public void onMyItemClick(View view, final int position) {
                                WarehouseDialog dialog = new WarehouseDialog(GoodsOnShelvesAct.this, "确定要删除吗?", "取消", "确定", new WarehouseDialog.OnDialogButListener() {
                                    @Override
                                    public void cancel() {

                                    }

                                    @Override
                                    public void confirm() {
                                        ToastCheese("删除成功!");
                                        mList.remove(position);
                                        mOnShelvesRvAdapter.notifyDataSetChanged();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_goods_on_shelves_layout);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        tvControl.setText(SharePreUtil.getString(GoodsOnShelvesAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_onhelves));

        manager = new FullyLinearLayoutManager(this);
        rvMainPage.setLayoutManager(manager);
        rvMainPage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void initData() {
        getOnShelvesType();
    }

    private void getOnShelvesType() {
        OkHttpClientManager.getAsyn(ApiClient.GetLookUpItemList(Constants.GETLOOKUPITEMLISTTYPEON), new OkHttpClientManager.ResultCallback<BaseEntity<List<OnOffShelvesTypeEntity>>>() {

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
                        SpOnShelvesAdapter adapter = new SpOnShelvesAdapter(mOnOffShelvesTypeEntitys, GoodsOnShelvesAct.this);
                        spObj.setAdapter(adapter);
                        spObj.setOnItemSelectedListener(GoodsOnShelvesAct.this);
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


    private void goodsOnShelves(String userCode) {
        OkHttpClientManager.postAsyn(ApiClient.postDCOnShelves(userCode, handleType), new OkHttpClientManager.ResultCallback<SetDCOnShelvesEntity>() {
            @Override
            public void onBefore(Request request) {
                super.onBefore(request);
                showLoadingDialog("");
            }

            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(SetDCOnShelvesEntity response) {
                if ("1".equals(response.getRESULT())) {
                    ToastCheese("商品上架成功!");
                    /**
                     * 成功之后清除数据
                     */
                    tvScanGoodsCode.setText("");
                    mList.clear();
                    mOnShelvesRvAdapter.notifyDataSetChanged();
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        handleType = mOnOffShelvesTypeEntitys.get(position).getValue();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private String postJsonFormat() {
        int warehouseId = SharePreUtil.getInteger(GoodsOnShelvesAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSEID, 7);
        String opeName = SharePreUtil.getString(GoodsOnShelvesAct.this, Constants.SP_ACCOUNT_LOGON_USERNAME, "sa");


        JSONArray array = new JSONArray();
        for (int i = 0; i < rvMainPage.getChildCount(); i++) {
            JSONObject object = new JSONObject();
            LinearLayout layout = (LinearLayout) rvMainPage.getChildAt(i);
            EditText et = (EditText) layout.findViewById(R.id.et_goods_num);
            try {
                object.put("ACTUALQTY", et.getText().toString());
                object.put("GOODSCODE", mList.get(i).getGoodsCode());
                object.put("OPRNO", opeName);
                object.put("GOODSID", mList.get(i).getGoodsId());
                object.put("WAREHOUSEID", warehouseId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            array.put(object);
        }
        return array.toString();
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
            EditText et = (EditText) layout.findViewById(R.id.et_goods_num);
            if (et.getText().toString().isEmpty() || et.getText().toString().equals("0")) {
                isNull = true;
                break;
            }
        }
        if (isNull) {
            ToastCheese("上架商品数量不能为0或空!");
        } else {
            String userCode = SharePreUtil.getString(GoodsOnShelvesAct.this, Constants.SP_ACCOUNT_LOGON_USERCODE, "");
            goodsOnShelves(userCode);
        }
    }
}
