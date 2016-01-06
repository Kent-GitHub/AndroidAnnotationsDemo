package com.d.threading;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.api.BackgroundExecutor;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.dacty_layout)
public class DActy extends Activity{
	@ViewById(R.id.d_acty_tv)
	TextView tv;
	@ViewById(R.id.d_threadStatus)
	TextView threadStatusTv;
	StringBuilder stringBuilder;
	
	@Click({R.id.d_btn_thread,R.id.d_longTimeThread,R.id.d_ThreadCancel})
	void click(View v){
		switch (v.getId()) {
		case R.id.d_btn_thread:
			doInBackground();
			break;
		case R.id.d_longTimeThread:
			fiveSecThread();
			break;
		case R.id.d_ThreadCancel:
			BackgroundExecutor.cancelAll("hehe", true);
			threadStatusTv.setText("Thread Stoped");
			break;
		}
	}
	
	@Background
	void doInBackground(){
		stringBuilder.append("Do in background,Thread id:"+Thread.currentThread().getId()+"\n");
		doInUiThread();
	}
	
	@UiThread
	void doInUiThread(){
		stringBuilder.append("Do in UiThread,Thread id:"+Thread.currentThread().getId()+"\n");
		tv.setText(stringBuilder);
	}
	@UiThread
	void updateThreadStatus(int process){
		if (process!=0) {
			threadStatusTv.setText("Thread process:"+process);
		}else {
			threadStatusTv.setText("Thread Stoped");
		}
	}
	
	@Background(id="hehe",delay=1000)
	void fiveSecThread(){
		try {
			for (int i = 1; i < 101; i++) {
				Thread.sleep(50);
				updateThreadStatus(i);
			}
			updateThreadStatus(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterViews
	void afterViews(){
		stringBuilder=new StringBuilder();
	}
	
	/**
	 * @Serial
	 */
}
