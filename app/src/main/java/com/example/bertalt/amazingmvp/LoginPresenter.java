package com.example.bertalt.amazingmvp;

/**
 * Created by bertalt on 07.06.16.
 */
public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
