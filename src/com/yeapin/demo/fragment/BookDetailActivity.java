package com.yeapin.demo.fragment;

import com.yeapin.androidproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * 图书详情页面
 * 
 * @author Jet 2016年3月17日
 */
public class BookDetailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		if (savedInstanceState == null) {
			//为Fragment准备数据
			Bundle args = new Bundle();
			args.putInt(BookDetailFragment.ITEM_ID, getIntent().getIntExtra(BookDetailFragment.ITEM_ID, 0));
			BookDetailFragment fragment = new BookDetailFragment();
			//向Fragment传递数据
			fragment.setArguments(args);
			getFragmentManager().beginTransaction().add(R.id.detail_container, fragment).commit();
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			Intent intent = new Intent(this,BookActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
