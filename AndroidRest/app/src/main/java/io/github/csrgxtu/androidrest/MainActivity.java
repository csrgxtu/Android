package io.github.csrgxtu.androidrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.csrgxtu.androidrest.RestfulClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        String url = "https://raw.github.com/square/okhttp/master/README.md";
        String url = "http://192.168.1.37:8000/gps/0/10";
        try {
            RestfulClient restClient = new RestfulClient();
            restClient.doGet(url, new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    Log.i("onCreate", "request failure");
                }

                @Override
                public void onResponse(Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String responseStr = response.body().string();
                        try {
                            JSONObject Jobject = new JSONObject(responseStr);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // Do what you want to do with the response.
                        Log.i("onCreate", "response successful");
                    } else {
                        // Request not successful
                        Log.i("onCreate", "response is not successful");
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private String run(String url) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
}
