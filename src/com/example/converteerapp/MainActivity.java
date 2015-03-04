package com.example.converteerapp;

import java.util.Observable;
import java.util.Observer;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements Observer{
	
	private Boolean verander;
	private TextView hexa;
	private TextView octaal;
	private TextView binair;
	private EditText editText;
	private Button plusTien;
	private Button plusEen;
	private Button minTien;
	private Button minEen;
	private Model model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		model = new Model(0);
		model.addObserver(this);
		
		
		hexa = (TextView) findViewById(R.id.hexa);
		octaal = (TextView) findViewById(R.id.octaal);
		binair = (TextView) findViewById(R.id.binair);
		
		editText = (EditText) findViewById(R.id.editText1);
		
		plusTien = (Button) findViewById(R.id.button3);
		plusEen = (Button) findViewById(R.id.plusEen);
		minTien = (Button) findViewById(R.id.minTien);
		minEen = (Button) findViewById(R.id.minEen);
		
		
		plusTien.setOnClickListener(new plusTien());
		plusEen.setOnClickListener(new plusEen());
		minTien.setOnClickListener(new minTien());
		minEen.setOnClickListener(new minEen());
		editText.addTextChangedListener(new addListenerOnTextChange());
			
	}
	
	
	private class minTien implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			model.veranderGetal(-10);
			editText.setText(model.getGetal());
		}
	}
	
	private class minEen implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			model.veranderGetal(-1);
			editText.setText(model.getGetal());
		}
	}
	
	private class plusTien implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			verander = true;
			model.veranderGetal(10);
			editText.setText(Integer.toString(model.getGetal()));	
			
			
		}
			
	}
	
	private class plusEen implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			model.veranderGetal(1);
			editText.setText(model.getGetal());
		}
	}
	
	
	private class addListenerOnTextChange implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			if (!verander){
			if (editText.getText().toString().length() ==0){
				model = new Model(0);
				update(model, model);
			}
			else {
				model = new Model(Integer.parseInt(editText.getText().toString()));
				update(model, model);
			}}
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void update(Observable observable, Object data) {
		int x = model.getGetal();
		
		hexa.setText(Integer.toHexString(x));
		octaal.setText(Integer.toOctalString(x));
		binair.setText(Integer.toBinaryString(x));
		verander = false;
		
	}
}
