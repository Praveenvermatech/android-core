package com.praveen.seekbar;

import com.praveen.seekbar.R;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	SeekBar seekBar;
	TextView seekBarText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.fragment_main);
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		seekBarText=(TextView)findViewById(R.id.title);
		seekBar.setMax(225);
		
		   float curBrightnessValue = 0;
		  try {
		   curBrightnessValue = android.provider.Settings.System.getInt(
		     getContentResolver(),
		     android.provider.Settings.System.SCREEN_BRIGHTNESS);
		  } catch (SettingNotFoundException e) {
		   e.printStackTrace();
		  }

		   int screen_brightness = (int) curBrightnessValue;
		  seekBar.setProgress(screen_brightness);
		  seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
		   int progress = 0;

		    @Override
		   public void onProgressChanged(SeekBar seekBar, int progresValue,
		     boolean fromUser) {
		    progress = progresValue;
		   }

		    @Override
		   public void onStartTrackingTouch(SeekBar seekBar) {
		    // Do something here,
		    // if you want to do anything at the start of
		    // touching the seekbar
		    	
		   }

		    @Override
		   public void onStopTrackingTouch(SeekBar seekBar) {
		    android.provider.Settings.System.putInt(getContentResolver(),
		      android.provider.Settings.System.SCREEN_BRIGHTNESS,
		      progress);
		    seekBarText.setText("Adjust Brightness : "+progress);
		   }
		  });
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
