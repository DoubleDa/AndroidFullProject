package cn.wochu.wh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.GetWarehouseListEntity;

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
public class SpStringAdapter extends BaseAdapter {
    private List<String> getWarehouseListEntitys;
    private Context mContext;

    public SpStringAdapter(List<String> getWarehouseListEntitys, Context mContext) {
        this.getWarehouseListEntitys = getWarehouseListEntitys;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return getWarehouseListEntitys.size();
    }

    @Override
    public Object getItem(int position) {
        return getWarehouseListEntitys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.sp_item_layout, null);
        if (convertView != null) {
            TextView tv = (TextView) convertView.findViewById(R.id.tv_sp);
            tv.setText(getWarehouseListEntitys.get(position));
        }
        return convertView;
    }
}
