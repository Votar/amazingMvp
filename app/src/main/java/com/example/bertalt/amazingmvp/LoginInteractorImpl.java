package com.example.bertalt.amazingmvp;


import android.text.TextUtils;

/**
 * Created by bertalt on 07.06.16.
 */
public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        new android.os.Handler().postDelayed(new Runnable(){

            boolean error;
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)) {
                    listener.onUsernameError();
                    error = true;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }

                if(!error)
                    listener.onSuccessLogin();
            }
        }, 2000);

    }
}
