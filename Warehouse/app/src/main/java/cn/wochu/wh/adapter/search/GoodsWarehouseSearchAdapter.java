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
 * Copyright 2016 DoubleDa
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
