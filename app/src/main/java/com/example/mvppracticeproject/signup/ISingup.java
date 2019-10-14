package com.example.mvppracticeproject.signup;

public interface ISingup {
    void onSignUp(String phoneNumber,String password);
    void onError(String message);
}
