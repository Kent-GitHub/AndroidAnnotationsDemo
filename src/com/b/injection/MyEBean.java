package com.b.injection;

import org.androidannotations.annotations.EBean;

import com.a.enhanced_components.MyBean;

@EBean
public class MyEBean extends MyBean{
	class Hehe extends MyEBean{
		
	}
}
