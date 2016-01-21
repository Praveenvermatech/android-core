package com.praveen.changebackground;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	Button imageButton, redButton, blueButton;
	RelativeLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageButton=(Button) findViewById(R.id.image_button);
		redButton=(Button)findViewById(R.id.red_Colour_button);
		blueButton=(Button)findViewById(R.id.blueColour_button);
		layout=(RelativeLayout) findViewById(R.id.layout);	
		
		
		imageButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				
				layout.setBackgroundResource(R.drawable.a10);
				
			}
		});
		
		redButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
					layout.setBackgroundColor(Color.RED);
				
			}
				});
		
		blueButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
					layout.setBackgroundColor(Color.parseColor("#8769DA"));
				
			}
				});
		
		
		
	}

	

}
