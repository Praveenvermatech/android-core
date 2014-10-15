package com.tabkids.student.typeIt;

import java.util.ArrayList;
import java.util.List;

import com.pensar.tabkids.student.typeIt.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);
       
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		PackageManager pm = this.getPackageManager();

		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);

		ArrayList<ResolveInfo> list = (ArrayList<ResolveInfo>) pm
				.queryIntentActivities(intent,
						PackageManager.PERMISSION_GRANTED);
		Context context = this;
		PackageManager packageManager = context.getPackageManager();
		;
		List<PackageInfo> installedPackageList = packageManager
				.getInstalledPackages(0);
		if (null != installedPackageList) {
			int i=1;
			for (PackageInfo applicationInfo : installedPackageList) {
				
				if (applicationInfo.packageName.indexOf("com.gss") != -1) {
					textView.append(i++ +": "+ applicationInfo.packageName + "\n");
					
					System.out.println("Application List: "+ applicationInfo.packageName);

					// Delete Application...

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					 Intent intent2 = new Intent(Intent.ACTION_DELETE);
					 intent2.setData(Uri.parse("package:"+applicationInfo.packageName));
					 startActivity(intent2);
					 
				}

			}
			textView.setMovementMethod(ScrollingMovementMethod.getInstance());
			Toast.makeText(context, "No activity found...", Toast.LENGTH_LONG)
					.show();

		}

	}
}