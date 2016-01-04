package com.e.misc;

import org.androidannotations.annotations.EReceiver;
import org.androidannotations.annotations.ReceiverAction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
@EReceiver
public class EMyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
	}
	
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
	
}
