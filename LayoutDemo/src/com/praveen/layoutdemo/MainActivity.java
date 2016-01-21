package com.praveen.layoutdemo;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends Activity{

	WebView webView;
	String url="http://google.co.in";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView=(WebView)findViewById(R.id.webview);
		webView.getSettings().setJavaScriptEnabled(true);
		  String customHtml = "<html><body><h1>Hello,WebView </h1> "
		  		+ "<br><br>"
		  		+ "<input type='text' name='name'> <br>"
		  		+ "<button onclick='WebAppInterface.showToast()'>Go</body></html>";
		  
		  
		   webView.loadData(customHtml, "text/html", "UTF-8");
		   
		  
		
	}

	

}
