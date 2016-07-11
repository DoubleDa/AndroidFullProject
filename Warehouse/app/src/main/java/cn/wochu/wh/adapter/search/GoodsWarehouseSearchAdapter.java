package cn.wochu.wh.adapter.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.GetDCWarehouseGoodsInfo2WhSearch;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/20 上午11:45
 * alter person：dayongxin
 * alter time：16/6/20 上午11:45
 * alter remark：
 */
public class GoodsWarehouseSearchAdapter extends RecyclerView.Adapter<GoodsWarehouseSearchAdapter.GoodsWarehouseSearchViewHolder> {
    private Context m;
    private List<GetDCWarehouseGoodsInfo2WhSearch> mList;
    private LayoutInflater mLayoutInflater;

    public GoodsWarehouseSearchAdapter(Context m, List<GetDCWarehouseGoodsInfo2WhSearch> mList) {
        this.m = m;
        this.mList = mList;
        this.mLayoutInflater = mLayoutInflater.from(m);
    }

    @Override
    public GoodsWarehouseSearchViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GoodsWarehouseSearchViewHolder(mLayoutInflater.inflate(R.layout.rv_item_stock_search_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(GoodsWarehouseSearchViewHolder holder, int i) {
        holder.mTv_goods_num_result.setText(mList.get(i).getGoodsName() + "");
        holder.mTv_goods_code_result.setText(mList.get(i).getGoodsCode() + "");
        holder.mTv_actual_qty_result.setText(mList.get(i).getActualQty() + "");
        holder.mTv_useful_qty_result.setText(mList.get(i).getUsefulQty() + "");
    }


    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class GoodsWarehouseSearchViewHolder extends RecyclerView.ViewHolder {

        TextView mTv_goods_num_result;
        TextView mTv_goods_code_result;
        TextView mTv_actual_qty_result;
        TextView mTv_useful_qty_result;

        public GoodsWarehouseSearchViewHolder(View itemView) {
            super(itemView);
            mTv_goods_num_result = (TextView) itemView.findViewById(R.id.tv_goods_num_result);
            mTv_goods_code_result = (TextView) itemView.findViewById(R.id.tv_goods_code_result);
            mTv_actual_qty_result = (TextView) itemView.findViewById(R.id.tv_actual_qty_result);
            mTv_useful_qty_result = (TextView) itemView.findViewById(R.id.tv_useful_qty_result);
        }
    }
}
