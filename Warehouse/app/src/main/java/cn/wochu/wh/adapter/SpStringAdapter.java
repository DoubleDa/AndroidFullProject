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
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/14 下午3:49
 * alter person：dayongxin
 * alter time：16/6/14 下午3:49
 * alter remark：
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
