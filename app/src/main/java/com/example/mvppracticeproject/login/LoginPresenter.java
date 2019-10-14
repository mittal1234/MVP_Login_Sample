package com.example.mvppracticeproject.login;

import android.text.TextUtils;

public class LoginPresenter {

    private ILogin callback;

    public LoginPresenter(ILogin callback) {
        this.callback = callback;


    }

    public void onLogin(String password, String phone, String storepassword, String storephone) {

        if (onValidation(password, phone, storepassword, storephone)) {
            callback.onLogin(password, phone, storepassword, storephone);
        }

    }

    public boolean onValidation(String password, String phone, String storepassword, String storephone) {

        if (TextUtils.isEmpty(password)) {
            callback.onError("Password is empty.");
            return false;
        }
        if (TextUtils.isEmpty(phone)) {
            callback.onError("email is empty.");
            return false;
        }
        if (!phone.equals(storephone)) {
            callback.onError("wrong phone number");
            return false;
        }
        if (!storepassword.equals(password)) {
            callback.onError("wrong password ");
            return false;
        }
        return true;
    }

}


