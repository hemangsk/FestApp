package xyz.hemangkumar.infox;

/**
 * Created by Hemang on 18/08/16.
 */
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class AsynchronousGet {
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url("https://raw.githubusercontent.com/hemangsk/json_endpoints/master/test.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                  //  System.out.println(responseBody.string());
                   //  Log.d("JSON 2", responseBody.toString());
                    eventName(responseBody.string());
                }
            }
        });
    }

    public static void task() throws Exception {
        new AsynchronousGet().run();
    }

    public static JSONArray eventName(String s){
        JSONArray jsonObject = new JSONArray();
        s = s.replace("\\\"", "\"");

        try {
            jsonObject = new JSONArray(s);
            Log.e("RESULT", jsonObject.toString());

            JSONObject j;


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return jsonObject;
    }
}