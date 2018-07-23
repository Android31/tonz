package com.example.userlogin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;


public class MainActivity extends Activity implements OnClickListener {

		//VIEW DECLARATIONS
		EditText txtUsername,pwdPassword;
		Button btnOk;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create an instance of the properties
        
        this.txtUsername=(EditText) this.findViewById(R.id.editText1);
        this.pwdPassword=(EditText) this.findViewById(0x7f080002);
        this.btnOk=(Button) this.findViewById(R.id.button1);
        
        //assign an event listener
        this.btnOk.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		String username=this.txtUsername.getText().toString();
		String password=this.pwdPassword.getText().toString();
		
		//set the default username =admin & password=user
		if(username.equals("admin") && password.equals("user")){
			Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
		}
		else{
			
			AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle("Error Login");
				builder.setMessage("Login Failed !!!");
				builder.setNeutralButton("OK", null);
			
			AlertDialog dialog=builder.create();
				dialog.show();
			
		}
	}


    
}
