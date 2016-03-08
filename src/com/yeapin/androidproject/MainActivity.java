package com.yeapin.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * Activity生命周期
 * 总结Activity有四种状态
 * 1、运行态
 * 2、暂停态——失去焦点，但部分可见。例如出现对话框风格的Activity
 * 3、停止态——失去焦点，完全不可见
 * 4、销毁态
 * @author Jet
 * 2016年3月8日
 */
public class MainActivity extends Activity {
	private Button newActivityBtn;
	private Button dialogActivityBtn;
	private Button exitBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("MainActivity", "onCreate---");
		setContentView(R.layout.activity_main);
		newActivityBtn = (Button) findViewById(R.id.newActivityBtn);
		dialogActivityBtn = (Button) findViewById(R.id.dialogActivityBtn);
		exitBtn = (Button) findViewById(R.id.exitBtn);
		//跳转新的Activity
		newActivityBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,HelloActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		//弹出对话框样式的Activity
		dialogActivityBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent (MainActivity.this,HelloActivity.class);
				MainActivity.this.startActivity(intent);
			}
		});
		//退出程序
		exitBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MainActivity.this.finish();
			}
		});
	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("MainActivity", "onStart---");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("MainActivity", "onRestart");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("MainActivity", "onResume---");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("MainActivity", "onPause");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("MainActivity", "onStop---");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("MainActivity", "onDestory---");
	}
}
