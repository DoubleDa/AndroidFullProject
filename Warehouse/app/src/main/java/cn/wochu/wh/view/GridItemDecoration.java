package cn.wochu.wh.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by qibin on 2015/11/7.
 */
public class GridItemDecoration extends RecyclerView.ItemDecoration {
	private static final int[] ATTRS = new int[] { android.R.attr.listDivider };
	private Drawable mDivider;
	private boolean hasHeader;

	public GridItemDecoration(Context context) {
		final TypedArray a = context.obtainStyledAttributes(ATTRS);
		mDivider = a.getDrawable(0);
		a.recycle();
	}

	public GridItemDecoration(Context context, boolean header) {
		this(context);
		hasHeader = header;
	}

	@Override
	public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

		drawHorizontal(c, parent);
		drawVertical(c, parent);

	}

	private int getSpanCount(RecyclerView parent) {
		// 鍒楁暟
		int spanCount = -1;
		RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
		if (layoutManager instanceof GridLayoutManager) {

			spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
		} else if (layoutManager instanceof StaggeredGridLayoutManager) {
			spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
		}
		return spanCount;
	}

	public void drawHorizontal(Canvas c, RecyclerView parent) {
		int childCount = parent.getChildCount();
		for (int i = 0; i < childCount; i++) {
			final View child = parent.getChildAt(i);
			final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
			final int left = child.getLeft() - params.leftMargin;
			final int right = child.getRight() + params.rightMargin + mDivider.getIntrinsicWidth();
			final int top = child.getBottom() + params.bottomMargin;
			final int bottom = top + mDivider.getIntrinsicHeight();
			mDivider.setBounds(left, top, right, bottom);
			mDivider.draw(c);
		}
	}

	public void drawVertical(Canvas c, RecyclerView parent) {
		final int childCount = parent.getChildCount();
		for (int i = 0; i < childCount; i++) {
			final View child = parent.getChildAt(i);

			final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
			final int top = child.getTop() - params.topMargin;
			final int bottom = child.getBottom() + params.bottomMargin;
			final int left = child.getRight() + params.rightMargin;
			final int right = left + mDivider.getIntrinsicWidth();

			mDivider.setBounds(left, top, right, bottom);
			mDivider.draw(c);
		}
	}

	private boolean isLastColum(RecyclerView parent, int pos, int spanCount, int childCount) {
		RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
		if (layoutManager instanceof GridLayoutManager) {
			if ((pos + 1) % spanCount == 0) // 濡傛灉鏄渶鍚庝竴鍒楋紝鍒欎笉闇�瑕佺粯鍒跺彸杈�
			{
				return true;
			}
		} else if (layoutManager instanceof StaggeredGridLayoutManager) {
			int orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
			if (orientation == StaggeredGridLayoutManager.VERTICAL) {
				if ((pos + 1) % spanCount == 0) // 濡傛灉鏄渶鍚庝竴鍒楋紝鍒欎笉闇�瑕佺粯鍒跺彸杈�
				{
					return true;
				}
			} else {
				childCount = childCount - childCount % spanCount;
				if (pos >= childCount) // 濡傛灉鏄渶鍚庝竴鍒楋紝鍒欎笉闇�瑕佺粯鍒跺彸杈�
					return true;
			}
		}
		return false;
	}

	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
		int position = parent.getChildPosition(view);

		int spanCount = getSpanCount(parent);
		int childCount = parent.getAdapter().getItemCount();

		int pos = position;

		if (hasHeader) {
			if (position == 0) {
				outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
				return;
			} else {
				pos = position - 1;
			}
		}

		if (isLastColum(parent, pos, spanCount, childCount)) {
			outRect.set(0, 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicHeight());
		} else {
			outRect.set(0, 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicHeight());
		}
	}
}
