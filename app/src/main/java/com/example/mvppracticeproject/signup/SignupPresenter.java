package com.example.mvppracticeproject.signup;

import android.text.TextUtils;

public class SignupPresenter {
    private ISingup callback;

    public SignupPresenter(ISingup callback) {
        this.callback = callback;
    }

    public void onSignup(String phoneNumber, String password) {
        if (onValidation(phoneNumber, password)) {
            callback.onSignUp(phoneNumber, password);
        }


    }

    private boolean onValidation(String phone, String password) {
        if (TextUtils.isEmpty(password)) {
            callback.onError("Password is empty.");
            return false;
        }
        if (TextUtils.isEmpty(phone)) {
            callback.onError("Phone Number is empty.");
            return false;
        }
        return true;
    }
}
