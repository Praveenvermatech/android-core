package com.ncr.dna.splashActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ncr.dna.ncrdna.R;
import com.ncr.dna.ncrdna.StartActivity;

public class SplashActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash_screen);
		
		Thread timer = new Thread(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					sleep(2000);
					finish();
					startActivity(new Intent(getApplicationContext(), StartActivity.class));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		};
		
		timer.start();
		
	}
	
	
}
