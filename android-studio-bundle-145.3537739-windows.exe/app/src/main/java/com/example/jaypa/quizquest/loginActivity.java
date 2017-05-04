package com.example.jaypa.quizquest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements LoginView {
    DatabaseHelper helper = new DatabaseHelper(this);

    protected Button loginBtn;
    protected EditText loginUser;
    protected EditText loginPass;
    protected CheckBox chbox;
    protected SharedPreferences loginPref;
    protected SharedPreferences.Editor loginPrefEditor;
    protected Boolean saveLogin;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.login1);
        loginUser = (EditText) findViewById(R.id.username);
        loginPass = (EditText)findViewById(R.id.password);
        chbox = (CheckBox) findViewById(R.id.checkBox);
        loginBtn.setOnClickListener(loginListener);
        presenter = new LoginPresenter(this, new LoginData());

        loginPref = getSharedPreferences("loginData",MODE_PRIVATE);
        loginPrefEditor = loginPref.edit();

        saveLogin = loginPref.getBoolean("saveLogin", false);
        if(saveLogin == true){
            loginUser.setText(loginPref.getString("username", ""));
            loginPass.setText(loginPref.getString("password", ""));
            chbox.setChecked(true);
        }
    }

    public View.OnClickListener loginListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            presenter.onLoginClicked();
            String userStr = "", passStr = "";
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(loginUser.getWindowToken(), 0);

            userStr = loginUser.getText().toString().toLowerCase();
            passStr = loginPass.getText().toString();

            String password = helper.searchPass(userStr);
            Log.i("password is: ", password);

            if(passStr.equals(password)){

                if (chbox.isChecked()){
                    loginPrefEditor.putBoolean("saveLogin",true);
                    loginPrefEditor.putString("username",userStr);
                    loginPrefEditor.putString("password",passStr);
                    loginPrefEditor.commit();
                }
                else{
                    loginPrefEditor.clear();
                    loginPrefEditor.commit();
                }

                // adding questions from file to database
                if (helper.questionsExit == false){
                    Questions q = new Questions(helper);
                }
                Intent i = new Intent(loginActivity.this, HomeActivity.class);
                i.putExtra("Username",userStr);
                startActivity(i);
                loginActivity.this.finish();
            }
            else
            {
                Toast temp = Toast.makeText(loginActivity.this, "Username or Password doesn't match", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
    };

    @Override
    public String getUsername() {
        return loginUser.getText().toString();
    }

    @Override
    public String getPassword() {
        return loginPass.getText().toString();
    }

    @Override
    public void showUsernameError(int username_error) {
        loginUser.setError(getString(username_error));
    }

    @Override
    public void showPasswordError(int resId) {
        loginPass.setError(getString(resId));
    }

    @Override
    public void startMainActvity() {
        String userStr = loginUser.getText().toString().toLowerCase();
        Intent i = new Intent(loginActivity.this, HomeActivity.class);
        i.putExtra("Username",userStr);
        startActivity(i);
        loginActivity.this.finish();
    }

    @Override
    public void showLoginError(int login_failed) {
        Toast temp = Toast.makeText(loginActivity.this, "Why isnt this working?", Toast.LENGTH_SHORT);
        temp.show();
    }
}
