package com.h.typesafe_sharedpreferences;

import org.androidannotations.annotations.AfterPreferences;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.PreferenceByKey;
import org.androidannotations.annotations.PreferenceChange;
import org.androidannotations.annotations.PreferenceClick;
import org.androidannotations.annotations.PreferenceScreen;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
	
//@PreferenceHeaders(R.xml.preference_headers)
@PreferenceScreen(R.xml.preference)
@EActivity
public class HSharePrefreferenceActy extends PreferenceActivity{
	
	@PreferenceByKey(R.string.set_3g)
	CheckBoxPreference threeGCheckBox;
	
	@PreferenceByKey(R.string.set_roving)
	CheckBoxPreference RovingCheckBox;
	
	@PreferenceChange(R.string.set_3g)
	void checkedChangedOn3G(Preference preference) {
//		void checkedChangedOnMyButton(Preference preference ,boolean checked) {
		boolean checked;
		if (threeGCheckBox.isChecked()) {
			checked=true;
		}else {
			checked=false;
		}
		Toast.makeText(this, "Is 3GChecked ? : "+checked, 0).show();
	}
	
	@PreferenceClick(R.string.set_roving)
	void onRovingClick(){
		Toast.makeText(this, "Roving Setting Click", 0).show();
	}
	
	@AfterPreferences
	void afterPrefs(){
		RovingCheckBox.setChecked(false);
	}
	
//	@Override
//	public void onBuildHeaders(List<Header> target) {
//		// TODO Auto-generated method stub
//		super.onBuildHeaders(target);
//	}
	
	/**
	 * @AfterPreferences
	 */
}
