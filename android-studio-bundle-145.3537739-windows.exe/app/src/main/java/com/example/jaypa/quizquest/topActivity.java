package com.example.jaypa.quizquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class topActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        helper.getTopTen();
        TextView top1 = (TextView) findViewById(R.id.textView19);
        TextView top2 = (TextView) findViewById(R.id.textView20);
        TextView top3 = (TextView) findViewById(R.id.textView21);
        TextView top4 = (TextView) findViewById(R.id.textView22);
        TextView top5 = (TextView) findViewById(R.id.textView23);

        TextView top11 = (TextView) findViewById(R.id.textView25);
        TextView top22 = (TextView) findViewById(R.id.textView24);
        TextView top33 = (TextView) findViewById(R.id.textView31);
        TextView top44 = (TextView) findViewById(R.id.textView32);
        TextView top55 = (TextView) findViewById(R.id.textView33);

        top1.setText(helper.topScore1); top11.setText(helper.topScore11);
        top2.setText(helper.topScore2); top22.setText(helper.topScore22);
        top3.setText(helper.topScore3); top33.setText(helper.topScore33);
        top4.setText(helper.topScore4); top44.setText(helper.topScore44);
        top5.setText(helper.topScore5); top55.setText(helper.topScore55);
    }
}
