package com.praveen.callingdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView callhistory;
	 
	 Button callDetails;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	callhistory=(TextView) findViewById(R.id.history);
	callDetails=(Button)findViewById(R.id.callDetails);
	String number="7503390877";	
	Intent intent=new Intent(Intent.ACTION_CALL);
	intent.setData(Uri.parse("tel:"+number));
	startActivity(intent);
	callhistory.setTextSize(22);
	callhistory.setText("you Calling PRAVEEN:"+number+" Number.");
	
	callDetails.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent viewDetail=new Intent(getApplicationContext(), CallDetails.class);
			viewDetail.putExtra("found", true);
			startActivity(viewDetail);
			finish();
		}
	});
	
	}
	
}
