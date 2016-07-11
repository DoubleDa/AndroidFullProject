package cn.wochu.wh.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class FullyGridLayoutManager extends GridLayoutManager {
	private int	mwidth	= 0;
	private int	mheight	= 0;

	public FullyGridLayoutManager(Context context, int spanCount) {
		super(context, spanCount);
	}

	public FullyGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
		super(context, spanCount, orientation, reverseLayout);
	}

	private int[] mMeasuredDimension = new int[2];

	public int getMwidth() {
		return mwidth;
	}

	public void setMwidth(int mwidth) {
		this.mwidth = mwidth;
	}

	public int getMheight() {
		return mheight;
	}

	public void setMheight(int mheight) {
		this.mheight = mheight;
	}

	@Override
	public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
		final int widthMode = View.MeasureSpec.getMode(widthSpec);
		final int heightMode = View.MeasureSpec.getMode(heightSpec);
		final int widthSize = View.MeasureSpec.getSize(widthSpec);
		final int heightSize = View.MeasureSpec.getSize(heightSpec);

		int width = 0;
		int height = 0;
		int count = getItemCount();
		int span = getSpanCount();
		for (int i = 0; i < count; i++) {
			measureScrapChild(recycler, i, View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED), mMeasuredDimension);

			if (getOrientation() == HORIZONTAL) {
				if (i % span == 0) {
					width = width + mMeasuredDimension[0];
				}
				if (i == 0) {
					height = mMeasuredDimension[1];
				}
			}
			else {
				if (i % span == 0) {
					height = height + mMeasuredDimension[1];
				}
				if (i == 0) {
					width = mMeasuredDimension[0];
				}
			}
		}

		switch (widthMode) {
		case View.MeasureSpec.EXACTLY:
			width = widthSize;
		case View.MeasureSpec.AT_MOST:
		case View.MeasureSpec.UNSPECIFIED:
		}

		switch (heightMode) {
		case View.MeasureSpec.EXACTLY:
			height = heightSize;
		case View.MeasureSpec.AT_MOST:
		case View.MeasureSpec.UNSPECIFIED:
		}
		setMheight(height);
		setMwidth(width);
		setMeasuredDimension(width, height);
	}

	private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension) {
		if (position < getItemCount()) {
			try {
				View view = recycler.getViewForPosition(0);//fix 动态添加时报IndexOutOfBoundsException
				if (view != null) {
					this.measureChild(view, 0, 0);
					measuredDimension[0] = this.getDecoratedMeasuredWidth(view);
					measuredDimension[1] = this.getDecoratedMeasuredHeight(view);
					recycler.recycleView(view);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class SpacesItemDecoration extends RecyclerView.ItemDecoration {
		private int space;

		public SpacesItemDecoration(int space) {
			this.space = space;
		}

		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
			outRect.left = space;
			outRect.right = space;
			outRect.bottom = space;
			outRect.top = space;

			// Add top margin only for the first item to avoid double space between items
			//          if(parent.getChildLayoutPosition(view) == 0)
		}
	}
}