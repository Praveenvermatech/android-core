package com.praveen.registrationbyintent;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewRegistrationPage extends Activity {

	
	TextView id, name,contact,email,state,city;
	ImageView imageView;
	
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
		imageView = (ImageView) findViewById(R.id.emp_image);
		Intent intent=getIntent();
		id.setText(intent.getStringExtra("id"));
		name.setText(intent.getStringExtra("name"));
		contact.setText(intent.getStringExtra("contact"));
		email.setText(intent.getStringExtra("email"));
		state.setText(intent.getStringExtra("state"));
		city.setText(intent.getStringExtra("city"));
		
		Bundle bundle=getIntent().getExtras();
		byte[] byteArray = bundle.getByteArray("imageList");
		System.out.println("image bitmap :"+byteArray);

		Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0,byteArray.length);
		imageView.setImageBitmap(bmp);
		
		
	}

	

}
