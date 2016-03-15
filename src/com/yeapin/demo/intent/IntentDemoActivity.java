package com.yeapin.demo.intent;

import com.yeapin.androidproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * 显式Intent——找“王思聪”
 * 隐式Intent——找高富帅
 * @author Jet
 * 2016年3月15日
 */
public class IntentDemoActivity extends Activity {
	public static String INTENT_DEMO_ACTION = "com.yeapin.demo.intent.action.DemoAction";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_demo);
	}
	
	public void jumpIntoDemo2(View v){
		Intent intent = new Intent();
		//为intent设置Action属性
		intent.setAction(IntentDemoActivity.INTENT_DEMO_ACTION);
		startActivity(intent);
	}

}
