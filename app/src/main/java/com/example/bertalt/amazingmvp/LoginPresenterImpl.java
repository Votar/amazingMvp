package com.example.bertalt.amazingmvp;

/**
 * Created by bertalt on 07.06.16.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView view;
    private LoginInteractor interactor;

    public LoginPresenterImpl(LoginView view){

        this.view = view;
        interactor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String username, String password) {

        if(view != null){
            view.showProgressBar();
            interactor.login(username, password, this);
        }

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onUsernameError() {
        if(view != null){
            view.hideProgressBar();
            view.setUserNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(view != null){
            view.hideProgressBar();
            view.setPasswordError();
        }
    }

    @Override
    public void onSuccessLogin() {
        if(view != null){
            view.hideProgressBar();
            view.navigateToHome();
        }
    }
}
