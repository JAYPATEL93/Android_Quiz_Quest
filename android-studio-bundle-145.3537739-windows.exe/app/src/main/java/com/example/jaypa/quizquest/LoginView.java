package com.example.jaypa.quizquest;

/**
 * Created by David on 4/23/17.
 */

public interface LoginView {
    String getUsername();
    String getPassword();

    void showUsernameError(int username_error);
    void showPasswordError(int resId);
    void startMainActvity();
    void showLoginError(int login_failed);
}
