package com.a.enhanced_components;

import org.androidannotations.annotations.EService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
@EService
public class MyService extends Service{
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
}
