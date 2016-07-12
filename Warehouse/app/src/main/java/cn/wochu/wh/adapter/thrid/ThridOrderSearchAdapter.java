package cn.wochu.wh.adapter.thrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.search.DCJDORDERDETAILItem;
import cn.wochu.wh.entity.search.ThridOrderSearchEntity;

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
public class ThridOrderSearchAdapter extends RecyclerView.Adapter<ThridOrderSearchAdapter.ThridOrderSearchAdapterVH> {
    private Context mContext;
    private List<ThridOrderSearchEntity.DCJDORDERDETAILItemEntity> mList;
    private LayoutInflater mLayoutInflater;

    public ThridOrderSearchAdapter(Context mContext, List<ThridOrderSearchEntity.DCJDORDERDETAILItemEntity> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ThridOrderSearchAdapterVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ThridOrderSearchAdapterVH(mLayoutInflater.inflate(R.layout.rv_item_thrid_order_search_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ThridOrderSearchAdapterVH holder, int i) {
        holder.mTv_goods_code.setText(mList.get(i).getGOODSCODE() + "");
        holder.mTv_goods_name.setText(mList.get(i).getGOODSNAME() + "");
        holder.mTv_goods_num.setText(mList.get(i).getGOODSNUMBER() + "");
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class ThridOrderSearchAdapterVH extends RecyclerView.ViewHolder {
        TextView mTv_goods_code;
        TextView mTv_goods_name;
        TextView mTv_goods_num;

        public ThridOrderSearchAdapterVH(View itemView) {
            super(itemView);

            mTv_goods_code = (TextView) itemView.findViewById(R.id.tv_goods_code);
            mTv_goods_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            mTv_goods_num = (TextView) itemView.findViewById(R.id.tv_goods_num);
        }
    }
}
