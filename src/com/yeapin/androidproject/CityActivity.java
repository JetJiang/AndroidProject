package com.yeapin.androidproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CityActivity extends Activity {
	private RadioGroup group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city);
		group = (RadioGroup) findViewById(R.id.city_group);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				String text = getRadioText(checkedId);
				Intent intent = getIntent();
				intent.putExtra("name", text);
				CityActivity.this.setResult(1, intent);
				CityActivity.this.finish();
			}

			
		});
	}
	private String getRadioText(int checkedId) {
		RadioButton radioButton = (RadioButton) findViewById(checkedId);
		return radioButton.getText().toString(); 
	}
	
	

}
