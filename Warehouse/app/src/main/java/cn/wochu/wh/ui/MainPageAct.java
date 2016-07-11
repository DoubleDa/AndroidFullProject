package cn.wochu.wh.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.wochu.wh.R;
import cn.wochu.wh.adapter.MainActAdapter;
import cn.wochu.wh.base.BaseActivity;
import cn.wochu.wh.constant.Constants;
import cn.wochu.wh.entity.MainPageTitleEntity;
import cn.wochu.wh.utils.SharePreUtil;
import cn.wochu.wh.view.DividerItemDecoration;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午4:59
 * alter person：dayongxin
 * alter time：16/6/12 下午4:59
 * alter remark：
 */
public class MainPageAct extends BaseActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_control)
    TextView tvControl;
    @Bind(R.id.rv_main_page)
    RecyclerView rvMainPage;

    private MainActAdapter mMainActAdapter;
    private List<MainPageTitleEntity> mList;
    private String[] itemName = {"上架", "下架", "转仓上架", "转仓下架", "库存盘点", "库存查询", "第三方订单下架"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        mList = new ArrayList<MainPageTitleEntity>();
        mList.add(new MainPageTitleEntity(itemName[0]));
        mList.add(new MainPageTitleEntity(itemName[1]));
        mList.add(new MainPageTitleEntity(itemName[2]));
        mList.add(new MainPageTitleEntity(itemName[3]));
        mList.add(new MainPageTitleEntity(itemName[4]));
        mList.add(new MainPageTitleEntity(itemName[5]));
        mList.add(new MainPageTitleEntity(itemName[6]));
        mMainActAdapter = new MainActAdapter(this, mList);
        rvMainPage.setAdapter(mMainActAdapter);
        mMainActAdapter.setmOnMyItemClickLitener(new MainActAdapter.OnMyItemClickLitener() {
            @Override
            public void onMyItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        //上架
                        intentTo(MainPageAct.this, GoodsOnShelvesAct.class);
                        break;
                    case 1:
                        //下架
                        intentTo(MainPageAct.this, OrdersOffSaleAct.class);
                        break;
                    case 2:
                        //转仓上架
                        intentTo(MainPageAct.this, GoodsTransferOnWarehouseAct.class);
                        break;
                    case 3:
                        //转仓下架
                        intentTo(MainPageAct.this, GoodsTransferWarehouseAct.class);
                        break;
                    case 4:
                        //库存盘点
                        intentTo(MainPageAct.this, GoodsCheckAct.class);
                        break;
                    case 5:
                        // 库存查询
                        intentTo(MainPageAct.this, GoodsWarehouseSearchAct.class);
                        break;
                    case 6:
                        //第三方订单下架
                        intentTo(MainPageAct.this, ThridOrderSearchAct.class);
                        break;
                    default:
                        break;

                }
            }
        });
    }

    private void initView() {
        ivBack.setVisibility(View.INVISIBLE);
        tvControl.setText(SharePreUtil.getString(MainPageAct.this, Constants.SP_ACCOUNT_LOGON_WAREHOUSENAME, ""));
        tvTitle.setText(getString(R.string.tv_title_main_page));
        rvMainPage.setLayoutManager(new LinearLayoutManager(this));
        rvMainPage.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void handleCode(String str) {

    }


    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
        }
    }
}
