package com.yeapin.demo.contentprovider;

import com.yeapin.androidproject.R;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/**
 * 对自定义ContentProvider进行操作
 * @author Jet
 * 2016年3月16日
 */
public class ContentProviderDemoActivity extends Activity {
	ContentResolver contentResolver;
	Uri uri = Uri.parse("content://com.demo.providers.firstprovider/");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content_provider_demo);
		contentResolver = getContentResolver();
	}
	public void add(View v){
		ContentValues values = new ContentValues();
		values.put("name","yeapin");
		//返回insert的返回值
		Uri newUri = contentResolver.insert(uri, values);
		Toast.makeText(this, "insert uri:"+newUri, Toast.LENGTH_SHORT).show();
		
	}
	public void del(View v){
		int count = contentResolver.delete(uri, "demo-delete", null);
		Toast.makeText(this, "delete count:"+count, Toast.LENGTH_LONG).show();
	}
	public void modify(View v){
		ContentValues values = new ContentValues();
		values.put("name","yeapin");
		//返回insert的返回值
		int count = contentResolver.update(uri, values, "demo-update", null);
		Toast.makeText(this, "update count:"+count, Toast.LENGTH_SHORT).show();
	}
	public void query(View v){
		Cursor c = contentResolver.query(uri, null, "demo-query", null, null);
		Toast.makeText(this, "query"+c, Toast.LENGTH_LONG).show();
	}
}
