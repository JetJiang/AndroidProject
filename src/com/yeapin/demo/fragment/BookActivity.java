package com.yeapin.demo.fragment;

import com.yeapin.androidproject.R;
import com.yeapin.demo.fragment.BookListFragment.Callbacks;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

/**
 * 自适应的图书查看 结合Fragment实现
 * 
 * @author Jet 2016年3月17日
 */
public class BookActivity extends Activity implements Callbacks {
	private boolean mTwoPane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 加载时会判断屏幕大小，大屏的会调用
		setContentView(R.layout.activity_book);
		if (findViewById(R.id.list_fragment) != null) {
			// 实际加载了R.layout.activity_book_twopane
			mTwoPane = true;
			BookListFragment booklistFragment = (BookListFragment) getFragmentManager()
					.findFragmentById(R.id.list_fragment);
			//设置List的选中状态
			booklistFragment.setActivateOnItemClick(true);
		}
	}

	@Override
	public void onItemSelected(Integer id) {
		if (mTwoPane) {
			// 创建Bundle准备向Fragment传数据
			Bundle arguments = new Bundle();
			arguments.putInt(BookDetailFragment.ITEM_ID, id);
			// 创建详情页Fragment
			BookDetailFragment detailFragment = new BookDetailFragment();
			detailFragment.setArguments(arguments);
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.detail_fragment, detailFragment);
			ft.commit();
		} else {
			//小屏幕直接跳转新的Activity
			Intent intent = new Intent(this, BookDetailActivity.class);
			intent.putExtra(BookDetailFragment.ITEM_ID, id);
			startActivity(intent);
		}
	}
}
