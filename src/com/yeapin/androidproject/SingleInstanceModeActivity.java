package com.yeapin.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * singleInstance模式
 * @author Jet
 * 2016年3月10日
 */
public class SingleInstanceModeActivity extends Activity {
	private Button selfBtn;
	private Button worldBtn;
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_instance_mode);
		selfBtn = (Button) findViewById(R.id.singleInstanceBtn1);
		worldBtn = (Button) findViewById(R.id.singleInstanceBtn2);
		textView = (TextView) findViewById(R.id.singleInstanceText);
		textView.setText("Activity:"+this.toString()+"\n"+"TaskID:"+this.getTaskId());
		selfBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleInstanceModeActivity.this,SingleInstanceModeActivity.class);
				SingleInstanceModeActivity.this.startActivity(intent);
			}
		});
		worldBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleInstanceModeActivity.this,WorldActivity.class);
				SingleInstanceModeActivity.this.startActivity(intent);
			}
		});
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("SingleInstanceModeActivity", "onStop---");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SingleInstanceModeActivity", "onDestroy---");
	}
}
