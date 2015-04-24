import io.github.csrgxtu.HttpClientTut.RESTClient;



public class Main {
	public static void main(String[] args) {
		String url = "http://localhost:3000/GPS";
		
		RESTClient client = new RESTClient(url);
		System.out.println(client.doGet());
	}
}
