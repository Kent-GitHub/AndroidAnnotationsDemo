package com.a.enhanced_components;

import org.androidannotations.annotations.EIntentService;

import android.app.IntentService;
import android.content.Intent;
@EIntentService
public class MyIntentService extends IntentService{
	public MyIntentService() {
		super("MyIntentService");
	}
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}

}
