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
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Открытие соединения
            conn.setRequestMethod("GET");
            BufferedReader rd;
            int status =conn.getResponseCode();
            if(status<400){
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                //read response
            }else{
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                //read response
            }
//            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); //Считывание ответа
            String result = "";
            String line = "";
            while ((line = rd.readLine()) != null) {
                result += line.replaceAll("\\<.*?>",""); //сохранение ответа и удаление тегов
            }
            rd.close(); // закрытие чтения
            return result;

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
