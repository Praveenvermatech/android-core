package com.praveen.customdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button buttonClick;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonClick = (Button) findViewById(R.id.buttonClick);
		 
        buttonClick.setOnClickListener(new View.OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
 
                // Create custom dialog object
                final Dialog dialog = new Dialog(MainActivity.this);
                
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog);
                
                // Set dialog title
                dialog.setTitle("Do you want to save !");
 
                // set values for custom dialog components - text, image and button
                TextView text = (TextView) dialog.findViewById(R.id.textDialog);
                text.setText("Dear, user please check the all data, if every things are right then choose submit button, Otherwise Back.");
                ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
                image.setImageResource(R.drawable.smiley);
 
                dialog.show();
                 
                Button declineButton = (Button) dialog.findViewById(R.id.declineButton);
                // if submit button is clicked, close the custom dialog
                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // finish application
                        finish();
                    }
                });
                
                
                Button backButton=(Button) dialog.findViewById(R.id.backButton);
                backButton.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						// Close dialog
						dialog.dismiss();
					}
				});
 
                 
            }
 
        });
 
    }

}
