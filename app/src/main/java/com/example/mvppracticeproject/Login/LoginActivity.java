package com.example.mvppracticeproject.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mvppracticeproject.Home.HomeActivity;
import com.example.mvppracticeproject.R;

public class LoginActivity extends AppCompatActivity implements ILogin {

    AppCompatButton bsubmit;
    AppCompatEditText ephonemunber,epassword;
    String password,phone;
    LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    loginPresenter =new LoginPresenter(this);



        bsubmit = findViewById(R.id.button_submit);
        ephonemunber = findViewById(R.id.phone_number);
        epassword = findViewById(R.id.e_password);



        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = epassword.getText().toString().trim();
                phone = ephonemunber.getText().toString().trim();
                    loginPresenter.onLogin(password,phone);




            }
        });


    }

    @Override
    public void onLogin(String phone, String password) {
//        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor=sharedPref.edit();
//        editor.putInt("key",1);
//        editor.commit();

//        int i=sharedPref.getInt("key",0);

//        System.out.println("message"+i);
//        Log.d("message", "onLogin: "+ i);
//

        SharedPreferences.Editor editor = getSharedPreferences("key", MODE_PRIVATE).edit();
        editor.putInt("idName", 1);
        editor.apply();

        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);




    }

    @Override
    public void onError(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
