package com.example.imagelist;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
	Context context;
	ArrayList<ItemClass> list;
	LayoutInflater inflater;
	
	

	public ItemAdapter(Context context, ArrayList<ItemClass> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0); 
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ItemView itv=null;
		if(arg1==null){
			arg1=inflater.inflate(R.layout.itemlayout, null);
			itv=new ItemView();
			itv.iv=(ImageView) arg1.findViewById(R.id.imageView1);
			itv.name=(TextView) arg1.findViewById(R.id.textView1);
			itv.yearlevel=(TextView) arg1.findViewById(R.id.textView2);
			arg1.setTag(itv);
		}
		else itv=(ItemView) arg1.getTag();
			itv.iv.setImageResource(list.get(arg0).getImage());
			itv.name.setText(list.get(arg0).getName());
			itv.yearlevel.setText(list.get(arg0).getYearlevel());	
		return arg1;
	}

	static class ItemView{
		ImageView iv;
		TextView name,yearlevel;
		
	}
	
}
