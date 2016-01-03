package com.a.enhanced_components;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.widget.TextView;

import com.kent.androidannotationsdemo.R;
@EFragment(R.layout.frag_layout)
public class MyFragment extends android.support.v4.app.Fragment{
	@ViewById(R.id.a_frag_tv)
	TextView tv;
	 
	String str;
	
//	@Override
//	public View onCreateView(LayoutInflater inflater, ViewGroup container,
//			Bundle savedInstanceState) {
//		View view=inflater.inflate(R.layout.frag_layout, container ,false);
//		tv=(TextView) view.findViewById(R.id.a_frag_tv);
//		return view;
//	}
	
	@AfterViews
	void afterView(){
		if (str!=null) {
			tv.setText(str);
		}
	}
	
	void setString(String str){
		this.str=str;
	}
	
}
