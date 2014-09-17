package com.ncr.dna.ncrdna;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.ncr.dna.bean.NewsDetails;

public class StartActivity extends Activity {

	protected static final Uri Newsdescription = null;
	ListView listView = null;
	List<NewsDetails> rowItems = new ArrayList<NewsDetails>();
	ImageView menuIcon;
	ImageView refreshIcon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_start);

		menuIcon = (ImageView) findViewById(R.id.mainMenu);
		refreshIcon = (ImageView) findViewById(R.id.refresh);
		refreshIcon.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN)
					refreshIcon.setImageResource(R.drawable.refresh1);
				if (event.getAction() == MotionEvent.ACTION_UP)
					refreshIcon.setImageResource(R.drawable.refresh);
				return false;
			}
		});
		refreshIcon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("in refresh..");
				Intent refresh = new Intent(StartActivity.this,
						StartActivity.class); // your class
				startActivity(refresh);
				finish();
			}
		});

		menuIcon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Creating the instance of PopupMenu
				PopupMenu popup = new PopupMenu(StartActivity.this, menuIcon);
				// Inflating the Popup using xml file
				popup.getMenuInflater().inflate(R.menu.popup_menu,
						popup.getMenu());

				// registering popup with OnMenuItemClickListener
				popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					public boolean onMenuItemClick(MenuItem item) {
						Toast.makeText(StartActivity.this,
								"You Clicked : " + item.getTitle(),
								Toast.LENGTH_SHORT).show();
						return true;
					}
				});

				popup.show();// showing popup menu
			}
		});

		populateNewsList();
		populateNewsView();
		newsRowClickable();

	}

	private void populateNewsList() {

		rowItems.add(new NewsDetails(R.drawable.a1,
				"Modi to press for equal shareholding in BRICS bank",
				"Prime Minister Narendra Modi will launch his first multilateral engagement in this seaside city of Brazil, meeting Russian President Vladimir Putin and Chinese President Xi Jinping ahead of Tuesday's BRICS Summit at which India will press for equal shareholding for its five member countries in the proposed $50 billion BRICS Development Bank so that no shareholder dominates."
						+ "As the football World Cup fever recedes in this soccer crazy nation, Modi will join Putin, Xi, South African President Jacob Zuma and the host President Dilma Rousseff in deliberations over the proposed bank, international financial architecture and other issues at Fortaleza, one of the host cities of the World Cup which ended yesterday with Germany emerging the world champions."
						+ "India is keen on the issue of equal share holding since it does not want a repeat of the distortions that have crept into Bretton Woods institutions like International Monetary Fund, World Bank and the Asian Development Bank in which rich countries like the US and Japan have a strangle hold. ","Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a2,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a3,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a4,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a5,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a6,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a7,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a8,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));
		rowItems.add(new NewsDetails(R.drawable.a9,
				"It is an aggregate accessory fruit",
				"Was asked to give false report in Sunanda death case, AIIMS doctor says",
				"Modi to press for equal shareholding in BRICS bank"));

	}

	private void populateNewsView() {

		ArrayAdapter<NewsDetails> adapter = new MyListAdapter();
		ListView list = (ListView) findViewById(R.id.newslist);
		list.setAdapter(adapter);

	}

	private class MyListAdapter extends ArrayAdapter<NewsDetails> {

		public MyListAdapter() {
			// TODO Auto-generated constructor stub
			super(StartActivity.this, R.layout.main_row, rowItems);

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View newsView = convertView;
			if (newsView == null) {
				newsView = getLayoutInflater().inflate(R.layout.main_row,
						parent, false);
			}

			NewsDetails newsDetails = rowItems.get(position);
			// Split News in Description for short news
			int i = 50, p = 0, length = newsDetails.getDesc().length();
	        String shortDescription;
	        for (i = 50; i < length; i++) {
	            if (newsDetails.getDesc().charAt(i) == ',' || newsDetails.getDesc().charAt(i) == '.') {
	                p = i;
	                break;
	            }
	        }
	        shortDescription = newsDetails.getDesc().substring(0, p+1);
			

			ImageView imageView = (ImageView) newsView
					.findViewById(R.id.list_image);
			imageView.setImageResource(newsDetails.getImageId());

			TextView title = (TextView) newsView.findViewById(R.id.title);
			title.setText(" " + newsDetails.getTitle());

			TextView description = (TextView) newsView.findViewById(R.id.desc);
			description.setText(" " + shortDescription);
			
			TextView imagedesc = (TextView) newsView.findViewById(R.id.title);
			imagedesc.setText(" " + newsDetails.getImageDesc());

			return newsView;
		}

	}

	private void newsRowClickable() {

		ListView newslist = (ListView) findViewById(R.id.newslist);
		newslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				System.out.println("in click Row");
				NewsDetails details = rowItems.get(position);

				/*
				 * Toast toast = Toast.makeText(getApplicationContext(), "Item "
				 * + (position + 1) + ": " + rowItems.get(position),
				 * Toast.LENGTH_SHORT); toast.setGravity(Gravity.CENTER |
				 * Gravity.CENTER_HORIZONTAL, 0, 0); toast.show();
				 */

				/*
				 * Intent rowItemDescription = new Intent(Intent.ACTION_VIEW,
				 * Uri .parse("http://www.ncrdna.com"));
				 */
				Intent rowItemDescription = new Intent(getApplicationContext(),
						NewsDescription.class);
				Bitmap bmp = BitmapFactory.decodeResource(getResources(),
						details.getImageId());
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
				byte[] byteArray = stream.toByteArray();

				// Create a bundle object
				Bundle b = new Bundle();

				// Inserts a String value into the mapping of this Bundle
				rowItemDescription.putExtra("imageList", byteArray);
				b.putString("title", details.getTitle());
				b.putString("description", details.getDesc());
				b.putInt("position", position);
				b.putString("imagedescription", details.getImageDesc());

				// Add the bundle to the intent.
				rowItemDescription.putExtras(b);

				startActivity(rowItemDescription);

			}
		});

	}

}
