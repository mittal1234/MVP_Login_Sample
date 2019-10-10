package com.example.mvppracticeproject.Login;

import android.content.Intent;
import android.text.TextUtils;

public class LoginPresenter {

    private ILogin callback;

    public LoginPresenter(ILogin callback) {
        this.callback = callback;


    }

    public void onLogin(String email, String phone) {

        if (onValidation(email, phone)) {
            callback.onLogin(email, phone);
        }

    }

    public  boolean onValidation(String email,String phone){

        if (TextUtils.isEmpty(email)){
            callback.onError("Email is empty.");
            return false;
        }
        if (TextUtils.isEmpty(phone)){
            callback.onError("Password is empty.");
            return false;
        }
        return true;
    }

}


