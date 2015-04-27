package io.github.csrgxtu.AndroidService;

import org.json.simple.JSONObject;

import android.app.IntentService;
import android.content.Intent;

public class TestService extends IntentService {
	private String TAG = "TestService";
	
	public TestService() {
		super("TestService");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		String url = "http://192.168.1.100:3000/GPS";
		RESTfulClient client = new RESTfulClient(url);
		JSONObject json = new JSONObject();
		json.put("lat", 28.239062);
		json.put("lon", 112.894294);
		
		for (int i = 0; i < 100; i++) {
			client.doPost(json, "data");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}