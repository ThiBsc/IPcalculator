package com.ipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private IP ip;
	private LinearLayout lLayout;
	private LayoutParams lParams;
	private EditText txtIP;
	private NumberPicker npMask;
	private Button	btnCalculate;
	private TextView txtResult;
	private Toast toastErr;
	
	public MainActivity() {
		super();
		ip = new IP("192.168.1.19");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		lLayout = new LinearLayout(this);
		lLayout.setOrientation(LinearLayout.VERTICAL);
		lParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(lLayout, lParams);
		
		txtIP = new EditText(this);
		txtIP.setHint("Ex: 192.168.1.19");
		txtIP.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_CLASS_TEXT);
		npMask = new NumberPicker(this);
		//npMask.setOrientation(NumberPicker.HORIZONTAL);
		npMask.setMinValue(1);
		npMask.setMaxValue(32);
		npMask.setValue(24);
		btnCalculate = new Button(this);
		btnCalculate.setText("Calculate!");
		btnCalculate.setOnClickListener(this);
		txtResult = new TextView(this);
		
		lLayout.addView(txtIP);
		lLayout.addView(npMask);
		lLayout.addView(btnCalculate);
		lLayout.addView(txtResult);
	}

	@Override
	public void onClick(View v) {
		Button btn = (Button) v;
		if ( ip.setIP(txtIP.getText().toString().isEmpty() ? "192.168.1.19" : txtIP.getText().toString()) ){
			int mask = npMask.getValue();
			txtResult.setText(ip.getIP()+"/"+npMask.getValue()
			+ "\nMask:\t\t\t\t"	+ip.maskToSubnet(mask)
			+ "\nNetwork:\t\t"	+ip.getNetwork(mask)
			+ "\nHost:\t\t\t\t"	+ip.getHost(mask)
			+ "\nBroadcast:\t"	+ip.getBroadcast(mask)
			+ "\nnbHost:\t\t\t"	+ip.getNbHost(mask));
		}
		else{
			toastErr = Toast.makeText(this, "Invalid IP!", 1);
			toastErr.show();
		}
	}
}
