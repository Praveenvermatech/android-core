package com.praveen.emailservicedemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button send;
	EditText editTo,editSubject,editMessage ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		send=(Button)findViewById(R.id.send);
		editTo=(EditText)findViewById(R.id.editTo);
		editSubject=(EditText)findViewById(R.id.editSubject);
		editMessage=(EditText)findViewById(R.id.editMessage);
		
		send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent emailIntent=new Intent(Intent.ACTION_SEND);
				emailIntent.setData(Uri.parse("mailto:"));
				emailIntent.putExtra(Intent.EXTRA_EMAIL, editTo.getText().toString());
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, editSubject.getText().toString());
				emailIntent.putExtra(Intent.EXTRA_TEXT, editMessage.getText().toString());
				
				emailIntent.setType("message/rfc822");
				startActivity(Intent.createChooser(emailIntent, "Select Email Client "));
			}
		});
		
		
		
		
		
	}


}
