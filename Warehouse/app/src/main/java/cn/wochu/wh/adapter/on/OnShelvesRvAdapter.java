package cn.wochu.wh.adapter.on;

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
import cn.wochu.wh.adapter.MainActAdapter;
import cn.wochu.wh.entity.on.OnShelvesRvEntity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/17 下午5:18
 * alter person：dayongxin
 * alter time：16/6/17 下午5:18
 * alter remark：
 */
public class OnShelvesRvAdapter extends RecyclerView.Adapter<OnShelvesRvAdapter.OnShelvesRvAdapterViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private static List<OnShelvesRvEntity> mList = new ArrayList<>();

    private MainActAdapter.OnMyItemClickLitener mOnMyItemClickLitener;

    @Override
    public OnShelvesRvAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new OnShelvesRvAdapterViewHolder(mLayoutInflater.inflate(R.layout.rv_item_on_shelves_rv_adapter, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final OnShelvesRvAdapterViewHolder holder, final int i) {
        holder.mTv_goods_name.setText(mList.get(i).getGoodsCode() + "");
        holder.mTv_goods_code.setText(mList.get(i).getGoodsName() + "");
        holder.mTv_goods_unit.setText(mList.get(i).getGoodsUnit() + "");

        //点击条目删除
        if (mOnMyItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnMyItemClickLitener.onMyItemClick(v, pos);
                }
            });
        }

        holder.mEt_goods_num.setTag(i);
        holder.mEt_goods_num.setText(mList.get(i).getGoodsNum());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public interface OnMyItemClickLitener {
        void onMyItemClick(View view, int position);
    }

    public void setmOnMyItemClickLitener(MainActAdapter.OnMyItemClickLitener mOnMyItemClickLitener) {
        this.mOnMyItemClickLitener = mOnMyItemClickLitener;
    }

    public OnShelvesRvAdapter(Context context, List<OnShelvesRvEntity> list) {
        this.mContext = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public static class OnShelvesRvAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_goods_name;
        TextView mTv_goods_code;
        EditText mEt_goods_num;
        TextView mTv_goods_unit;

        public OnShelvesRvAdapterViewHolder(View itemView) {
            super(itemView);
            mTv_goods_name = (TextView) itemView.findViewById(R.id.tv_goods_name);
            mTv_goods_code = (TextView) itemView.findViewById(R.id.tv_goods_code);
            mEt_goods_num = (EditText) itemView.findViewById(R.id.et_goods_num);
            mTv_goods_unit = (TextView) itemView.findViewById(R.id.tv_goods_unit);

            mEt_goods_num.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (mEt_goods_num.getTag() != null) {
                        mList.set((Integer) mEt_goods_num.getTag(), new OnShelvesRvEntity(mList.get((Integer) mEt_goods_num.getTag()).getGoodsId(), mList.get((Integer) mEt_goods_num.getTag()).getGoodsName(), mList.get((Integer) mEt_goods_num.getTag()).getGoodsCode(), s.toString(), mList.get((Integer) mEt_goods_num.getTag()).getGoodsUnit()));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}
