package com.example.bookingcar.requests.user;

import android.content.Context;
import android.os.AsyncTask;

import com.example.bookingcar.Config;
import com.example.bookingcar.UserService;
import com.example.bookingcar.models.user.LogInUser;
import com.example.bookingcar.models.user.SignInUser;
import com.example.bookingcar.models.user.User;
import com.example.bookingcar.models.user.UserResponse;
import com.example.bookingcar.requests.ApiService;
import com.google.gson.Gson;

public class LogInRequest extends AsyncTask<LogInUser, Void, UserResponse> {
    private Gson gson = new Gson();
    private String base_url;
    public LogInRequest(){
        base_url = Config.base_url + "/user/controller.php?key=log-in";
    }

    protected UserResponse doInBackground(LogInUser... users){
        try{
            UserResponse userResponse = gson.fromJson(ApiService.post(base_url, gson.toJson(users[0])), UserResponse.class);
            if(userResponse != null){
                UserService.SetUser(userResponse);
                return userResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
