package com.a.enhanced_components;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.aacty_layout)
public class AActy extends Activity{
	static StringBuilder stringBuilder;
	@AfterInject
	protected void afterInject(){
		stringBuilder.append("AActy injected.");
	}
	
	@ViewById(R.id.a_commom_tv)
	static TextView mTextView;
	@ViewById(R.id.a_commom_ll)
	LinearLayout mLL;
	@ViewById(R.id.a_viewGroup)
	MyViewGroup viewGroup;
	
	@App
	MyApplication mApplication;
	
	/**
	 * ParentBean不是EBean不过MyBean是EBean并继承ParentBean
	 */
	@Bean(MyBean.class)
	ParentBean parentBean;
	
	@Bean
	MyBean mBean1;
	
	@Bean
	MyBean mBean2;
	
	@Bean
	SingletonBean bean1;
	
	@Bean
	SingletonBean bean2;
	
	@Click({R.id.a_fragment_acty,R.id.a_group_setText})
	void click(View v){
		switch (v.getId()) {
		case R.id.a_fragment_acty:
			FragmentActy_.intent(this).start();
			break;
		case R.id.a_group_setText:
			viewGroup.setTexts("This is news title.", "This is news content......");
			break;
		}
	}
	
	public static void append(String info){
		if (stringBuilder==null) {
			stringBuilder=new StringBuilder();
		}
		stringBuilder.append(info+"\n");
		if (mTextView!=null) {
			mTextView.setText(stringBuilder.toString());
		}else {
			Log.d("AActy", "mTextView is null");
		}
	}
	
	@AfterViews
	void afterViews(){
		mTextView.setText(stringBuilder.toString());
		EButton button=EButton_.build(this);
		button.setText("EButtonView");
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(AActy.this, "EButton clicked", 0).show();
			}
		});
		mLL.addView(button);
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		stringBuilder.setLength(0);
	}
	
	
	/**
	 * ignore:5.6.DialogFragments
	 * 待解决：@EReceiver
	 */
	
}
