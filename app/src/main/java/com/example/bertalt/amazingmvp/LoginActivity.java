package com.example.bertalt.amazingmvp;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.etLogin)
    protected EditText etUserName;
    @BindView(R.id.etPassword)
    protected EditText etPassword;
    @BindView(R.id.progress_bar)
    protected ProgressBar progress;

    @BindView(R.id.input_layout_login)
    protected TextInputLayout userNameLayout;
    @BindView(R.id.input_layout_password)
    protected TextInputLayout passwordLayout;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgressBar() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUserNameError() {
        userNameLayout.setError(getString(R.string.username_error));
        requestFocus(etUserName);
    }

    @Override
    public void setPasswordError() {
        passwordLayout.setError(getString(R.string.password_error));
        requestFocus(etPassword);
    }


    @Override
    public void navigateToHome() {

        Toast.makeText(this, getString(R.string.toast_success_login), Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.login_btn_enter)
    protected void tryToLogin(){
        presenter.validateCredentials(etUserName.getText().toString(), etPassword.getText().toString());
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
