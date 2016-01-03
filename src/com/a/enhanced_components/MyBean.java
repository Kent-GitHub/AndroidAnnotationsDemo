package com.a.enhanced_components;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

@EBean
public class MyBean extends ParentBean{
	@AfterInject
	protected void afterInject(){
		AActy.append("MyBean injected");
	}
}
