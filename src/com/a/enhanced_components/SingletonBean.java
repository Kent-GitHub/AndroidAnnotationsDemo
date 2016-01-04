package com.a.enhanced_components;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;

@EBean(scope=Scope.Singleton)
public class SingletonBean {
	@AfterInject
	void injected(){
		AActy.append("SingletonBean Injected.");
	}
}
