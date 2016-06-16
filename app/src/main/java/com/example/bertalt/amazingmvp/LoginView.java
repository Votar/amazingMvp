package com.example.bertalt.amazingmvp;

/**
 * Created by bertalt on 07.06.16.
 */
public interface LoginView {

    void showProgressBar();
    void hideProgressBar();

    void setUserNameError();
    void setPasswordError();

    void navigateToHome();

}
