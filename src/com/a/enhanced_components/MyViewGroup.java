package com.a.enhanced_components;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kent.androidannotationsdemo.R;

@EViewGroup(R.layout.view_group)
public class MyViewGroup extends LinearLayout{

	@ViewById(R.id.group_iv)
	ImageView mIv;
	@ViewById(R.id.group_title)
	TextView titleTV;
	@ViewById(R.id.group_content)
	TextView contentTV;
	
	
	public MyViewGroup(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyViewGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void setTexts(String title,String content){
		titleTV.setText(title);
		contentTV.setText(content);
	}
	
}
