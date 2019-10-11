package com.example.mvppracticeproject.Signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvppracticeproject.Login.LoginActivity;
import com.example.mvppracticeproject.R;

public class SignupActivity extends AppCompatActivity implements ISingup {

    AppCompatEditText ePhoneNumber, ePassword;
    AppCompatButton bRegister;
    String phoneNumber, password;
    SignupPresenter signupPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupPresenter = new SignupPresenter(this);
        ePhoneNumber = findViewById(R.id.phone_number);
        ePassword = findViewById(R.id.e_password);
        bRegister = findViewById(R.id.button_register);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumber = ePhoneNumber.getText().toString().trim();
                password = ePassword.getText().toString().trim();

                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();


                editor.putString("phonenumber", phoneNumber);
                editor.putString("password", password);
                editor.apply();
                signupPresenter.onSignup(phoneNumber, password);

//
            }
        });


    }

    @Override
    public void onSignUp(String phoneNumber, String password) {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


    }
}
