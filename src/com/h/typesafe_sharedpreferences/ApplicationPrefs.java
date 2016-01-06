package com.h.typesafe_sharedpreferences;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.DefaultRes;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;
import org.androidannotations.annotations.sharedpreferences.SharedPref.Scope;

import com.kent.androidannotationsdemo.R;
//@SharedPref(value=Scope.ACTIVITY)
//@SharedPref(value=Scope.ACTIVITY_DEFAULT)
@SharedPref(value=Scope.APPLICATION_DEFAULT)
//@SharedPref(value=Scope.UNIQUE)
public interface ApplicationPrefs {
	@DefaultString("John")
	String name();
	
	@DefaultInt(20)
	int age();
	
	long lastUpdate();
	
	@DefaultRes(R.string.nick_name)
	String resourceName();
	
	@DefaultString("DefaultName")
	String scopeName();
}
