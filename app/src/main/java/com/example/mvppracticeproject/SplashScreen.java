package com.example.mvppracticeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.LoginFilter;
import android.util.Log;

import com.example.mvppracticeproject.Home.HomeActivity;
import com.example.mvppracticeproject.Login.LoginActivity;

public class SplashScreen extends AppCompatActivity {
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getSharedPreferences("key", MODE_PRIVATE);
        final int idName = prefs.getInt("idName", 0); //0 is the default value.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (idName == 1) {
                    Intent i = new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 3000);
    }
}

