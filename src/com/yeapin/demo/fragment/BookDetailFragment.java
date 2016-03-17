package com.yeapin.demo.fragment;

import com.yeapin.androidproject.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 图书详情Fragment
 * @author Jet
 * 2016年3月17日
 */
public class BookDetailFragment extends Fragment{
	public static final String ITEM_ID="item_id";
	private BookEntity book;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(getArguments().containsKey(ITEM_ID)){
			book = BookListFragment.bookList.get(getArguments().getInt(ITEM_ID)-1);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_book_detail, container,false);
		if(book!=null){
			TextView titleView = (TextView) rootView.findViewById(R.id.book_title_text);
			titleView.setText(book.getTitle());
			TextView descView = (TextView) rootView.findViewById(R.id.book_desc_text);
			descView.setText(book.getDesc());
		}
		return rootView;
	}
}
