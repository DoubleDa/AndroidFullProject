package cn.wochu.wh.adapter.check;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.check.GoodsCheckEntity;
import cn.wochu.wh.utils.StringUtils;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/21 下午1:45
 * alter person：dayongxin
 * alter time：16/6/21 下午1:45
 * alter remark：
 */
public class GoodsCheckActAdapter extends RecyclerView.Adapter<GoodsCheckActAdapter.GoodsCheckActAdapterViewHolder> {
    private Context mContext;
    private static List<GoodsCheckEntity> mList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private OnMyItemClickLitener mOnMyItemClickLitener;

    public void setmOnMyItemClickLitener(OnMyItemClickLitener mOnMyItemClickLitener) {
        this.mOnMyItemClickLitener = mOnMyItemClickLitener;
    }

    public interface OnMyItemClickLitener {
        void onMyItemClick(View view, int position);
    }


    public GoodsCheckActAdapter(Context mContext, List<GoodsCheckEntity> mList) {
        this.mContext = mContext;
        this.mList = mList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public GoodsCheckActAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GoodsCheckActAdapterViewHolder(mLayoutInflater.inflate(R.layout.rv_item_goods_check_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final GoodsCheckActAdapterViewHolder holder, int i) {
        holder.mTv_goods_name.setText(mList.get(i).getGoodsName() + "");
        holder.mTv_current_warehouse.setText(mList.get(i).getActualQty() + "");

        holder.mEt_actual_warehouse.setTag(i);
        holder.mEt_actual_warehouse.setText(mList.get(i).getUsefulQty() + "");

        if (mOnMyItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnMyItemClickLitener.onMyItemClick(v, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class GoodsCheckActAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_goods_name;
        TextView mTv_current_warehouse;
        EditText mEt_actual_warehouse;

        public GoodsCheckActAdapterViewHolder(View itemView) {
            super(itemView);
            mTv_goods_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            mTv_current_warehouse = (TextView) itemView.findViewById(R.id.tv_current_warehouse);
            mEt_actual_warehouse = (EditText) itemView.findViewById(R.id.et_actual_warehouse);

            mEt_actual_warehouse.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (mEt_actual_warehouse.getTag() != null) {
                        int index = (Integer) mEt_actual_warehouse.getTag();
                        mList.set(index, new GoodsCheckEntity(mList.get(index).getGoodsID(), mList.get(index).getGoodsName(), mList.get(index).getGoodsCode(), mList.get(index).getActualQty(), StringUtils.toInt(s.toString(), 0)));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}
