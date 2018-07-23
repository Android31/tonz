package com.example.imagelist;

import java.util.ArrayList;

import android.os.Bundle;
import android.widget.ListView;
import android.app.Activity;


public class MainActivity extends Activity {
	ListView Iv;
	ArrayList<ItemClass> list=new ArrayList<ItemClass>();
	ItemAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //populate
        list.add(new ItemClass(R.drawable.img1,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img2,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img3,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img4,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img5,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img6,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img7,"Alino, Israel","BSIT-4"));
        list.add(new ItemClass(R.drawable.img8,"Alino, Israel","BSIT-4"));
        adapter=new ItemAdapter(this,list);     
        this.Iv=(ListView) this.findViewById(R.id.listView1);
        this.Iv.setAdapter(adapter);
    }
 
}
