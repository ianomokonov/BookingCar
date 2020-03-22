package com.example.bookingcar.requests;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiService {

    public static String get(String uri) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(uri)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            String t = response.body().string();
            return t;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String post(String uri, String jsonData) {
        try {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonData);
            Request request = new Request.Builder()
                    .url(uri)
                    .put(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
