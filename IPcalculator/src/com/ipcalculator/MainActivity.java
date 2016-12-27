package com.ipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;

public class MainActivity extends Activity {
	
	private LinearLayout lLayout;
	private LayoutParams lParams;
	private EditText txtIP;
	private NumberPicker npMask;
	private Button	btnCalculate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		lLayout = new LinearLayout(this);
		lParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(lLayout, lParams);
		
		txtIP = new EditText(this);
		txtIP.setHint("Ex: 127.0.0.1");
		npMask = new NumberPicker(this);
		npMask.setMinValue(1);
		npMask.setMaxValue(32);
		npMask.setValue(24);
		btnCalculate = new Button(this);
		btnCalculate.setText("Calculate!");
		
		lLayout.addView(txtIP);
		lLayout.addView(npMask);
		lLayout.addView(btnCalculate);
	}
}
