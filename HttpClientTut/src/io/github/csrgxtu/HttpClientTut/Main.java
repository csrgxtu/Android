package io.github.csrgxtu.HttpClientTut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class Main {
	public static void main(String[] args) {
		String url = "http://192.168.10.100:3000/GPS";
		
		RESTClient client = new RESTClient(url);
		//client.doGet();
		//client.doPost();
		client.doPut();
		//client.doDelete();
	}
}
