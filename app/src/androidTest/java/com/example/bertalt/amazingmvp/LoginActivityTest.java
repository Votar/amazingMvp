package com.example.bertalt.amazingmvp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ProgressBar;


/**
 * Created by bertalt on 10.06.16.
 */
public class LoginActivityTest  extends ActivityInstrumentationTestCase2{

    private LoginActivity loginActivity;

    protected EditText etUserName;

    protected EditText etPassword;

    protected ProgressBar progress;

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        loginActivity = (LoginActivity)getActivity();

        etPassword = (EditText)loginActivity.findViewById(R.id.etPassword);
        etUserName = (EditText)loginActivity.findViewById(R.id.etLogin);
        progress = (ProgressBar)loginActivity.findViewById(R.id.progress_bar);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testControlsCreated() throws Exception {
        assertNotNull(loginActivity);
        assertNotNull(etPassword);
        assertNotNull(etUserName);
        assertNotNull(progress);
    }
}
