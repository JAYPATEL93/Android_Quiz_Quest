package com.example.jaypa.quizquest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signupActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    protected Button submit;
    protected EditText username;
    protected EditText password;
    protected EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        submit = (Button) findViewById(R.id.submitBtn);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);

        submit.setOnClickListener(submitListener);

    }
    public View.OnClickListener submitListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String userStr = "", passStr = "", emailStr = "", lowerString = "";
            int score = 0;

            userStr = username.getText().toString().toLowerCase();
            passStr = password.getText().toString();
            emailStr = email.getText().toString().toLowerCase();

            String accountExists = helper.searchPass(userStr);

            if (userStr.length() == 0 || passStr.length() == 0 || emailStr.length() == 0){
                Toast msg = Toast.makeText(signupActivity.this, "All the fields are required", Toast.LENGTH_SHORT);
                msg.show();
            }

            else if (!accountExists.equals("not found")){
                Toast msg = Toast.makeText(signupActivity.this, "username already taken!", Toast.LENGTH_SHORT);
                msg.show();
            }
            else{
                LoginData data = new LoginData();
                data.setUsername(userStr);
                data.setPassword(passStr);
                data.setEmail(emailStr);
                data.setScore(score);

                Toast.makeText(signupActivity.this, "Success", Toast.LENGTH_SHORT).show();

                helper.insertContact(data);
                Intent i = new Intent(signupActivity.this, loginActivity.class);
                startActivity(i);
                signupActivity.this.finish();
            }
        }
    };
}
