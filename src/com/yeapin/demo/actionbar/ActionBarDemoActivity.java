package com.yeapin.demo.actionbar;

import com.yeapin.androidproject.R;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;

/**
 * 利用ActionBar实现Tab导航
 * 这里要注意使用android.support.v7.app.ActionBar
 * @author Jet 2016年3月16日
 */
public class ActionBarDemoActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.OnNavigationListener {
	private static final String SELECTED_ITEM = "selected_item";
//	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action_bar_demo);
		android.support.v7.app.ActionBar actionBar = getSupportActionBar();
		//设置ActionBar显示标题
		actionBar.setDisplayShowTitleEnabled(true);
		//设置ActionBar模式
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		//设置Adapter
		actionBar.setListNavigationCallbacks(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				android.R.id.text1, new String[] { "第一项", "第二项", "第三项" }), this);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		//选中前面保存的索引对应的Fragment页
		if(savedInstanceState.containsKey(SELECTED_ITEM)){
			savedInstanceState.getInt(SELECTED_ITEM);
		}
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		//将当前的Fragment页的索引保存到Bundle中
		outState.putInt(SELECTED_ITEM, getActionBar().getSelectedNavigationIndex());
	}
	
	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		//创建一个Fragment对象
		Fragment fragment = new DemoFragment();
		//创建Bundle，用于向Fragment传值
		Bundle bundle = new Bundle();
		//将当前页的索引放入bundle
		bundle.putInt(DemoFragment.ARG_SECTION_NUMBER, itemPosition+1);
		fragment.setArguments(bundle);
		//获取FragmentTransaction对象
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		//用fragment替换linearlayout
		ft.replace(R.id.demo_container, fragment);
		ft.commit();
		return true;
	}

}
