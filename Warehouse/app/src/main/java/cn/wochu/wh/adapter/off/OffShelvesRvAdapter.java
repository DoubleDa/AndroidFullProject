package cn.wochu.wh.adapter.off;

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
import cn.wochu.wh.entity.off.OffShelvesRvEntity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/17 下午5:18
 * alter person：dayongxin
 * alter time：16/6/17 下午5:18
 * alter remark：
 */
public class OffShelvesRvAdapter extends RecyclerView.Adapter<OffShelvesRvAdapter.OnShelvesRvAdapterViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private static List<OffShelvesRvEntity> mList = new ArrayList<>();

    private MainActAdapter.OnMyItemClickLitener mOnMyItemClickLitener;

    @Override
    public OnShelvesRvAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new OnShelvesRvAdapterViewHolder(mLayoutInflater.inflate(R.layout.rv_item_off_shelves_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final OnShelvesRvAdapterViewHolder holder, final int i) {
        holder.mTv_off_goods_code.setText(mList.get(i).getGoodsCode() + "");
        holder.mTv_off_goods_name.setText(mList.get(i).getGoodsName() + "");
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
        holder.mTv_off_goods_num.setTag(i);
        holder.mTv_off_goods_num.setText(mList.get(i).getGoodsNum());
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

    public OffShelvesRvAdapter(Context context, List<OffShelvesRvEntity> list) {
        this.mContext = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public static class OnShelvesRvAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView mTv_off_goods_code;
        TextView mTv_off_goods_name;
        EditText mTv_off_goods_num;

        public OnShelvesRvAdapterViewHolder(View itemView) {
            super(itemView);
            mTv_off_goods_code = (TextView) itemView.findViewById(R.id.tv_off_goods_code);
            mTv_off_goods_name = (TextView) itemView.findViewById(R.id.tv_off_goods_name);
            mTv_off_goods_num = (EditText) itemView.findViewById(R.id.tv_off_goods_num);
            mTv_off_goods_num.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (mTv_off_goods_num.getTag() != null) {
                        mList.set((Integer) mTv_off_goods_num.getTag(), new OffShelvesRvEntity(mList.get((Integer) mTv_off_goods_num.getTag()).getGoodsCode(), mList.get((Integer) mTv_off_goods_num.getTag()).getGoodsName(), mList.get((Integer) mTv_off_goods_num.getTag()).getGoodsId(), s.toString()));
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }
    }
}
