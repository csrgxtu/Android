package io.github.csrgxtu.RESTfulClient;

import org.json.simple.JSONObject;

public class Main {
	public static void main(String[] args) {
		String url = "http://localhost:3000/GPS";
		JSONObject json = new JSONObject();
		json.put("name", "archer");
		json.put("age", 23);
		json.put("sex", "male");
		
		RESTfulClient client = new RESTfulClient(url);
		//System.out.println(client.doGet());
		//System.out.println(client.doPost());
		//System.out.println(client.doPost(json, "data"));
		//System.out.println(client.doPut());
		//System.out.println(client.doPut(json, "data"));
		System.out.println(client.doDelete());
	}
}
