package com.example.mysqlitedb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	public Button addButton;
	Button removeButton;
	Button viewButton;
	Button editButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	addButton=(Button) findViewById(R.id.insert);	
	removeButton=(Button) findViewById(R.id.delete);
	viewButton=(Button) findViewById(R.id.view);
	editButton=(Button) findViewById(R.id.edit);
		
	}
@Override
protected void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
	
	addButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent addIntent=new Intent(getApplicationContext(), Add_ProductActivity.class);
			startActivity(addIntent);
		}
	});
	
	
}
	
}
