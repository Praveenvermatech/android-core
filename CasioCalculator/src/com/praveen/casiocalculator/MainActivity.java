package com.praveen.casiocalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	int x, z;
	String value;
	EditText editText;
	TextView output;
	Button plus, minus, multiply, devide, modular, clear, equal;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = (EditText) findViewById(R.id.editText);

		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		multiply = (Button) findViewById(R.id.multiply);
		devide = (Button) findViewById(R.id.devide);
		modular = (Button) findViewById(R.id.modular);
		clear = (Button) findViewById(R.id.clear);
		equal = (Button) findViewById(R.id.equal);
		
		

		plus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("onClick on plus button");
				value=editText.getText().toString();
				
				//x = Integer.valueOf(editText.getText().toString());
				//value = String.valueOf(x);
				editText.setText(value + "+");
				editText.setSelection(editText.getText().length());
				System.out.println("end of plus");

			}
		});

		minus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("onClick on minus button");
				value=editText.getText().toString();
				//x = Integer.valueOf(editText.getText().toString());
				//value = String.valueOf(x);
				editText.setText(value + "-");
				editText.setSelection(editText.getText().length());
			}
		});
		
		multiply.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("onClick on minus button");
				x = Integer.valueOf(editText.getText().toString());
				value = String.valueOf(x);
				editText.setText(value + "*");
				editText.setSelection(editText.getText().length());
			}
		});
		
		devide.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("onClick on minus button");
				x = Integer.valueOf(editText.getText().toString());
				value = String.valueOf(x);
				editText.setText(value + "/");
				editText.setSelection(editText.getText().length());
			}
		});
		modular.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("onClick on minus button");
				x = Integer.valueOf(editText.getText().toString());
				value = String.valueOf(x);
				editText.setText(value + "%");
				editText.setSelection(editText.getText().length());
			}
		});
		
		equal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				value = editText.getText().toString();
				System.out.println(value);
				
				if(value.contains("+")) {
					
					String a[] = value.split("\\+");
					int z=0;
					for (int i = 0; i < a.length; i++) {
						z=z+Integer.parseInt(a[i]);
					}
					output = (TextView) findViewById(R.id.textView);
					output.setTextSize(30);
					output.setText(String.valueOf(z));
				}
				else if(value.contains("-")) {
					
					String a[] = value.split("\\-");
					int b = Integer.parseInt(a[0]);
					int c = Integer.parseInt(a[1]);
					System.out.println(a[0]);
					System.out.println(a[1]);
					output = (TextView) findViewById(R.id.textView);
					output.setText(String.valueOf(b - c));
				}
				else if(value.contains("*")) {
					
					String a[] = value.split("\\*");
					int b = Integer.parseInt(a[0]);
					int c = Integer.parseInt(a[1]);
					System.out.println(a[0]);
					System.out.println(a[1]);
					output = (TextView) findViewById(R.id.textView);
					output.setText(String.valueOf(b * c));
				}
				else  if(value.contains("/")) {
					
					String a[] = value.split("\\/");
					int b = Integer.parseInt(a[0]);
					int c = Integer.parseInt(a[1]);
					System.out.println(a[0]);
					System.out.println(a[1]);
					output = (TextView) findViewById(R.id.textView);
					double d;
					d=b/c;
					output.setText(String.valueOf(d));
				}
				else if(value.contains("%")) {
					
					String a[] = value.split("\\%");
					int b = Integer.parseInt(a[0]);
					int c = Integer.parseInt(a[1]);
					System.out.println(a[0]);
					System.out.println(a[1]);
					output = (TextView) findViewById(R.id.textView);
					output.setText(String.valueOf(b%c));
				}
				
				
			}
		});
		
		clear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editText.setText("");
				output.setText("");
			}
		});
	}

}
