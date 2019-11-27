package com.example.rollysgultom_163303030419_tugas01_7tipagib;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContacts extends Activity {
	
	EditText MasukkanName, MasukkanAddress, MasukkanEmail, MasukkanPhone, MasukkanDob;
	Button TombolSimpan;
	
	private String TAG = MainActivity.class.getSimpleName();
	private ProgressDialog pDialog;
	private static String url = "http://apilearning.totopeto.com/contacts";
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_contacts);	
		
		MasukkanName = (EditText) findViewById(R.id.ename);
		MasukkanAddress = (EditText) findViewById(R.id.eaddress);
		MasukkanEmail = (EditText) findViewById(R.id.eemail);
		MasukkanPhone = (EditText) findViewById(R.id.ephone);
		MasukkanDob = (EditText) findViewById(R.id.edob);
		TombolSimpan = (Button) findViewById(R.id.bsimpan);
		
		TombolSimpan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//TODO Auto-generated method stub
				
				Intent intent = new Intent(AddContacts.this, MainActivity.class);
				
				new saveContact().execute();
				AddContacts.this.finish();
				
				startActivity(intent);
			}
		}); 
	}
	
	
	private class saveContact extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			
			String post_params = null;
			JSONObject param = new JSONObject();
			try {
				param.put("name", MasukkanName.getText().toString());
				param.put("address", MasukkanAddress.getText().toString());
				param.put("email", MasukkanEmail.getText().toString());
				param.put("phone", MasukkanPhone.getText().toString());
				param.put("dob", MasukkanDob.getText().toString());
				post_params = param.toString();
			} catch (JSONException e){
				e.printStackTrace();
			}
			HttpHandler InputData = new HttpHandler();
			String jsonstr = InputData.makePostRequest(url, post_params);
			return null;
		}
		
	}
	
}