package com.praveen.registrationbyintent;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	EditText id, name,contact,email,state,city;
	Button resetButton, submitButton;
	ImageView image;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		id=(EditText) findViewById(R.id.edit_id);
		name=(EditText) findViewById(R.id.edit_name);
		contact=(EditText) findViewById(R.id.edit_contact);
		email=(EditText) findViewById(R.id.edit_email);
		state=(EditText) findViewById(R.id.edit_state);
		city=(EditText) findViewById(R.id.edit_city);
		image=(ImageView)findViewById(R.id.edit_image);
		resetButton=(Button) findViewById(R.id.reset);
		submitButton=(Button) findViewById(R.id.submit);
		image.setBackgroundResource(R.drawable.praveen);
		
		resetButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				id.setText("");
				name.setText("");
				contact.setText("");
				email.setText("");
				state.setText("");
				city.setText("");
				
			}
		});
		
		
		submitButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, ViewRegistrationPage.class);
				
			// Bitmap class using for image.
				
				Bitmap bmp = BitmapFactory.decodeResource(getResources(),
						R.drawable.praveen);
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
				byte[] byteArray = stream.toByteArray();
				
				intent.putExtra("id", id.getText().toString());
				intent.putExtra("name", name.getText().toString());
				intent.putExtra("contact", contact.getText().toString());
				intent.putExtra("email", email.getText().toString());
				intent.putExtra("state", state.getText().toString());
				intent.putExtra("city", city.getText().toString());

				intent.putExtra("imageList", byteArray);
				startActivity(intent);
				
				
			}
		});
		
		
	}


}
