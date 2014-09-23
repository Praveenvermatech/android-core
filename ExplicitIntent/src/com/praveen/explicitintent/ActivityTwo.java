package com.praveen.explicitintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends Activity {

	
	TextView mesgView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_two);
		
		mesgView=(TextView) findViewById(R.id.messageView);
		
	Intent intent=getIntent();
	String msg=(String) intent.getCharSequenceExtra("message");
	Toast.makeText(getApplicationContext(), msg	, Toast.LENGTH_LONG).show();
	mesgView.setText(msg);
	}


}
