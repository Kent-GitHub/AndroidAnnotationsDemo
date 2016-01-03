package com.c.event_binding;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.BeforeTextChange;
import org.androidannotations.annotations.CheckedChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FocusChange;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.SeekBarProgressChange;
import org.androidannotations.annotations.SeekBarTouchStart;
import org.androidannotations.annotations.SeekBarTouchStop;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.cacty_layout)
@OptionsMenu(R.menu.main)
public class CActy extends Activity{
	@AfterViews
	void afterViews(){
		
	}
	
	@OptionsMenuItem(R.id.action_settings3)
	MenuItem menuItem;
	
	@OptionsItem(R.id.action_settings1)
	void optionItem1(){
		Toast.makeText(this, "Setting1 selected", 0).show();
	}
	
	@OptionsItem
	void action_settings2Selected(MenuItem item){
		Toast.makeText(this, "Setting2 selected", 0).show();
	}
	@OptionsItem({R.id.action_settings3,R.id.action_settings4,R.id.action_settings5})
	void optionSelected(MenuItem item){
		Toast.makeText(this, item.getTitle(), 0).show();
	}
	
	StringBuilder stringBuilder;
	@ViewById(R.id.c_tv)
	TextView tv;
	@ViewById(R.id.c_tv_showInfo)
	TextView infoTv;
	@ViewById(R.id.c_edTv)
	EditText edTv;
	@ViewById(R.id.c_seekBar_tv)
	TextView seekBarTv;
	@ViewById(R.id.c_seekBar_status)
	TextView seekBarStatus;
	@TextChange(R.id.c_tv)
	void onTvTextChange(CharSequence text, TextView hello, int before, int start, int count){
		stringBuilder.append("@TextChange:"+"\n"+"CharSequence:"+text+" before:"+
									before+" start:"+start+" count:"+count+"\n");
	}
	@TextChange
	void c_TvTextChanged(){
//	void c_tvTextChanged(){
//	void cTvTextChanged(){
		Log.d("CActy", "c_TvTextChanged");
	}
	@TextChange({R.id.c_tv,R.id.c_edTv})
	void textChange(){}
	@TextChange(R.id.c_tv)
	void ctvTextChange(){}
	
	@BeforeTextChange(R.id.c_tv)
	void beforeTextChange(TextView hello, CharSequence text, int start, int count, int after){
		stringBuilder.append("@BeforeTextChange:"+"\n"+"CharSequence:"+text+" start:"+
				start+" count:"+count+" after:"+after+"\n");
	}
	
	@AfterTextChange(R.id.c_tv)
	void afterTextChange(Editable text, TextView hello){
		stringBuilder.append("@AfterTextChange:"+"\n"+"Editable:"+text+"\n");
	}
	
	@Click({R.id.c_btn_submit,R.id.c_btn_listViewActy})
	void onClick(View v){
		switch (v.getId()) {
		case R.id.c_btn_submit:
			tv.setText(edTv.getText());
			infoTv.setText(stringBuilder);
			stringBuilder.setLength(0);
			break;
		case R.id.c_btn_listViewActy:
			ListViewActy_.intent(this).start();
			break;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		stringBuilder=new StringBuilder();
	}
	
	@FocusChange(R.id.c_edTv)
	void edTvFocusChange(View v,boolean hasFocus){
		if (hasFocus) {
			Toast.makeText(getApplicationContext(), "edTv Focus Geted", 0).show();
		}else {
			Toast.makeText(getApplicationContext(), "edTv Focus Gone", 0).show();
		}
	}
	
	@CheckedChange(R.id.c_theckBox)
	void onCheckChange(CompoundButton hello, boolean isChecked){
		if (isChecked) {
			Toast.makeText(getApplicationContext(), "TheckBox Checked", 0).show();
		}else {
			Toast.makeText(getApplicationContext(), "TheckBox unChecked", 0).show();
		}
	}
	
	@CheckedChange({R.id.c_radio0,R.id.c_radio1,R.id.c_radio2})
	void checked(CompoundButton hello, boolean isChecked){
		if (isChecked) {
			switch (hello.getId()) {
			case R.id.c_radio0:
				Toast.makeText(getApplicationContext(), "RadioButton1 Checked", 0).show();
				break;
			case R.id.c_radio1:
				Toast.makeText(getApplicationContext(), "RadioButton2 Checked", 0).show();
				break;
			case R.id.c_radio2:
				Toast.makeText(getApplicationContext(), "RadioButton3 Checked", 0).show();
				break;
			}
		}
	}
	
	@SeekBarProgressChange(R.id.c_seekBar)
	void onProgressChange(SeekBar seekBar, int progress, boolean fromUser){
		seekBarTv.setText("SeekBar Progress:"+progress);
	}
	@SeekBarTouchStart(R.id.c_seekBar)
	void touchStart(){
		seekBarStatus.setText("SeekBarTouchStart");
	}
	@SeekBarTouchStop(R.id.c_seekBar)
	void touchStop(){
		seekBarStatus.setText("SeekBarTouchStop");
	}
	
	
	/**
	 * @EditorAction
	 * @ItemSelect
	 */
	
	/**
	 * @keyDown
	 * @KeyUp
	 * @KeyLongPress
	 * @KeyMultiple
	 */
}
