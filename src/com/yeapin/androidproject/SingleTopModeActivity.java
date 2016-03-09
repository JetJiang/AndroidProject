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
 * SingleTop模式
 * 
 * @author Jet 2016年3月9日
 */
public class SingleTopModeActivity extends Activity {
	private Button singleBtn;
	private TextView singleText;
	private Button singleSelfBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_top_mode);
		singleBtn = (Button) findViewById(R.id.singleModeBtn);
		singleSelfBtn = (Button) findViewById(R.id.singleSelfBtn);
		singleText = (TextView) findViewById(R.id.singleModeText);
		singleText.setText("Activity:" + this.toString() + "\n" + "TaskID:" + this.getTaskId());
		singleSelfBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTopModeActivity.this,SingleTopModeActivity.class);
				SingleTopModeActivity.this.startActivity(intent);
			}
		});
		singleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTopModeActivity.this, WorldActivity.class);
				SingleTopModeActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("SingleTopModeActivity", "onStop---");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SingleTopModeActivity", "onDestroy");
	}
}
