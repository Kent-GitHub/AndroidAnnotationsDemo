package com.e.misc;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.Trace;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.kent.androidannotationsdemo.R;
@WindowFeature({Window.FEATURE_NO_TITLE,Window.FEATURE_INDETERMINATE_PROGRESS})
@Fullscreen
@EActivity(R.layout.eacty_layout)
public class EActy extends Activity{
	@InstanceState
    String name;
	
	@ViewById(R.id.e_tv_name)
 	TextView nameTv;
	@ViewById(R.id.e_ed_name)
	EditText nameEd;
	@Click({R.id.e_orientation,R.id.e_btn_name})
	void onCLick(View v){
		switch (v.getId()) {
		case R.id.e_orientation:
			boolean misLanscape = this.getResources().getConfiguration().orientation 
			== Configuration.ORIENTATION_LANDSCAPE;
			if (misLanscape) {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			}else {
				setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			}
			break;

		case R.id.e_btn_name:
			name=nameEd.getText().toString();
			if (nameTv==null) {
				return;
			}
			nameTv.setText("Name :"+name);
			break;
		}
	}
	
	@AfterViews
	@Trace(tag="CustomTag", level=Log.ERROR)
	void afterViews(){
		nameTv.setText("Name :"+name);
	}
	/**
	 * @CustomTitle
	 * @InjectMenu
	 * @OrmLiteDao
	 * @RoboGuice
	 */
}
