package com.example.mvppracticeproject.Login;

public interface ILogin {
    void onLogin(String email,String password,String Storepassword,String Storephonenumber);

    void onError(String message);

}
