package com.yeapin.androidproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
/**
 * 标准模式启动Activity
 * @author Jet
 * 2016年3月9日
 */
public class StandardModeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_standard_mode);
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("StandardActivity", "onStop---");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("StandardActivity", "onDestroy");
	}
}
