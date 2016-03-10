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
 * 正常模式的Activity
 * @author Jet
 * 2016年3月9日
 */
public class WorldActivity extends Activity {
	private Button worldBtn;
	private Button singleTaskBtn;
	private Button singleInstanceBtn;
	private TextView worldText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_world);
		worldBtn = (Button) findViewById(R.id.worldBtn);
		singleTaskBtn = (Button) findViewById(R.id.singleTaskBtn);
		singleInstanceBtn = (Button) findViewById(R.id.singleInstanceBtn);
		worldText = (TextView) findViewById(R.id.worldText);
		worldText.setText("Activity:"+this.toString()+"\n"+"TaskID:"+this.getTaskId());
		worldBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WorldActivity.this,SingleTopModeActivity.class);
				WorldActivity.this.startActivity(intent);
			}
		});
		singleTaskBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WorldActivity.this,SingleTaskModeActivity.class);
				WorldActivity.this.startActivity(intent);
			}
		});
		singleInstanceBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WorldActivity.this,SingleInstanceModeActivity.class);
				WorldActivity.this.startActivity(intent);
			}
		});
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("WorldActivity", "onStop---");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("WorldActivity", "onDestroy");
	}

}
