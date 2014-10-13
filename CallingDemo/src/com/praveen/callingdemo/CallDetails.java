package com.praveen.callingdemo;

import java.util.Date;

import android.os.Bundle;
import android.provider.CallLog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class CallDetails extends Activity {

	TextView callDetails;
	String details;
	Cursor managedCursor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call_details);
		
		callDetails=(TextView) findViewById(R.id.call_details);
		
		Intent intent=getIntent();
		boolean flag=intent.getBooleanExtra("found",true );
		if(flag==true) {
		details=getCallDetails(this);
		callDetails.setText(details);
		}
	}

	public static String getCallDetails(Context context) {
	    StringBuffer stringBuffer = new StringBuffer();
	    Cursor cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI,
	            null, null, null, CallLog.Calls.DATE + " DESC");
	    int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
	    int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
	    int date = cursor.getColumnIndex(CallLog.Calls.DATE);
	    int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);       
	    while (cursor.moveToNext()) {
	        String phNumber = cursor.getString(number);
	        String callType = cursor.getString(type);
	        String callDate = cursor.getString(date);
	        Date callDayTime = new Date(Long.valueOf(callDate));
	        String callDuration = cursor.getString(duration);
	        String dir = null;
	        int dircode = Integer.parseInt(callType);
	        switch (dircode) {
	        case CallLog.Calls.OUTGOING_TYPE:
	            dir = "OUTGOING";
	            break;
	        case CallLog.Calls.INCOMING_TYPE:
	            dir = "INCOMING";
	            break;

	        case CallLog.Calls.MISSED_TYPE:
	            dir = "MISSED";
	            break;
	        }
	        stringBuffer.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- "
	                + dir + " \nCall Date:--- " + callDayTime
	                + " \nCall duration in sec :--- " + callDuration);
	        stringBuffer.append("\n-----------------");
	    }
	    cursor.close();
	    return stringBuffer.toString();
	}

}
