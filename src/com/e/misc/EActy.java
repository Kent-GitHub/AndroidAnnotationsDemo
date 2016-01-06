package com.e.misc;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.InstanceState;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.Trace;
import org.androidannotations.annotations.Transactional;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
import com.kent.androidannotationsdemo.R.string;
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
	@Click({R.id.e_orientation,R.id.e_btn_name,R.id.e_btn_forResult,R.id.e_btn_sendBroadcast})
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
		case R.id.e_btn_forResult:
			ESecActy_.intent(this).startForResult(0);
			break;
		case R.id.e_btn_sendBroadcast:
			Intent bi=new Intent();
			bi.setAction("com.kent.sendBroadcast").putExtra("name", "Nate").putExtra("age", 18);
			sendBroadcast(bi);
			break;
		}
	}
	
	@AfterViews
	@Trace(tag="CustomTag", level=Log.ERROR)
	void afterViews(){
		nameTv.setText("Name :"+name);
	}
	
	@Transactional
	void doSomeDbWork(SQLiteDatabase db){
		//db.execSQL("Some SQL");
	}
	
	@OnActivityResult(0)
	void onResult(int resultCode,Intent data){
//	void onResult(int resultCode){
//	void onResult(Intent data){
//	void onResult(){
	}
	@OnActivityResult(0)
	void onResule(int resultCode, Intent data, @OnActivityResult.Extra String name,@OnActivityResult.Extra String age){
//	void onResule(int resultCode, Intent data, @OnActivityResult.Extra String value){
//	void onResult(int resultCode, @OnActivityResult.Extra(value = "key") String value) {
//	void onResult(@OnActivityResult.Extra String strVal, @OnActivityResult.Extra int intVal) {
		if (resultCode==998) {
			Toast.makeText(this, "Name :"+name +", age :"+age, 0).show();
		}
	}
	
	@Receiver(actions="com.kent.sendBroadcast")
	void onAction(@Receiver.Extra String name,@Receiver.Extra("age") int ageFromIntent,Context context){
//	void onAction(@Receiver.Extra String name,@Receiver.Extra("age") int age){
//	void onAction(){
		Toast.makeText(this, "Receive broadcast,name:"+name+", age:"+ageFromIntent, 0).show();
	}
	
	/**
	 * @CustomTitle
	 * @InjectMenu
	 * @OrmLiteDao
	 * @RoboGuice
	 * @Transactional
	 * @HierarchyViewerSupport
	 * @ServiceAction
<<<<<<< HEAD
	 * @ReceiverAction
=======
>>>>>>> 26f0af6cd8875d78402923498af61e9c7ff49cbe
	 */
}
