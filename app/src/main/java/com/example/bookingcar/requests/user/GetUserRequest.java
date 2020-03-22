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

public class GetUserRequest extends AsyncTask<String, Void, UserResponse> {
    private Gson gson = new Gson();
    private String base_url;
    public GetUserRequest(){
        base_url = Config.base_url + "/user/controller.php?key=get-user&token=";
    }

    protected UserResponse doInBackground(String... token){
        try{
            UserResponse userResponse = gson.fromJson(ApiService.get(base_url+token[0]), UserResponse.class);
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
