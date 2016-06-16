package com.example.bertalt.amazingmvp;

/**
 * Created by bertalt on 07.06.16.
 */
public interface LoginInteractor {


    interface OnLoginFinishedListener{

        void onUsernameError();
        void onPasswordError();
        void onSuccessLogin();

    }

    void login(final String username, final String password, final OnLoginFinishedListener listener);
}
