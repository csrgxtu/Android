package io.github.csrgxtu.AndroidService;

import org.json.simple.JSONObject;

import android.util.Log;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RESTClient {
	private String TAG = "RESTClient";
	private String Url;
	
	public RESTClient(String url) {
		this.Url = url;
	}
	
	public boolean doRequest() {
		try {
			//Unirest.setTimeouts(long connectionTimeout, long socketTimeout);
			//HttpResponse<JsonNode> jsonResponse = Unirest.get(this.Url)
			//		.asJson();
			
			JSONObject obj = new JSONObject();
			obj.put("lat", 12.3456);
			obj.put("lon", 121.2389);
			obj.put("time", "2015-04-23 13:30:00");
			
			HttpResponse<JsonNode> jsonResponse = Unirest.post(this.Url)
				.queryString("apiKey", obj)
				.asJson();
			
			Log.i(TAG, jsonResponse.getBody().getObject().toString());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public String getUrl() {
		return this.Url;
	}
	
	public void setUrl(String url) {
		this.Url = url;
	}
}
