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

public class Method2 extends Activity {
	
	Button calculate, back;
	EditText currentGrade, weight, currentPts, assignmentPts;
	TextView finalGrade;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_method2);
		
		currentGrade = (EditText)findViewById(R.id.currentGrade);
		weight = (EditText)findViewById(R.id.weight);
		currentPts = (EditText)findViewById(R.id.currentPts);
		assignmentPts = (EditText)findViewById(R.id.assignmentPts);
		
		finalGrade = (TextView)findViewById(R.id.finalGrade);
		
		calculate =(Button) findViewById(R.id.calculate);
		back = (Button) findViewById(R.id.back);
		
		calculate.setOnClickListener((OnClickListener) this);
		
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View currentView) {
				Intent intent = new Intent();
				setResult(RESULT_OK, intent);
				finish();
			}
		});
	
	
calculate.setOnClickListener(new OnClickListener(){
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			double currentgradepercent = 0;
			double weightvalue = 0;
			
			String grade = null;
			
			//Check if fields are empty
			if (TextUtils.isEmpty(currentGrade.getText().toString()) || TextUtils.isEmpty(weight.getText().toString()) ||
				TextUtils.isEmpty(currentPts.getText().toString()) || TextUtils.isEmpty(assignmentPts.getText().toString())){
				return;
			}
			
			weightvalue = Double.parseDouble(weight.getText().toString());
			currentgradepercent = Double.parseDouble(currentGrade.getText().toString());
					
			String currentPointsTotal = (currentPts.getText().toString());
			String assignmentPointsTotal = (assignmentPts.getText().toString());
			
			double currentPointsmin = Double.parseDouble(currentPointsTotal.substring(0,currentPointsTotal.charAt('/')));
			double assignmentPointsmin = Double.parseDouble(assignmentPointsTotal.substring(0,assignmentPointsTotal.charAt('/')));
			
			double currentPointsmax = Double.parseDouble(currentPointsTotal.substring(currentPointsTotal.charAt('/')+1));
			double assignmentPointsmax = Double.parseDouble(assignmentPointsTotal.substring(assignmentPointsTotal.charAt('/') + 1));
			
			if(v.getId() == R.id.calculate){
				double currentpercent = currentPointsmin/currentPointsmax;
				double currentcontribution = currentpercent * weightvalue;
				
				double totalpercent = (currentPointsmin + assignmentPointsmin)/(currentPointsmax + assignmentPointsmax);
				double contribution = totalpercent * weightvalue;
				
				grade = "" + ((currentgradepercent - currentcontribution)/contribution);
			}
			finalGrade.setText(grade);
		}
	});

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.method2, menu);
		return true;
	}


	
	
				
		
	}
	
	



