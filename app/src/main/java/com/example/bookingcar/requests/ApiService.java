package com.example.bookingcar.requests;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {

    public static String get(String uri) {
        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Открытие соединения
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); //Считывание ответа
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
        InputStream is = null;
        try {
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

//            try(OutputStream os = conn.getOutputStream()) {
//                byte[] input = jsonData.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
            StringBuilder response = new StringBuilder();
            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {

                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
