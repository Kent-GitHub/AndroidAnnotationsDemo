package com.f.resource_injection;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.res.ColorRes;
import org.androidannotations.annotations.res.DimensionRes;
import org.androidannotations.annotations.res.StringRes;

import com.kent.androidannotationsdemo.R;


import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.view.animation.Animation;
@EActivity
public class FActy extends Activity{
	@StringRes
	String stringInject;
	
	@ColorRes
	int colorInject;
	
	@AnimationRes(android.R.anim.fade_in)
	XmlResourceParser xmlResAnim0;
	@AnimationRes(android.R.anim.fade_in)
	Animation xmlResAnim1;
	
	@DimensionRes
	float fontSize;
	
	/**
	 * @DimensionPixelOffsetRes
	 * @DimensionPixelSizeRes
@BooleanRes
@ColorStateListRes
@DrawableRes
@IntArrayRes
@IntegerRes
@LayoutRes
@MovieRes
@TextRes
@TextArrayRes
@StringArrayRes
	 */
}
