package com.example.googledemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends FragmentActivity {

	GoogleMap map;
	ArrayList<LatLng> markerPointsList;
	TextView distanceDuration;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Initializing marker Point ArrayList
		markerPointsList = new ArrayList<LatLng>();
		distanceDuration = (TextView) findViewById(R.id.distance_time);
		
		map = ((MapFragment) this.getFragmentManager().findFragmentById(R.id.fragment1)).getMap();

		// Enable MyLocation in the Map
		map.setMyLocationEnabled(true);

		// Setting onclick event listener for the map
		map.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng point) {

			
				if (markerPointsList.size() > 1) {
					markerPointsList.clear();
					map.clear();
				}

				// add LatLang point in markerPointList
				markerPointsList.add(point);

				// Creating MarkerOptions in the Map
				MarkerOptions options = new MarkerOptions();

				// Set the position of the marker
				options.position(point);

				
				// start location and end location

				if (markerPointsList.size() == 1) {
					options.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
				
					map.addMarker(options).setTitle("Start here");;
				} else if (markerPointsList.size() == 2) {
					options.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_RED));
					
				
					map.addMarker(options).setTitle("End here");;
				}

				

				// Checks, whether start and end locations are captured
				if (markerPointsList.size() >= 2) {
					LatLng origin = markerPointsList.get(0);
					LatLng dest = markerPointsList.get(1);
					
					Log.d("PRAVEEN", ""+dest);
					String url = getDirectionsUrl(origin, dest);

					Simple_DownloadTask downloadTask = new Simple_DownloadTask();

					// Start downloading json data from Google Directions API
					downloadTask.execute(url);
				}

			}
		});

	}

	private String getDirectionsUrl(LatLng origin, LatLng dest) {

		// Origin 
		String str_origin = "origin=" + origin.latitude + ","+ origin.longitude;

		// Destination 
		String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
		String sensor = "sensor=false";
		String parameters = str_origin + "&" + str_dest + "&" + sensor;
		String output = "json";
		// Building the url to the web service
		String url = "https://maps.googleapis.com/maps/api/directions/"+ output + "?" + parameters;
		return url;
	}

	/** This method to download json data from url */
	private String downloadUrl(String strUrl) throws IOException {
		String data = "";
		InputStream iStream = null;
		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(strUrl);

			// Creating an http connection 
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.connect();
			iStream = urlConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					iStream));

			StringBuffer sb = new StringBuffer();

			String line = "";
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			data = sb.toString();

			br.close();

		} catch (Exception e) {
			Log.d("Exception occure downloading url", e.toString());
		} finally {
			iStream.close();
			urlConnection.disconnect();
		}
		return data;
	}

	
	private class Simple_DownloadTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... url) {
			String data = "";
			try {
				// Fetching the data from web service
				data = downloadUrl(url[0]);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			return data;
		}

		
		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			ParserTask parserTask = new ParserTask();
			parserTask.execute(result);

		}
	}

	/** A class to parse the Google Places in JSON format */
	private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

		@Override
		protected List<List<HashMap<String, String>>> doInBackground(
				String... jsonData) {

			JSONObject jObject;
			List<List<HashMap<String, String>>> routes = null;

			try {
				jObject = new JSONObject(jsonData[0]);
				DirectionsJSONParser parser = new DirectionsJSONParser();

				// Starts parsing data
				routes = parser.parse(jObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return routes;
		}

		// Executes in UI thread, after the parsing process
		@Override
		protected void onPostExecute(List<List<HashMap<String, String>>> result) {
			ArrayList<LatLng> points = null;
			PolylineOptions drawLineOptions = null;
			MarkerOptions markerOptions = new MarkerOptions();
			String distance = "";
			String duration = "";

			if (result.size() < 1) {
				Toast.makeText(getBaseContext(), "No any Points here",
						Toast.LENGTH_SHORT).show();
				return;
			}

			for (int i = 0; i < result.size(); i++) {
				points = new ArrayList<LatLng>();
				drawLineOptions = new PolylineOptions();

				List<HashMap<String, String>> path = result.get(i);

				// Fetching all the points in i route
				for (int j = 0; j < path.size(); j++) {
					HashMap<String, String> point = path.get(j);

					if (j == 0) { // Get distance from the list
						distance = (String) point.get("distance");
						continue;
					} else if (j == 1) { // Get duration from the list
						duration = (String) point.get("duration");
						continue;
					}

					double lat = Double.parseDouble(point.get("lat"));
					double lng = Double.parseDouble(point.get("lng"));
					LatLng position = new LatLng(lat, lng);

					points.add(position);
				}

				// Adding all the points in the route to LineOptions
				drawLineOptions.addAll(points);
				drawLineOptions.width(4);
				drawLineOptions.color(Color.RED);

			}
			Toast.makeText(getApplicationContext(),"Total Distance:" + distance + ", Duration:"+ duration , Toast.LENGTH_LONG).show();
			distanceDuration.setText("Distance:" + distance + ", Duration:"
					+ duration);

			// Drawing polyline in the Google Map for the i-th route
			map.addPolyline(drawLineOptions);
		}
	}

}