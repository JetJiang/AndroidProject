package com.yeapin.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/**
 * 选择城市
 * 模拟startActivityForResult
 * @author Jet
 * 2016年3月15日
 */
public class HometownActivity extends Activity {
	
	private TextView cityText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hometown);
		cityText = (TextView) findViewById(R.id.cityText);
	}
	public void selectCity(View v){
		Intent intent = new Intent(HometownActivity.this,CityActivity.class);
		HometownActivity.this.startActivityForResult(intent, 0);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if(resultCode==1){
			Bundle data = intent.getExtras();
			String text = data.getString("name");
			cityText.setText(text);
		}
	}
}
