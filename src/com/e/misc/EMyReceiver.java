package com.e.misc;

import org.androidannotations.annotations.EReceiver;
<<<<<<< HEAD
import org.androidannotations.annotations.ReceiverAction;
=======
>>>>>>> 26f0af6cd8875d78402923498af61e9c7ff49cbe

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
@EReceiver
public class EMyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
	
	@ReceiverAction("MySimpleBroadcase")
	void mySimpleAction(Intent intent){
		
	}
	
	@ReceiverAction
    void anotherAction(@ReceiverAction.Extra("specialExtraName") String valueString, @ReceiverAction.Extra long valueLong) {
        // ...
    }
	
	@ReceiverAction(value="heheBroadcast",dataSchemes="http")
	void onHttp(){
		
	}
	
	@ReceiverAction(value="heheBroadcast",dataSchemes={"http","https"})
	void onHttps(){
		
	}
	
=======

>>>>>>> 26f0af6cd8875d78402923498af61e9c7ff49cbe
}
