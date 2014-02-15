package com.example.gradecalculatorapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	 Button calculate, reset, switchMethod;
	 EditText formativePercentage, hwPercentage, summativePercentage, formativeWeight, hwWeight, summativeWeight;
	 TextView grade;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// find the elements
				formativePercentage = (EditText) findViewById(R.id.formativePercentage);
				hwPercentage = (EditText) findViewById(R.id.hwPercentage);
				summativePercentage = (EditText) findViewById(R.id.summativePercentage);
				
				formativeWeight = (EditText) findViewById(R.id.formativeWeight);
				hwWeight = (EditText) findViewById(R.id.hwWeight);
				summativeWeight = (EditText) findViewById(R.id.summativeWeight);
				
				calculate = (Button) findViewById(R.id.calculate);
				reset = (Button) findViewById(R.id.reset);
				
				grade = (TextView) findViewById(R.id.grade);
				
				// set a listener
				calculate.setOnClickListener((OnClickListener) this);
				reset.setOnClickListener((OnClickListener) this);
				
		switchMethod.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(v.getContext(), Method2.class);
				startActivity(myIntent);
				finish();
				}
			});
	
		
		calculate.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				double formativePercent = 0;
				double hwPercent = 0;
				double summativePercent=0;
				
				int formativeWeigh = 0;
				int hwWeigh = 0;
				int summativeWeigh = 0;
				
				String result = null;
				
				//Check if fields are empty
				if (TextUtils.isEmpty(formativePercentage.getText().toString()) || TextUtils.isEmpty(hwPercentage.getText().toString()) ||
						TextUtils.isEmpty(summativePercentage.getText().toString()) || TextUtils.isEmpty(formativeWeight.getText().toString()) ||
						TextUtils.isEmpty(hwWeight.getText().toString()) || TextUtils.isEmpty(summativeWeight.getText().toString())){
					return;
				}
				
				formativePercent = Double.parseDouble(formativePercentage.getText().toString());
				hwPercent = Double.parseDouble(hwPercentage.getText().toString());
				summativePercent = Double.parseDouble(summativePercentage.getText().toString());
				
				formativeWeigh = Integer.parseInt(formativeWeight.getText().toString());
				hwWeigh = Integer.parseInt(hwWeight.getText().toString());
				summativeWeigh = Integer.parseInt(summativeWeight.getText().toString());
				
				
				
					double fcontribution = formativePercent * formativeWeigh;
					double hcontribution = hwPercent * hwWeigh;
					double scontribution = summativePercent * summativeWeigh;
					
					result = ("" + ((fcontribution + hcontribution + scontribution)/100));

				grade.setText(result);
			}
		});
		
		reset.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				formativePercentage.setText("0.0");
				hwPercentage.setText("0.0");
				summativePercentage.setText("0.0");
				formativeWeight.setText("0");
				hwWeight.setText("0");
				summativeWeight.setText("0");
			}

		});
		
		
	
	}	
	
		
		
		
		
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}





}
