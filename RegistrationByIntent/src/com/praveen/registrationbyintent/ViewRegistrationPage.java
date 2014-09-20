package com.praveen.registrationbyintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class ViewRegistrationPage extends Activity {

	
	TextView id, name,contact,email,state,city;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_registration_page);
		
		id=(TextView) findViewById(R.id.view_id);
		name=(TextView) findViewById(R.id.view_name);
		contact=(TextView) findViewById(R.id.view_contact);
		email=(TextView) findViewById(R.id.view_email);
		state=(TextView) findViewById(R.id.view_state);
		city=(TextView) findViewById(R.id.view_city);
		
		Intent intent=getIntent();
		id.setText(intent.getStringExtra("id"));
		name.setText(intent.getStringExtra("name"));
		contact.setText(intent.getStringExtra("contact"));
		email.setText(intent.getStringExtra("email"));
		state.setText(intent.getStringExtra("state"));
		city.setText(intent.getStringExtra("city"));
		
		
	}

	

}
