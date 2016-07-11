package cn.wochu.wh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.wochu.wh.R;
import cn.wochu.wh.entity.MainPageTitleEntity;


/**
 * project name：PrefixStorageProject
 * class describe：首页列表RecyclerView适配器
 * create person：dayongxin
 * create time：16/6/12 下午3:38
 * alter person：dayongxin
 * alter time：16/6/12 下午3:38
 * alter remark：
 */
public class MainActAdapter extends RecyclerView.Adapter<MainActAdapter.MainActAdapterViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<MainPageTitleEntity> mList;

    private OnMyItemClickLitener mOnMyItemClickLitener;

    @Override
    public MainActAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MainActAdapterViewHolder(mLayoutInflater.inflate(R.layout.rv_main_page_item_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(final MainActAdapterViewHolder mainActAdapterViewHolder, int i) {
        mainActAdapterViewHolder.tvName.setText(mList.get(i).getTitleName());

        if (mOnMyItemClickLitener != null) {
            mainActAdapterViewHolder.tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = mainActAdapterViewHolder.getLayoutPosition();
                    mOnMyItemClickLitener.onMyItemClick(view, pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public interface OnMyItemClickLitener {
        void onMyItemClick(View view, int position);
    }

    public void setmOnMyItemClickLitener(OnMyItemClickLitener mOnMyItemClickLitener) {
        this.mOnMyItemClickLitener = mOnMyItemClickLitener;
    }

    public MainActAdapter(Context context, List<MainPageTitleEntity> list) {
        this.mContext = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public static class MainActAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;

        public MainActAdapterViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }

}
