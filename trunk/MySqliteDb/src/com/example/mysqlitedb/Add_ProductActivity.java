package com.example.mysqlitedb;

import com.example.mysqlitedb.bean.Product;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Add_ProductActivity extends Activity {

	EditText id;
	EditText name;
	EditText price;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add__product);
		
		id=(EditText) findViewById(R.id.product_id);
		name=(EditText) findViewById(R.id.product_name);
		price=(EditText) findViewById(R.id.product_price);
		Intent  putIntent=new Intent();
		putIntent.putExtra("product_id","id");
		putIntent.putExtra("product_name","name ");
		putIntent.putExtra("product_id","id");
		
		Product product =new Product();
		Intent addIntentObject = getIntent();
	    product.setProduct_id(String.valueOf(addIntentObject.getStringExtra("product_id")));
	    product.setProduct_name(String.valueOf(addIntentObject.getStringExtra("product_name")));
	    product.setProduct_price(Integer.parseInt(addIntentObject.getStringExtra("product_price")));
		
			
		
	}

	
}
