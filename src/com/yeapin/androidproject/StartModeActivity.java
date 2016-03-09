package com.yeapin.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
/**
 * Activity启动的四种模式
 * --Activity的加载模式，负责管理实例化、加载Activity的方式，并控制Activity与Task之间的加载关系
 * -standard
 * -singleTop
 * -singleTask
 * -singleInstance
 * @author Jet
 * 2016年3月9日
 */
public class StartModeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_mode);
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("StartModeActivity", "onStop---");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("StartModeActivity", "onDestroy");
	}

}
