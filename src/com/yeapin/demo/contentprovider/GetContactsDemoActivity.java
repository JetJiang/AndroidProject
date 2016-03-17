package com.yeapin.demo.contentprovider;

import java.util.ArrayList;

import com.yeapin.androidproject.MainActivity;
import com.yeapin.androidproject.R;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * 通过ContentProvider获取联系人
 * 
 * @author Jet 2016年3月16日
 */
public class GetContactsDemoActivity extends Activity {
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<ArrayList<String>> details = new ArrayList<ArrayList<String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_contacts_demo);
	}

	/**
	 * 查询电话
	 * 
	 * @param v
	 */
	public void search(View v) {
		getPhonesList();
		showExpandableList();
	}
	/**
	 * 列表显示
	 */
	private void showExpandableList() {
		View dialog = getLayoutInflater().inflate(R.layout.contacts_expandlist, null);
		ExpandableListView listView = (ExpandableListView) dialog.findViewById(R.id.contacts_list);
		ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				return true;
			}

			@Override
			public boolean hasStableIds() {
				return true;
			}

			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
				TextView textView = getTextView();
				textView.setText(names.get(groupPosition).toString());
				return textView;
			}

			@Override
			public long getGroupId(int groupPosition) {
				return groupPosition;
			}

			@Override
			public int getGroupCount() {
				return names.size();
			}

			@Override
			public Object getGroup(int groupPosition) {
				return names.get(groupPosition);
			}

			@Override
			public int getChildrenCount(int groupPosition) {
				return details.get(groupPosition).size();
			}

			@Override
			public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
					ViewGroup parent) {
				TextView textView = getTextView();
				textView.setText(getChild(groupPosition, childPosition).toString());
				return textView;
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}

			@Override
			public Object getChild(int groupPosition, int childPosition) {
				return details.get(groupPosition).get(childPosition);
			}
		};
		listView.setAdapter(adapter);
		//对话框显示查询结果
		new AlertDialog.Builder(GetContactsDemoActivity.this).setView(dialog).setPositiveButton("OK", null).show();
	}
	/**
	 * 获取电话列表
	 */
	private void getPhonesList() {
		Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while (cursor.moveToNext()) {
			// 获取联系人ID
			String contactID = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			// 获取联系人姓名
			String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			names.add(name);
			// 电话游标
			Cursor phoneCursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactID, null, null);
			ArrayList<String> detail = new ArrayList<>();
			// 遍历查询结果，获取该联系人的多个电话号码
			while (phoneCursor.moveToNext()) {
				String phoneNumber = phoneCursor
						.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				detail.add("电话号码：" + phoneNumber);
			}
			phoneCursor.close();
			details.add(detail);
		}
		cursor.close();
	}

	private TextView getTextView() {
		TextView textView = new TextView(GetContactsDemoActivity.this);
		LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
		textView.setLayoutParams(lp);
		textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		textView.setPadding(60, 0, 0, 0);
		textView.setTextSize(20);
		return textView;
	}
}
