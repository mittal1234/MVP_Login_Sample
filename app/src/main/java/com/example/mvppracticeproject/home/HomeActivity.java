package com.example.mvppracticeproject.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mvppracticeproject.R;

public class HomeActivity extends AppCompatActivity {
    AppCompatTextView btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnadd = findViewById(R.id.btn_add);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this, ShowCarActivity.class);
                startActivity(intent);
            }
        });
    }
}
