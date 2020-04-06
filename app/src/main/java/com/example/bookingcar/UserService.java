package com.example.bookingcar;

import com.example.bookingcar.models.user.User;
import com.example.bookingcar.models.user.UserResponse;

public class UserService {
    private static String token;
    private static User user;

    public static void SetUser(UserResponse user){
        UserService.token = user.token;
        UserService.user = user.user;
    }

    public static String GetToken(){
        return UserService.token;
    }

    public static User GetUser(){
        return UserService.user;
    }
}
