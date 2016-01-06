package com.h.typesafe_sharedpreferences;

import java.util.Date;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.hacty_layout)
public class HActy extends Activity{
	
	@Pref
	ActivityPrefs_ activityPrefs;
	@Pref 
	DefaultPrefs_ defaultPrefs;
	@Pref
	ApplicationPrefs_ applicationPrefs;
	
	@ViewById()
	TextView h_tv_name,h_tv_age,h_ed_age,h_ed_name,h_tv_prefsStatus;
	@ViewById(R.id.h_ed_scopeName)
	EditText edScopeName;
	@ViewById(R.id.h_tv_scopeName)
	TextView tvScopeName;
	@Click({R.id.h_btn_name,R.id.h_btn_age,R.id.h_btn_clear,R.id.h_btn_prefsStatus,R.id.h_btn_secActy,R.id.h_btn_actyPrefs,
		R.id.h_btn_defaultPrefs,R.id.h_btn_applicationPrefs,R.id.h_btn_prefsActy})
	void onclick(View v){
		long now;
		long lastUpdated;
		switch (v.getId()) {
		case R.id.h_btn_name:
			activityPrefs.name().put(h_ed_name.getText().toString());
			now = System.currentTimeMillis();
			activityPrefs.lastUpdate().put(now);
			break;
		case R.id.h_btn_age:
			try {
				int age=Integer.parseInt(h_ed_age.getText().toString());
				if (age<0) {
					throw new Exception();
				}
				activityPrefs.age().put(age);
				now = System.currentTimeMillis();
				activityPrefs.lastUpdate().put(now);
			} catch (Exception e) {
				Toast.makeText(this, "请输入一个大於零的整数", 0).show();
			}
			break;
		case R.id.h_btn_clear:
			activityPrefs.clear();
			defaultPrefs.clear();
			applicationPrefs.clear();
				break;
		case R.id.h_btn_prefsStatus:
			boolean nameExists = activityPrefs.name().exists();
			lastUpdated = activityPrefs.lastUpdate().get();
			if (lastUpdated==0) {
				now = System.currentTimeMillis();
				lastUpdated = activityPrefs.lastUpdate().getOr(now);
				activityPrefs.lastUpdate().put(lastUpdated);
			}
			h_tv_prefsStatus.setText("myPrefs.name().exists() - "+nameExists+"  myPrefs.age().exists() - "+activityPrefs.age().exists()
					+"\n"+ "DefaultName-John,      DefaultAge-20"+"\n"
					+"myPrefs.name().get() : "+activityPrefs.name().get()+", myPrefs.age().get() : "+activityPrefs.age().get()+"\n"
					+"@DefaultRes nickName : "+activityPrefs.resourceName().get()+"\n"
					+"Last Time Update:"+new Date(lastUpdated));
			break;
		case R.id.h_btn_secActy:
			HSecActivity_.intent(this).start();
		case R.id.h_btn_actyPrefs:
			activityPrefs.scopeName().put(edScopeName.getText().toString());
			break;
		case R.id.h_btn_defaultPrefs:
			defaultPrefs.scopeName().put(edScopeName.getText().toString());
			break;
		case R.id.h_btn_applicationPrefs:
			applicationPrefs.scopeName().put(edScopeName.getText().toString());
			break;
		case R.id.h_btn_prefsActy:
			HSharePrefreferenceActy_.intent(this).start();
			break;
		default:
//					myPrefs.edit()
//					  .name()
//					  .put("John")
//					  .age()
//					  .put(42)
//					  .apply();
				break;
		}
	}
	/**
	 * Using it with a PreferenceActivity
	 */
}
