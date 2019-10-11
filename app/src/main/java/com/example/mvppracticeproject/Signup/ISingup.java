package com.example.mvppracticeproject.Signup;

public interface ISingup {
    void onSignUp(String phoneNumber,String password);
    void onError(String message);
}
