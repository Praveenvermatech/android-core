package com.example.assetsdemo.utils;

import java.util.Properties;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;


public class AssetsUtils {

	private final JSONObject dataToPost;
	private final String urlToPost;
	
	
	
	
	public AssetsUtils(JSONObject dataToPost, String urlToCall){
		this.dataToPost = dataToPost;
		this.urlToPost = urlToCall;
		
		
	}
	
	public void postDataToServer(String urlToCall,JSONObject dataToPost){
		
	 		HttpPost postRequest = new HttpPost(urlToCall);
	 		
	 		UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity();
	 		postRequest.setEntity(encodedFormEntity);
	 		JSONObject responseFromServer = executeRequest(postRequest);
	 		if(null != responseFromServer){
				if(!responseFromServer.optString("status", "fail").equals("success") && retry){
					retry = false;
					postNormalFormToServer(urlToCall, dataToPost);
	 		
		
	}
	
}
