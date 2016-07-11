package cn.wochu.wh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.GetDCTransOnShelvesEntity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/16 下午4:00
 * alter person：dayongxin
 * alter time：16/6/16 下午4:00
 * alter remark：
 */
public class GoodsOnShelvesRvAdapter extends RecyclerView.Adapter<GoodsOnShelvesRvAdapter.GoodsOnShelvesRvAdapterViewHolder> {
    private Context mContext;
    private List<GetDCTransOnShelvesEntity> mList;
    private LayoutInflater mLayoutInflater;
    private SparseBooleanArray array = new SparseBooleanArray();
    private OnSelectedItemListener mOnSelectedItemListener;

    public GoodsOnShelvesRvAdapter(Context mContext, List<GetDCTransOnShelvesEntity> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setmOnSelectedItemListener(OnSelectedItemListener mOnSelectedItemListener) {
        this.mOnSelectedItemListener = mOnSelectedItemListener;
    }

    public interface OnSelectedItemListener {
        void onItemSelectedResult(int index, boolean isSelected);
    }


    @Override
    public GoodsOnShelvesRvAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GoodsOnShelvesRvAdapterViewHolder(mLayoutInflater.inflate(R.layout.rv_item_transfer_onshelves, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(GoodsOnShelvesRvAdapterViewHolder goodsOnShelvesRvAdapterViewHolder, int i) {
        //商品编码
        goodsOnShelvesRvAdapterViewHolder.mTv_scan_goods_num.setText(mList.get(i).getGOODSNUMBER() + "");
        //商品名称
        goodsOnShelvesRvAdapterViewHolder.mTv_scan_goods_name.setText(mList.get(i).getGOODSNAME() + "");
        //商品来源
        goodsOnShelvesRvAdapterViewHolder.mTv_goods_from.setText(mList.get(i).getREQUESTWAREHOUSENAME() + "");
        //商品数量
        goodsOnShelvesRvAdapterViewHolder.mTv_goods_num.setText(mList.get(i).getGOODSCODE() + "");

        goodsOnShelvesRvAdapterViewHolder.mCb_result.setTag(i);

        goodsOnShelvesRvAdapterViewHolder.mCb_result.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int pos = (int) buttonView.getTag();
                if (isChecked) {
                    array.put(pos, true);
                    if (mOnSelectedItemListener != null) {
                        mOnSelectedItemListener.onItemSelectedResult(pos, true);
                    }
                } else {
                    array.delete(pos);
                    if (mOnSelectedItemListener != null) {
                        mOnSelectedItemListener.onItemSelectedResult(pos, false);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class GoodsOnShelvesRvAdapterViewHolder extends RecyclerView.ViewHolder {
        CheckBox mCb_result;
        TextView mTv_goods_num;
        TextView mTv_scan_goods_name;
        TextView mTv_goods_from;
        TextView mTv_scan_goods_num;


        public GoodsOnShelvesRvAdapterViewHolder(View itemView) {
            super(itemView);
            mCb_result = (CheckBox) itemView.findViewById(R.id.cb_result);
            mTv_goods_num = (TextView) itemView.findViewById(R.id.tv_goods_num);
            mTv_scan_goods_name = (TextView) itemView.findViewById(R.id.tv_scan_goods_name);
            mTv_goods_from = (TextView) itemView.findViewById(R.id.tv_goods_from);
            mTv_scan_goods_num = (TextView) itemView.findViewById(R.id.tv_scan_goods_num);
        }
    }
}
