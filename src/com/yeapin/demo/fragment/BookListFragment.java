package com.yeapin.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 图书列表Fragment
 * 
 * @author Jet 2016年3月17日
 */
public class BookListFragment extends ListFragment {
	private Callbacks mCallBack;
	public static ArrayList<BookEntity> bookList;

	// 定义一个接口，该Fragment所在的Activity需要实现该接口
	// 该Fragment将通过该接口与所在的Activity交互
	public interface Callbacks {
		public void onItemSelected(Integer id);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setValueForBooklist();
		List<String> bookNames = new ArrayList<>();
		for (int i = 0;i<bookList.size();i++) {
			bookNames.add(bookList.get(i).getTitle());
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
				android.R.id.text1, bookNames);
		setListAdapter(adapter);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// 如果Activity没有实现Callbacks接口，抛出异常
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("BookListFragment所在的Activity必须实现Callbacks接口");
		}
		mCallBack = (Callbacks) activity;
	}

	// 当该Fragment从它所属的Activity中被删除时执行此方法
	@Override
	public void onDetach() {
		super.onDetach();
		mCallBack = null;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mCallBack.onItemSelected(bookList.get(position).getId());
	}
	/**
	 * 设置ListView的选中状态
	 * @param itemClick
	 */
	public void setActivateOnItemClick(boolean itemClick) {
		getListView().setChoiceMode(itemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
	}

	private void setValueForBooklist() {
		bookList = new ArrayList<>();
		bookList.add(new BookEntity(1, "平凡的世界", "这是一个平凡的人改变命运的故事"));
		bookList.add(new BookEntity(2, "三体", "一本让你重新认识宇宙、人生的书"));
		bookList.add(new BookEntity(3, "遥远的救世主", "亲情、友情、爱情、创业、因缘、因果在此体现的淋漓尽致"));

	}

}
