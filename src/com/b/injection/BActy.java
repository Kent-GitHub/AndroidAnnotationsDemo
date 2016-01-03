package com.b.injection;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FromHtml;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.HtmlRes;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spanned;
import android.widget.TextView;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.bacty_layout)
public class BActy extends Activity{
	@Extra
	String name;
	@Extra
	int age;
	
	@AfterViews
	void afterViews(){
		append("BActy AfterViews.");
		mTextView.setText(stringBuilder);
		htmlRes.setText(myHelloString+"\n"+hello_html+"\n"+hello_Html);
	}
	
	@ViewById(R.id.b_commom_tv)
	TextView mTextView;
	@ViewById(R.id.b_htmlRes)
	TextView htmlRes;
	
	StringBuilder stringBuilder;
	
	@AfterExtras
	void afterExtras(){
		append("BActy AfterExtras Name :"+name +", Age :"+age);
	}
	
	void append(String info){
		if (stringBuilder==null) {
			stringBuilder=new StringBuilder();
		}
		stringBuilder.append(info+"\n");
		if (mTextView!=null) {
			mTextView.setText(stringBuilder.toString());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		append("BActy Created.");
	}
	
	@AfterInject
	void afterInject(){
		append("BActy AfterInjected.");
	}
	
	@HtmlRes(R.string.hello_html)
	Spanned myHelloString;
	
	@HtmlRes
	CharSequence hello_html;
	
	@HtmlRes
	CharSequence hello_Html;
	
	@ViewById(R.id.b_fromHtml)
	@FromHtml(R.string.hello_html)
	TextView helloHtml;
	
	/**
	 * @Bean
	 * 注解生成的子类是final类型的，也就是说我们不能在继承生成的类。但是我们可以扩展原始的类。扩展出来的类同样可以使用注解。
	 * @EActivity
	 * public classMyChildActivity extends MyActivity {
	 * }
	 */
	
	/**
	 * @FragmentArg
	 * @FragmentById
	 * @FragmentByTag
	 */
	/**
	 * @HttpsClient
	 * @NoConfigurationInstance
	 * @RootContext
	 */
}
