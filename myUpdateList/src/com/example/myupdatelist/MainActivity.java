package com.example.myupdatelist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	ListView Iv;

	ArrayList<String> list=new ArrayList<String>();
	ArrayAdapter<String> adapter;
	AlertDialog.Builder builder;
	AlertDialog dialog;
	EditText txtName;
	AdapterView.AdapterContextMenuInfo info;
	//create a safeflag
	String saveType="add";
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instantiate
        this.Iv=(ListView) findViewById(R.id.listView1);
        this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.Iv.setAdapter(adapter);
        this.txtName=new EditText(this);
        this.txtName.setHint("Enter String");
        this.builder=new AlertDialog.Builder(this);
        this.builder.setTitle("New Item");
        this.builder.setView(txtName);
        this.builder.setPositiveButton("OK", this);
        this.builder.setNegativeButton("CANCEL", this);
        this.dialog=this.builder.create();
        
        this.registerForContextMenu(Iv);
    }


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	dialog.show();
    	
    	
    	
		return super.onOptionsItemSelected(item);
	}
    


	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int id=item.getItemId();
		switch(id){
		case R.id.delete:
			this.list.remove(this.info.position);
			this.adapter.notifyDataSetChanged();
			
			break;
		case R.id.update:
			this.saveType="edit";
			String name=this.list.get(this.info.position);
			this.txtName.setText(name);
			this.dialog.show();
			
			
		
		}
		return super.onContextItemSelected(item);
	}

//create and display context menu
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		getMenuInflater().inflate(R.menu.itemmenu, menu);
		this.info=(AdapterContextMenuInfo) menuInfo; 
		menu.setHeaderTitle(this.list.get(this.info.position));
		super.onCreateContextMenu(menu, v, menuInfo);
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		//assign button
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE:
			String name=this.txtName.getText().toString();
			if(this.saveType=="add")
				this.list.add(name);
			else
				this.list.set(this.info.position, name);
			
			//this.list.add(name);
			//refresh
			this.adapter.notifyDataSetChanged(); 
			this.saveType="add";
			
			//	Toast.makeText(this, name, Toast.LENGTH_SHORT).show();		
		//	break;
		case DialogInterface.BUTTON_NEGATIVE:
			arg0.dismiss();	
		}
		this.txtName.setText("");
	}
   
}
