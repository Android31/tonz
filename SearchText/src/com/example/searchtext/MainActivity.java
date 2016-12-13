package com.example.searchtext;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	EditText txtSearch;
	ListView lv;
	ArrayList<String> list=new ArrayList<String>();
	ArrayList<String> source= new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtSearch=(EditText) this.findViewById(R.id.editText1);
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.lv.setAdapter(adapter);
        this.source.add("a");
        this.source.add("b");
        this.source.add("c");
        this.source.add("d");
        this.source.add("ab");
        this.source.add("bob");
        this.source.add("car");
        this.source.add("dog");
        this.source.add("al");
        this.source.add("boy");
        this.source.add("carrot");
        this.source.add("dust");
        this.source.add("alley");
        this.source.add("bust");
        this.source.add("cat");
        this.source.add("dump");
        this.source.add("all");
        
        this.txtSearch.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				list.clear();
				Pattern p=Pattern.compile(arg0.toString());
				for(int i=0;i<source.size();i++){
					Matcher m=p.matcher(source.get(i));
						if(m.find()){
							list.add(source.get(i));
							adapter.notifyDataSetChanged();
							
						}
					
				}
				
				
				
			}});
        
    }   
}
