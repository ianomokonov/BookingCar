package com.example.bookingcar.activities.enter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bookingcar.R;

public class EnterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new EnterPageAdapter(this, getSupportFragmentManager()));
    }
}
