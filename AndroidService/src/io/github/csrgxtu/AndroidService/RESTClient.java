package io.github.csrgxtu.AndroidService;

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
	
	public boolean run() {
		try {
			//Unirest.setTimeouts(long connectionTimeout, long socketTimeout);
			//HttpResponse<JsonNode> jsonResponse = Unirest.get(this.Url)
			//		.asJson();
			
			HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
					  .queryString("apiKey", "123")
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
