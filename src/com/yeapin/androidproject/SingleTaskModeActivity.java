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
 * SingleTask模式
 * 
 * @author Jet 2016年3月10日
 */
public class SingleTaskModeActivity extends Activity {
	private Button singleTaskBtn1;
	private Button singleTaskBtn2;
	private TextView singleTaskText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_task_mode);
		singleTaskBtn1 = (Button) findViewById(R.id.singleTaskBtn1);
		singleTaskBtn2 = (Button) findViewById(R.id.singleTaskBtn2);
		singleTaskText = (TextView) findViewById(R.id.singleTaskText);
		singleTaskText.setText("Activity:" + this.toString() + "\n" + "TASK:" + this.getTaskId());
		// 跳回自己
		singleTaskBtn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTaskModeActivity.this, SingleTaskModeActivity.class);
				SingleTaskModeActivity.this.startActivity(intent);
			}
		});
		// 跳转至WorldActivity
		singleTaskBtn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTaskModeActivity.this, WorldActivity.class);
				SingleTaskModeActivity.this.startActivity(intent);
			}
		});
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.d("SingleTaskModeActivity", "onStop---");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SingleTaskModeActivity", "onDestroy---");

	}

}
