package com.example.jaypa.quizquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    protected Button login;
    protected Button signup;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.login1);
        signup = (Button)findViewById(R.id.signUp);

        login.setOnClickListener(loginListener);
        signup.setOnClickListener(signupListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.about:
                LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.popup, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                    }});
                 popupWindow.showAtLocation(login, 1, 0, 0);
                return(true);

            case R.id.help:
                LayoutInflater layoutInflater1 = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView1 = layoutInflater1.inflate(R.layout.popupbout, null);
                final PopupWindow popupWindow1 = new PopupWindow(popupView1, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss1 = (Button)popupView1.findViewById(R.id.button3);
                btnDismiss1.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow1.dismiss();
                    }});
                popupWindow1.showAtLocation(login, 1, 0, 0);
                return(true);
        }
        return(super.onOptionsItemSelected(item));
    }

    public View.OnClickListener loginListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switchtoLoginPage();
        }
    };

    public View.OnClickListener signupListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            switchtoSignUpPage();
        }
    };

    private void switchtoLoginPage(){
        Intent i = new Intent(MainActivity.this, loginActivity.class);
        startActivityForResult(i,1);
    }

    private void switchtoSignUpPage(){
        Intent i = new Intent(MainActivity.this, signupActivity.class);
        startActivityForResult(i,1);
    }

}
