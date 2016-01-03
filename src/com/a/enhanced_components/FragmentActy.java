package com.a.enhanced_components;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.frag_acty)
public class FragmentActy extends FragmentActivity{
	@Click(R.id.a_fragActy_add)
	void click(){
		MyFragment mFragment=new MyFragment_();
		mFragment.setString("这是动态加载的Fragment");
		FragmentTransaction action= getSupportFragmentManager().beginTransaction();
		action.add(R.id.a_frag_acty_addLL, mFragment);
		action.commit();
	}
}
