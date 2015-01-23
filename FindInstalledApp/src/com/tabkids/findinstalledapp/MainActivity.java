package com.tabkids.findinstalledapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String file_seperator = System.getProperty("file.separator");

	private static String base_recource_folder = "/mnt/sdcard/tabkids/resources/student/";
	private static String base_activity_resource_folder = base_recource_folder +  "activityData" + file_seperator;
	File existFolder=null;
	TextView textView;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
	    button=(Button)findViewById(R.id.button_exit);   
	    button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
	}

	public void getDataFromConfigFile(File path) {
		
		BufferedReader in;
		String line;
		try {
			in = new BufferedReader(new FileReader(path+".properties"));
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		while((line=in.readLine()) != null) {
            System.out.println(line);
        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		existFolder=new File(base_activity_resource_folder);
		System.out.println(existFolder);
		File[] list=existFolder.listFiles();
		System.out.println("Total number of Activity data List: "+list.length +"\n");
		for (File f: list){
            String name = f.getName();
            File path=new File(base_activity_resource_folder+name+file_seperator+"config"+file_seperator+name);
            //System.out.println("PATH :"+path);
            getDataFromConfigFile(path);
            
//            System.out.println("\n " +name );
        }
			
		
		
		
		
		PackageManager pm = this.getPackageManager();

		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);

		Context context = this;
		PackageManager packageManager = context.getPackageManager();
		
		List<PackageInfo> installedPackageList = packageManager
				.getInstalledPackages(0);
		if (null != installedPackageList) {
			int i=1;
			for (PackageInfo applicationInfo : installedPackageList) {
				
				if (applicationInfo.packageName.indexOf("com.pensar.tabkids.student") != -1) {
					
					String appName=(String) applicationInfo.packageName.substring(27);
					System.out.println(appName);
					textView.append(i++ +": "+ appName + "\n");
					
					//System.out.println("Application List: "+ applicationInfo.packageName);

				}

			}
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			

		}

	}
}