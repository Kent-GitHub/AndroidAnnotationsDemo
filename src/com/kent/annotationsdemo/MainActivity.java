package com.kent.annotationsdemo;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import android.app.Activity;
import android.view.View;

import com.a.enhanced_components.AActy_;
import com.b.injection.BActy_;
import com.c.event_binding.CActy_;
import com.d.threading.DActy_;
import com.e.misc.EActy_;
import com.f.resource_injection.FActy_;
import com.g.rest_api.GActy_;
import com.h.typesafe_sharedpreferences.HActy_;
import com.i.preference_api_helpers.IActy_;
import com.kent.androidannotationsdemo.R;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	@Click({R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9,})
	protected void buttonClick(View v){
		switch (v.getId()) {
		case R.id.btn1:
			AActy_.intent(this).start();
			break;
		case R.id.btn2:
			BActy_.intent(this).extra("name", "Nate").extra("age", 18).start();
			break;
		case R.id.btn3:
			CActy_.intent(this).start();
			break;
		case R.id.btn4:
			DActy_.intent(this).start();
			break;
		case R.id.btn5:
			EActy_.intent(this).start();
			break;
		case R.id.btn6:
			FActy_.intent(this).start();
			break;
		case R.id.btn7:
			GActy_.intent(this).start();
			break;
		case R.id.btn8:
			HActy_.intent(this).start();
			break;
		case R.id.btn9:
			IActy_.intent(this).start();
			break;
		}
	}
}
