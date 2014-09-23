package com.praveen.explicitintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText message;
	Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	message=(EditText) findViewById(R.id.message);
	submit=(Button) findViewById(R.id.button);
	
	submit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			// Explicit Intent Example
			
			Intent intent=new Intent(MainActivity.this, ActivityTwo.class);
			String msg=message.getText().toString();
			intent.putExtra("message", msg);
			startActivity(intent);
		}
	});	
	
	}

	

}
