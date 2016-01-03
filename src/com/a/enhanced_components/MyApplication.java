package com.a.enhanced_components;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EApplication;

import android.app.Application;
@EApplication
public class MyApplication extends Application{
	@AfterInject
	protected void afterInject(){
		AActy_.append("MyApplication injected");
	}
}
