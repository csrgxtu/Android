package io.github.csrgxtu.RESTfulClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;

public class RESTfulClient {
	private String Url;
	
	public RESTfulClient (String url) {
		this.Url = url;
	}
	
	/**
	 * @return String or null
	 */
	public String doPost() {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(this.Url).openConnection();
			conn.setUseCaches (false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				return null;
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			conn.disconnect();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * put all data into json and give it a key
	 * 
	 * @param json JSONObject
	 * @param key String
	 * @return String or null
	 */
	public String doPost(JSONObject json, String key) {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(this.Url).openConnection();
			conn.setUseCaches (false);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty ("Content-Type", "application/x-www-form-urlencoded");
			
			String data = "&" + key + "=" + URLEncoder.encode(json.toJSONString(), "UTF-8");
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			wr.close();
			conn.disconnect();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @return String or null
	 */
	public String doGet() {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(this.Url).openConnection();
			conn.setUseCaches (false);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				return null;
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			conn.disconnect();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @return String or null
	 */
	public String doPut() {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(this.Url).openConnection();
			conn.setUseCaches (false);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				return null;
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			conn.disconnect();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String doPut(JSONObject json, String key) {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(this.Url).openConnection();
			conn.setUseCaches (false);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty ("Content-Type", "application/x-www-form-urlencoded");
			
			String data = "&" + key + "=" + URLEncoder.encode(json.toJSONString(), "UTF-8");
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			wr.close();
			conn.disconnect();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String doDelete() {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(this.Url).openConnection();
			conn.setUseCaches (false);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				return null;
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			StringBuffer result = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				result.append(line);
			}
			
			conn.disconnect();
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getUrl() {
		return this.Url;
	}
	
	public void setUrl(String url) {
		this.Url = url;
	}
}
