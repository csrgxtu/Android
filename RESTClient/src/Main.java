import org.json.simple.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class Main {
	public static void main(String[] args) {
		String url = "http://192.168.10.176:3000/GPS";
		
		JSONObject obj = new JSONObject();
		obj.put("lat", 12.2321);
		obj.put("lon", 121.2222);
		obj.put("time", "2015-04-23 13:21:00");
		
		try {
			HttpResponse<JsonNode> jsonResponse = Unirest.post(url)
					  .header("accept", "application/json")
					  .queryString("apiKey", obj)
					  .queryString("data", obj)
					  .asJson();
			System.out.println(jsonResponse.getBody().getObject().toString());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
