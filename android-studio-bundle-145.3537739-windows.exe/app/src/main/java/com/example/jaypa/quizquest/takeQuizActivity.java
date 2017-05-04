package com.example.jaypa.quizquest;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.games.appcontent.AppContentTuple;

import org.w3c.dom.Text;

public class takeQuizActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    MediaPlayer correctMp;
    public boolean clickFlag = false;

    protected Button next;
    protected TextView txt;
    protected TextView qn;
    protected TextView ch1;
    protected TextView ch2;
    protected TextView ch3;
    protected TextView ch4;
    String newString = "";
    String answer = "";

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);
        correctMp = MediaPlayer.create(this,R.raw.correctmp);

        txt = (TextView) findViewById(R.id.textView9);
        qn = (TextView) findViewById(R.id.textView10);
        ch1 = (TextView) findViewById(R.id.textView11);
        ch2 = (TextView) findViewById(R.id.textView12);
        ch3 = (TextView) findViewById(R.id.textView13);
        ch4 = (TextView) findViewById(R.id.textView14);
        next = (Button) findViewById(R.id.nextq);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                newString = "";
            }else{
                newString = extras.getString("place");
            }
        }
        else{
            newString= (String) savedInstanceState.getSerializable("place");
        }

        if (newString.equals("ILLINOIS")){txt.setText("ILLINOIS");}
        else if (newString.equals("NEW YORK")){txt.setText("NEW YORK");}
        else if (newString.equals("CALIFORNIA")){txt.setText("CALIFORNIA");}
        else if (newString.equals("FLORIDA")){txt.setText("FLORIDA");}
        else if (newString.equals("GEORGIA")){txt.setText("GEORGIA");}
        else if (newString.equals("ARIZONA")){txt.setText("ARIZONA");}
        else if (newString.equals("MONTANA")){txt.setText("MONTANA");}
        else{txt.setText("no string");}

        //getting a cursor at given state
        helper.getstatequestions(newString);

        getTextFromHelper(0);

        ch1.setOnClickListener(op1Listener);
        ch2.setOnClickListener(op2Listener);
        ch3.setOnClickListener(op3Listener);
        ch4.setOnClickListener(op4Listener);
        next.setOnClickListener(nextQListener);
    }

    View.OnClickListener op1Listener = new View.OnClickListener(){
        @Override
        public void onClick(View V){
            if (answer.equals(ch1.getText().toString())){
                if (clickFlag == false){
                    Toast.makeText(takeQuizActivity.this, "Way to go. +1",Toast.LENGTH_SHORT).show();
                    helper.updateScore(1);
                    correctMp.start();
                    clickFlag = true;
                }
                ch1.setBackgroundColor(Color.rgb(34,139,34));
            }
            else{
                ch1.setBackgroundColor(Color.rgb(255,0,0));
                //Toast.makeText(takeQuizActivity.this, " not always the first one. Please try again", Toast.LENGTH_SHORT).show();
            }
        }
    };

    View.OnClickListener op2Listener = new View.OnClickListener(){
        @Override
        public void onClick(View V){
            if (answer.equals(ch2.getText().toString())){
                if (clickFlag == false){
                    Toast.makeText(takeQuizActivity.this, "awesome. +1",Toast.LENGTH_SHORT).show();
                    helper.updateScore(1);
                    correctMp.start();
                    clickFlag = true;
                }
                ch2.setBackgroundColor(Color.rgb(34,139,34));
            }
            else{
                ch2.setBackgroundColor(Color.rgb(255,0,0));
                //Toast.makeText(takeQuizActivity.this, "Close. Please try again", Toast.LENGTH_SHORT).show();
            }
        }
    };

    View.OnClickListener op3Listener = new View.OnClickListener(){
        @Override
        public void onClick(View V){
            if (answer.equals(ch3.getText().toString())){
                if (clickFlag == false){
                    Toast.makeText(takeQuizActivity.this, "You got it. +1",Toast.LENGTH_SHORT).show();
                    helper.updateScore(1);
                    correctMp.start();
                    clickFlag = true;
                }
                ch3.setBackgroundColor(Color.rgb(34,139,34));
            }
            else{
                ch3.setBackgroundColor(Color.rgb(255,0,0));
                //Toast.makeText(takeQuizActivity.this, "It's not me. Please try again", Toast.LENGTH_SHORT).show();
            }
        }
    };

    View.OnClickListener op4Listener = new View.OnClickListener(){
        @Override
        public void onClick(View V){
            if (answer.equals(ch4.getText().toString())){
                if (clickFlag == false){
                    Toast.makeText(takeQuizActivity.this, "Correct. +1",Toast.LENGTH_SHORT).show();
                    helper.updateScore(1);
                    correctMp.start();
                    clickFlag = true;
                }
                ch4.setBackgroundColor(Color.rgb(34,139,34));
            }
            else{
                ch4.setBackgroundColor(Color.rgb(255,0,0));
                //Toast.makeText(takeQuizActivity.this, "Incorrect. Please try again", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                Intent i = new Intent (takeQuizActivity.this, intakeActivity.class);
                i.putExtra("place1",newString);
                startActivityForResult(i,1);
                return(true);
        }
        return(super.onOptionsItemSelected(item));
    }

    View.OnClickListener nextQListener = new View.OnClickListener(){
      @Override
      public void onClick(View v){
          ch1.setBackgroundColor(Color.TRANSPARENT);
          ch2.setBackgroundColor(Color.TRANSPARENT);
          ch3.setBackgroundColor(Color.TRANSPARENT);
          ch4.setBackgroundColor(Color.TRANSPARENT);
          //correctMp.stop();
          getTextFromHelper(1);
          clickFlag = false;
      }
    };

    public void getTextFromHelper(int number){
        boolean check = false;
        if (number == 0)
            check = helper.stateCursor.moveToFirst();
        else
            check = helper.stateCursor.moveToNext();

        if (check == true){
            qn.setText(helper.stateCursor.getString(0));
            ch1.setText(helper.stateCursor.getString(2));
            ch2.setText(helper.stateCursor.getString(3));
            ch3.setText(helper.stateCursor.getString(4));
            ch4.setText(helper.stateCursor.getString(5));
            answer = helper.stateCursor.getString(1);
        }
    }
}
