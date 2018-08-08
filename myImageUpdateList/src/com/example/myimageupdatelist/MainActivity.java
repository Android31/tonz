package com.example.myimageupdatelist;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	ListView lv;
	ArrayList<Person> list=new ArrayList<Person>();
	MyAdapter adapter;
	private Uri uriImage;
	private String name;
	AdapterView.AdapterContextMenuInfo info;
	AlertDialog.Builder builder;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder=new AlertDialog.Builder(this); 
        
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.adapter=new MyAdapter(this,list);
        this.lv.setAdapter(adapter);
        this.registerForContextMenu(lv);
    
    
    }


    
    
    @Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
    	int id=item.getItemId();
    	switch(id){
    	case R.id.update://update selected person
    		Intent intent=new Intent(this,AddItem.class);
    		uriImage=list.get(info.position).getImage();
    		name=list.get(info.position).getName();
    		intent.putExtra("image", uriImage);
    		intent.putExtra("name", name);
    		this.startActivityForResult(intent, 2);  //req code 2
    		break;
    		
    	case R.id.delete://delete selected person
    		builder.setTitle("Message");
    		builder.setMessage("Do you really want to delete?");
    		builder.setPositiveButton("Yes", this);
    		builder.setNegativeButton("No", this);
    		
    		AlertDialog dialog=builder.create();
    		dialog.show();
    		
    		
    	}
    	
		return super.onContextItemSelected(item);
	}




	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.contextmenu, menu);
		
		info=(AdapterContextMenuInfo) menuInfo;
		String title=list.get(info.position).getName();
		menu.setHeaderTitle(title);
	}




	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent=new Intent(this,AddItem.class);
		this.startActivityForResult(intent, 1);//
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==Activity.RESULT_OK){
			if(requestCode==1){ //add new person
				Bundle b=data.getExtras();
				uriImage=b.getParcelable("image");
				name=b.getString("name");
				list.add(new Person(uriImage,name));
				adapter.notifyDataSetChanged();
			}
			if(requestCode==2){ //update new person
				Bundle b=data.getExtras();
				uriImage=b.getParcelable("image");
				name=b.getString("name");
				list.set(info.position,new Person(uriImage,name));
				adapter.notifyDataSetChanged();
				Toast.makeText(this, "Person Updated", Toast.LENGTH_SHORT).show();
			}
		}
	}




	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE://delete selected
			list.remove(info.position);
    		adapter.notifyDataSetChanged();
			break;
		case DialogInterface.BUTTON_NEGATIVE://do not delete
			arg0.dismiss(); 
		}
		 
	}
}
