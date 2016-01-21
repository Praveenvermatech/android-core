package com.example.mysqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mysqlitedb.bean.Product;

public class DbHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME = "product_host.db";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_NAME = "PRODUCT_INFO";
	public static final String PRODUCT_ID = "PRODUCT_ID";
	public static final String PRODUCT_NAME = "PRODUCT_NAME";
	public static final String PRODUCT_PRICE = "PRODUCT_PRICE";
	
	Product product=new Product();
	
	public DbHelper(Context context) {
		super(context, DbHelper.DATABASE_NAME, null, DbHelper.DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String createTable = "CREATE TABLE IF NOT EXISTS " + DbHelper.TABLE_NAME + " (" 
	            + PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
	            + PRODUCT_NAME + " TEXT, "
	            + PRODUCT_PRICE + " INTEGER )";
	     db.execSQL(createTable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + DbHelper.TABLE_NAME);
	      onCreate(db);
	}
	
	public void addProduct(Product product) {

        ContentValues values = new ContentValues();
        values.put(PRODUCT_ID, product.getProduct_id());
        values.put(PRODUCT_NAME, product.getProduct_name());
        values.put(PRODUCT_PRICE, product.getProduct_price());
        SQLiteDatabase db = this.getWritableDatabase();
        
        db.insert(DbHelper.TABLE_NAME, null, values);
        db.close();
}
	public boolean deleteProduct(String product_id) {
		
		boolean result = false;
		
		String query = "Select * FROM " + TABLE_NAME + " WHERE " + PRODUCT_ID + " =  \"" + product_id + "\"";

		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		Product product = new Product();
		
		if (cursor.moveToFirst()) {
			product.setProduct_id((cursor.getString(0)));
			db.delete(TABLE_NAME, PRODUCT_ID + " = ?",
		            new String[] { String.valueOf(product.getProduct_id()) });
			cursor.close();
			result = true;
		}
	        db.close();
		return result;
	}

}
