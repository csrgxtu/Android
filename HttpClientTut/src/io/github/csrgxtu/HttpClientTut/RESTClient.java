package io.github.csrgxtu.HttpClientTut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

public class RESTClient {
	private String Url;
	
	public RESTClient(String url) {
		this.Url = url;
	}
	
	public boolean doPost() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(this.Url);
		
		try {
		    List<NameValuePair> postData = new ArrayList<NameValuePair>(1);
		    postData.add(new BasicNameValuePair("data", "12345"));
		    request.setEntity(new UrlEncodedFormEntity(postData, "UTF-8"));
			
			HttpResponse response = client.execute(request);
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean doPost(JSONObject json) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(this.Url);
		
		try {
		    List<NameValuePair> postData = new ArrayList<NameValuePair>(1);
		    postData.add(new BasicNameValuePair("data", json.toJSONString()));
		    request.setEntity(new UrlEncodedFormEntity(postData, "UTF-8"));
			
			HttpResponse response = client.execute(request);
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean doGet() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(this.Url);
		
		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean doPut() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut request = new HttpPut(this.Url);
		
		try {
			HttpResponse response = client.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean doDelete() {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete(this.Url);
		
		try {
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
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
