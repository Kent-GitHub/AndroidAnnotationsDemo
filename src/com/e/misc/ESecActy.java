package com.e.misc;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.kent.androidannotationsdemo.R;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;

@EActivity(R.layout.e_sec_acty)
public class ESecActy extends Activity{
	@ViewById(R.id.e_sec_ed_name)
	EditText nameEd;
	@ViewById(R.id.e_sec_ed_age)
	EditText ageEd;
	
	@Click(R.id.e_sec_btn_commit)
	void commitAndReturn(){
		Intent i=new Intent();
		i.putExtra("name", nameEd.getText().toString());
		i.putExtra("age", ageEd.getText().toString());
		setResult(998, i);
		finish();
	}
	
}
