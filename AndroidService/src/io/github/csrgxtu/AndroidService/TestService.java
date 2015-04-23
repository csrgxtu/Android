package io.github.csrgxtu.AndroidService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {
	private String TAG = "TestService";
	
    public void onCreate() {       
        super.onCreate();
    }
 
    @Override
    public void onDestroy() {       
        super.onDestroy();
    }
 
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	Log.i(TAG, "In Serivce");
        return super.onStartCommand(intent, flags, startId);
    }
 
    @Override
    public IBinder onBind(Intent arg0) {       
        return null;
    }
}