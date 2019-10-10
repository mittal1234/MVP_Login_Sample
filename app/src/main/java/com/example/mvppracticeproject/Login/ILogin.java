package com.example.mvppracticeproject.Login;

public interface ILogin {
    void onLogin(String email,String password);

    void onError(String message);

}
