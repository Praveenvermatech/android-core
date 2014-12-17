package com.example.mysqlitedb;

import com.example.mysqlitedb.bean.Product;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Add_ProductActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add__product);
		Product product =new Product();
		Intent addIntentObject = getIntent();
	    product.setProduct_id(String.valueOf(addIntentObject.getStringExtra("product_id")));
	    product.setProduct_name(String.valueOf(addIntentObject.getStringExtra("product_name")));
	    product.setProduct_price(Integer.parseInt(addIntentObject.getStringExtra("product_price")));
		
			
		
	}

	
}
