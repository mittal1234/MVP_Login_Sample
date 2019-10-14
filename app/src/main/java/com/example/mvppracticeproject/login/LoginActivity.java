package com.example.mvppracticeproject.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.mvppracticeproject.home.HomeActivity;
import com.example.mvppracticeproject.R;
import com.example.mvppracticeproject.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity implements ILogin {

    AppCompatButton bSubmit;
    AppCompatEditText ePhonemunber, ePassword;
    String password, phone, storePhoneNumber, storePassword;
    AppCompatTextView tSignup;
    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        bSubmit = findViewById(R.id.button_submit);
        ePhonemunber = findViewById(R.id.phone_number);
        ePassword = findViewById(R.id.e_password);
        tSignup = findViewById(R.id.Sign_Up);


        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE);
                storePhoneNumber = prefs.getString("phonenumber", "");
                storePassword = prefs.getString("password", "");

                password = ePassword.getText().toString().trim();
                phone = ePhonemunber.getText().toString().trim();
                loginPresenter.onLogin(password, phone, storePassword, storePhoneNumber);


            }
        });


        tSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public void onLogin(String email, String password, String Storepassword, String Storephonenumber) {
        SharedPreferences.Editor editor = getSharedPreferences("key", MODE_PRIVATE).edit();
        editor.putInt("idName", 1);
        editor.apply();


        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
