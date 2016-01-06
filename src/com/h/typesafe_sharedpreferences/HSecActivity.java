package com.h.typesafe_sharedpreferences;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import com.kent.androidannotationsdemo.R;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
@EActivity(R.layout.hsec_layout)
public class HSecActivity extends Activity{
	@Pref
	ActivityPrefs_ activityPrefs;
	@Pref 
	DefaultPrefs_ defaultPrefs;
	@Pref
	ApplicationPrefs_ applicationPrefs;
	
	@ViewById(R.id.h_sec_tv)
	TextView tv;
	
	@Click({R.id.h_sec_btn_actyPrefs,R.id.h_sec_btn_defaultPrefs,R.id.h_sec_btn_applicationPrefs})
	void onClick(View v){
		HActy_ hacty=new HActy_();
		
		switch (v.getId()) {
		case R.id.h_sec_btn_actyPrefs:
			tv.setText("activityPrefs			scopeName :"+activityPrefs.scopeName().get());
			break;
		case R.id.h_sec_btn_defaultPrefs:
			tv.setText("defaultPrefs			scopeName :"+defaultPrefs.scopeName().get());
			break;
		case R.id.h_sec_btn_applicationPrefs:
			tv.setText("applicationPrefs 	scopeName :"+applicationPrefs.scopeName().get());
		break;
		}
	}
}
