package com.ncr.dna.ncrdna;

import java.util.ArrayList;
import java.util.List;

import com.ncr.dna.bean.NewsDetails;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDescription extends Activity {

	List<NewsDetails> rowItems = new ArrayList<NewsDetails>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.news_decription);
		System.out.println("in onCreate method");
		setNewsDescription();

	}

	public void setNewsDescription() {

		Bundle bundle = getIntent().getExtras();
		String title = bundle.getString("title");
		String description = bundle.getString("description");
		String imageDescription = bundle.getString("imagedescription");
		byte[] byteArray = bundle.getByteArray("imageList");

		System.out.println("Description :: " + description);
		Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0,
				byteArray.length);

		ImageView imageView = (ImageView) findViewById(R.id.imageView1);
		imageView.setImageBitmap(bmp);

		TextView imageDesc = (TextView) findViewById(R.id.imageDescription);
		imageDesc.setText(" " + imageDescription);

		TextView newsTitle = (TextView) findViewById(R.id.textView1);
		newsTitle.setText(" " + title);

		TextView newsDescription = (TextView) findViewById(R.id.textView2);
		newsDescription.setText(" " + description);

	}

}
