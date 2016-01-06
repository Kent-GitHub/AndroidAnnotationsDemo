package com.h.typesafe_sharedpreferences;

<<<<<<< HEAD
import java.util.Date;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.hacty_layout)
public class HActy extends Activity{
	
	@Pref
	MyPrefInterface_ myPrefs;
	@Pref
	MyPrefInterface_ HActy_MyPrefs;
	@Pref
	MyPrefInterface_ HActy;
	@Pref
    MyPrefInterface_	MyPrefs; 
	
	@ViewById()
	TextView h_tv_name,h_tv_age,h_ed_age,h_ed_name,h_tv_prefsStatus;
	@Click({R.id.h_btn_name,R.id.h_btn_age,R.id.h_btn_clear,R.id.h_btn_prefsStatus})
	void onclick(View v){
		long now;
		long lastUpdated;
		switch (v.getId()) {
		case R.id.h_btn_name:
			myPrefs.name().put(h_ed_name.getText().toString());
			now = System.currentTimeMillis();
			myPrefs.lastUpdate().put(now);
			break;
		case R.id.h_btn_age:
			try {
				int age=Integer.parseInt(h_ed_age.getText().toString());
				if (age<0) {
					throw new Exception();
				}
				myPrefs.age().put(age);
				now = System.currentTimeMillis();
				myPrefs.lastUpdate().put(now);
			} catch (Exception e) {
				Toast.makeText(this, "请输入一个大於零的整数", 0).show();
			}
			break;
		case R.id.h_btn_clear:
				myPrefs.clear();
				break;
		case R.id.h_btn_prefsStatus:
			boolean nameExists = myPrefs.name().exists();
			lastUpdated = myPrefs.lastUpdate().get();
			if (lastUpdated==0) {
				now = System.currentTimeMillis();
				lastUpdated = myPrefs.lastUpdate().getOr(now);
				myPrefs.lastUpdate().put(lastUpdated);
			}
			h_tv_prefsStatus.setText("myPrefs.name().exists() - "+nameExists+"  myPrefs.age().exists() - "+myPrefs.age().exists()
					+"\n"+ "DefaultName-John,      DefaultAge-20"+"\n"
					+"myPrefs.name().get() : "+myPrefs.name().get()+", myPrefs.age().get() : "+myPrefs.age().get()+"\n"
					+"@DefaultRes nickName : "+myPrefs.resourceName().get()+"\n"
					+"Last Time Update:"+new Date(lastUpdated));
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
	
=======
import org.androidannotations.annotations.EActivity;

import android.app.Activity;
@EActivity
public class HActy extends Activity{

>>>>>>> 26f0af6cd8875d78402923498af61e9c7ff49cbe
}
