package com.example.bookingcar.activities.enter;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bookingcar.R;
import com.example.bookingcar.models.user.UserResponse;
import com.example.bookingcar.requests.user.GetUserRequest;

import java.io.FileInputStream;
import java.io.IOException;

public class EnterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        FileInputStream fin = null;
        try {
            fin = openFileInput("token.txt");
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String token = new String (bytes);
            if(token != ""){
                GetUserRequest getUserRequest = new GetUserRequest();
                getUserRequest.execute(token);
                try {
                    UserResponse user = getUserRequest.get();
                    Toast.makeText(this, user.user.name + ", добро пожаловать!", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new EnterPageAdapter(this, getSupportFragmentManager()));
    }
}
