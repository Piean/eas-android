package com.yds.educationaladministrationsystem.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 
 * @Description:适配ScrollView的ListView
 */
public class ListViewForScrollView extends ListView{

	public ListViewForScrollView(Context context) {
		this(context,null);
	}
	
	public ListViewForScrollView(Context context, AttributeSet attrs) {

		this(context, attrs, 0);
	}
	
	public ListViewForScrollView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}


	/**
	 * 重写该方法，达到使ListView适应ScrollView
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
