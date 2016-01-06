package com.c.event_binding;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kent.androidannotationsdemo.R;
@EActivity(R.layout.c_list_acty)
public class ListViewActy extends Activity{
	@ViewById(R.id.c_listView)
	ListView mListView;
	@AfterViews
	void afterViews(){
		mListView.setAdapter(mAdapter);
	}
	
	@ItemClick(R.id.c_listView)
	void itemClick(int position){
//	void itemClick(MyItem clickedItem){
		Toast.makeText(this, mDatas.get(position)+" Clicked", 0).show();
	}
	@ItemLongClick
	void c_listViewItemLongClicked(String clickedItem){
		Toast.makeText(this, clickedItem+" Long Clicked", 0).show();
	}
	@ItemSelect(R.id.c_listView)
	void itemSelected(boolean selected, int position){
		Toast.makeText(this, position+" selected", 0).show();
	}
	private List<String> mDatas;
	private BaseAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mDatas=new ArrayList<String>();
		for (int i = 0; i < 51; i++) {
			mDatas.add("Item :"+i);
		}
		mAdapter=new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView tv=new TextView(getApplicationContext());
				tv.setText(mDatas.get(position));
				return tv;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return mDatas.get(position);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mDatas.size();
			}
		};
	}
	
}
