package io.github.csrgxtu.AndroidService;

import org.json.simple.JSONObject;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.util.Log;

public class TestService extends IntentService {
	private String TAG = "TestService";
	
	public TestService() {
		super("TestService");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		GPSTracker gps = new GPSTracker(this);
		
		String url = "http://192.168.1.100:3000/GPS";
		RESTfulClient client = new RESTfulClient(url);
		
		for (int i = 0; i < 100; i++) {
			//Log.i(TAG, gps.getLocation().toString());
			Location location = gps.getLocation();
			JSONObject json = new JSONObject();
			json.put("lat", location.getLatitude());
			json.put("lon", location.getLongitude());
			client.doPost(json, "data");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}