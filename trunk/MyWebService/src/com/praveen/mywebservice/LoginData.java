package com.praveen.mywebservice;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class LoginData {

	LoginParser loginParser;
	InputStream inputStream;
	private Context context;
	String url;
	
	public LoginData(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
	}
	
	public void getData(String name, String email) {
		
		getPropertiesData();
		List<NameValuePair> listData=new ArrayList<NameValuePair>();
		listData.add(new BasicNameValuePair("name", name));
		listData.add(new BasicNameValuePair("email",email));
		loginParser.loginParser(listData,url);
		
		
	}
	
	public void getPropertiesData() {
		
		
		Resources resources =context.getResources();
		AssetManager assetManager = resources.getAssets();
		try {
			inputStream = assetManager.open("myData.properties");
		    Properties properties = new Properties();
		    properties.load(inputStream);
		    url=properties.getProperty("httpUrl");
			System.out.println(url);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
