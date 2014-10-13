package com.example.timepickerdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	TimePicker time;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 time=(TimePicker)findViewById(R.id.timePicker1);
		Button btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) {
				StringBuilder sb=new StringBuilder();
				sb.append(time.getCurrentHour()+":");
				sb.append(time.getCurrentMinute());
				
				Toast.makeText(getApplicationContext(), sb, Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
