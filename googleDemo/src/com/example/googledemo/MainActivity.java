package com.example.googledemo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements LocationListener{

	GoogleMap googleMap;
	double latitude;
	double longitude;
	LocationManager locationManager;
	Marker myMarker;
	static LatLng MYLOCATION;
	MarkerOptions markerOption;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		googleMap=((MapFragment)getFragmentManager().findFragmentById(R.id.fragment1)).getMap();
		
		
		locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,  this);
		markerOption=new MarkerOptions();
		//googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//		    Marker dwarka = googleMap.addMarker(new MarkerOptions().position(DWARKA).title("Dewendra").snippet("Dewendra is here").icon(BitmapDescriptorFactory
//		            .fromResource(R.drawable.ic_launcher)));

		//    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DELHI, 15));

		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		latitude=location.getLatitude();
		longitude=location.getLongitude();
		System.out.println("LATITUDE : "+String.valueOf(latitude)+ ", LONGITUDE :"+String.valueOf(longitude) );
		MYLOCATION=new LatLng(latitude, longitude);
		myMarker = googleMap.addMarker(markerOption.position(MYLOCATION).title("You").snippet("You are here"));
			 // googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		
			  googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MYLOCATION, 15));
			  myMarker.setDraggable(true);

			}
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}
}
