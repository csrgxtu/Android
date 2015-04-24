package io.github.csrgxtu.AndroidService;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestService extends IntentService {
	private String TAG = "TestService";
	
	public TestService() {
		super("TestService");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i(TAG, "In IntentService");
		String url = "http://192.168.10.210:3000/GPS";
		RESTClient client = new RESTClient(url);
		client.run();
		Log.i(TAG, "After Http REST Request");
	}
}