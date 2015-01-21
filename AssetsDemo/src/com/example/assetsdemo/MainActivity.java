package com.example.assetsdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView msg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

Resources resources = this.getResources();
AssetManager assetManager = resources.getAssets();
msg=(TextView)findViewById(R.id.textView1);
// Read from the /assets directory
try {
    InputStream inputStream = assetManager.open("myProperties.properties");
    Properties properties = new Properties();
    properties.load(inputStream);
    System.out.println("++++++++++++++++++The properties are now loaded+++++++++++++++++++");
    System.out.println("properties: " + properties);
    String name=properties.getProperty("name");
    String url=properties.getProperty("url");
    msg.setText("URL :"+url+ "\n\n Name :"+name);
    
    System.out.println("+++++++++Name :"+name+", URL :"+url );
} catch (IOException e) {
    System.out.println(e);
    e.printStackTrace();
}

		
		
	}

	
}
