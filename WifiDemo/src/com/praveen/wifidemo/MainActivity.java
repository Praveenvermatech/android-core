package com.praveen.wifidemo;

import java.util.List;

import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.nsd.WifiP2pServiceInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	 TextView mainText;
	    WifiManager mainWifi;
	    WifiInfo info;
	    WifiReceiver receiverWifi;
	    List<ScanResult> wifiList;
	    StringBuilder sb = new StringBuilder();
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 mainText = (TextView) findViewById(R.id.mainText);
	        
	       // Initiate wifi service manager
	       mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	        
	       // Check for wifi is disabled
	       if (mainWifi.isWifiEnabled() == false)
	            {  
	                // If wifi disabled then enable it
	                Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled",
	                Toast.LENGTH_LONG).show();
	                 
	                mainWifi.setWifiEnabled(true);
	            }
	        
	       // wifi scaned value broadcast receiver
	       receiverWifi = new WifiReceiver();
	        
	       // Register broadcast receiver
	       // Broadcast receiver will automatically call when number of wifi connections changed
	       registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	       mainWifi.startScan();
	       mainText.setText("Starting Scan...");
		
	}
	 public boolean onMenuItemSelected(int featureId, MenuItem item) {
	        mainWifi.startScan();
	        mainText.setText("Starting Scan");
	        return super.onMenuItemSelected(featureId, item);
	    }
	 
	    protected void onPause() {
	        unregisterReceiver(receiverWifi);
	        super.onPause();
	    }
	 
	    protected void onResume() {
	        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
	        super.onResume();
	    }
	     
	    // Broadcast receiver class called its receive method
	    // when number of wifi connections changed
	     
	    class WifiReceiver extends BroadcastReceiver {
	         
	        // This method call when number of wifi connections changed
	        public void onReceive(Context c, Intent intent) {
	             
	            sb = new StringBuilder();
	            wifiList = mainWifi.getScanResults();
	           info= mainWifi.getConnectionInfo();
	           int infoStrength = mainWifi.getConnectionInfo().getRssi();
	           
	           int ipAddress=info.getIpAddress();
	           int MyIp3 = ipAddress/0x1000000;
	           int MyIp3mod = ipAddress%0x1000000;
	          
	           int MyIp2 = MyIp3mod/0x10000;
	           int MyIp2mod = MyIp3mod%0x10000;
	          
	           int MyIp1 = MyIp2mod/0x100;
	           int MyIp0 = MyIp2mod%0x100;
	           
	           
	            sb.append("\n        Number Of Wifi connections :"+wifiList.size()+"\n\n");
	             
	            for(int i = 0; i < wifiList.size(); i++){
	                 
	                sb.append(new Integer(i+1).toString() + ". ");
	                sb.append((wifiList.get(i)).toString()+"\n");
	                sb.append("Network Name :"+wifiList.get(i).SSID+"\n");
	                sb.append("IP Address :"+MyIp0+"."+MyIp1+"."+MyIp2+"."+MyIp3+"\n");
	                sb.append("MAC ADDRESS :"+info.getMacAddress()+"\n Strength :"+infoStrength);
	                sb.append("\n\n");
	            }
	             
	            mainText.setText(sb); 
	        }
	      
	         
	    }
	

}
