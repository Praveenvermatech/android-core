package com.pensar.tabkids.findaspectratio;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView ScreenSize;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Display display = getWindowManager().getDefaultDisplay();
		
		
		double width = display.getWidth();
		double height = display.getHeight();
		System.out.println("Width :" + width);
		System.out.println("Height :" + height);
		ScreenSize=(TextView)findViewById(R.id.screenInfo);
		ScreenSize.append("\nDEVICE INFORMATION :\n\n");
		
		// get density....
		
		switch (getResources().getDisplayMetrics().densityDpi) {
		case DisplayMetrics.DENSITY_LOW:
		    ScreenSize.append("\nLow density.The screen density expressed as dots-per-inch :"+getResources().getDisplayMetrics().densityDpi);
		    break;
		case DisplayMetrics.DENSITY_MEDIUM:
			ScreenSize.append("\nMedium density.The screen density expressed as dots-per-inch :"+getResources().getDisplayMetrics().densityDpi);
		    break;
		case DisplayMetrics.DENSITY_HIGH:
			ScreenSize.append("\nHigh density.The screen density expressed as dots-per-inch :"+getResources().getDisplayMetrics().densityDpi);
		    break;
		case DisplayMetrics.DENSITY_XHIGH:
			ScreenSize.append("\nExtra High  density.The screen density expressed as dots-per-inch :"+getResources().getDisplayMetrics().densityDpi);
		    break;
		}
		DisplayMetrics displayMetrics=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		double X=Math.pow(width/displayMetrics.densityDpi, 2);
		double Y=Math.pow(height/displayMetrics.densityDpi, 2);
		double screenInches=Math.sqrt(X+Y);
		ScreenSize.append("\n\nScreen size(Inches) :"+screenInches);
		System.out.println("get density :"+getResources().getDisplayMetrics().density);
		
		// get Aspect ratio...
		
		double ratio = width / height;
		double bestDelta = Double.MAX_VALUE;
		int x = 0;
		int y = 0;
		

		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				double newDelta = Math.abs((double) i / (double) j - ratio);
				if (newDelta < bestDelta) {
					bestDelta = newDelta;
					x = i;
					y = j;
				}
			}
		}

		System.out.println("Closest ratio: " + x + "/" + y);
		System.out.println("Ratio        : " + ((double) x / (double) y));
		Toast.makeText(
				this,
				" Aspect Ratios of devices: (" + x + "/" + y + ")" + width
						+ " /" + height, Toast.LENGTH_LONG).show();
		
		ScreenSize.append("\n\nAspect Ratios of devices: (" + x + "/" + y + ")" + width
						+ " /" + height);;
	
		ScreenSize.append("\n\nDevice Model : "+android.os.Build.MODEL);	
		ScreenSize.append("\n\nDevice BUILD NUMBER : "+android.os.Build.DISPLAY);
		ScreenSize.append("\n\nDevice VERSION : "+Build.VERSION.RELEASE);
		ScreenSize.append("\n\nDevice VERSION.SDK : "+Build.VERSION.SDK);
		try {
		    float curBrightnessValue=android.provider.Settings.System.getInt(
		    getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
		    ScreenSize.append("\n\nDevice Current Brihtness Value : "+curBrightnessValue);
		} catch (SettingNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		super.onStart();
	}

}
