package com.example.jaypa.quizquest;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mp = MediaPlayer.create(this, R.raw.questionmp);
        Button btn = (Button) findViewById(R.id.mapBtn);
        Button top = (Button) findViewById(R.id.top10);
        TextView txt = (TextView) findViewById(R.id.textView2);
        TextView scorebox = (TextView) findViewById(R.id.scoreView);

        btn.setOnClickListener(mapListener);
        top.setOnClickListener(toptenListener);

        String newString = "";
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("Username");
            }
        }
        else {
            newString= (String) savedInstanceState.getSerializable("Username");
        }

        //Send username to database
        //helper.getUserString(newString);

        txt.setText("hello, " + newString);

        int score = helper.searchScore(newString);
        scorebox.setText("Score: " + Integer.toString(score));
    }

    public View.OnClickListener mapListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            mp.start();
            Intent i = new Intent(HomeActivity.this, MapsActivity.class);
            startActivityForResult(i,1);
        }
    };

    public View.OnClickListener toptenListener = new View.OnClickListener(){
      @Override
      public void onClick(View v){
        Intent intent = new Intent(HomeActivity.this, topActivity.class);
          startActivityForResult(intent , 1);
      }
    };
}
