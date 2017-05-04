package com.example.jaypa.quizquest;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class intakeActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    protected TextView st;
    protected EditText qn; //5
    protected EditText o1; //6
    protected EditText o2; //7
    protected EditText o3; //8
    protected EditText o4; //9
    protected Button btn;  //2
    protected RadioButton r1;
    protected RadioButton r2;
    protected RadioButton r3;
    protected RadioButton r4;
    protected RadioGroup rg;

    String stateq = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intake);

        qn = (EditText) findViewById(R.id.editText5);
        o1 = (EditText) findViewById(R.id.editText6);
        o2 = (EditText) findViewById(R.id.editText7);
        o3 = (EditText) findViewById(R.id.editText8);
        o4 = (EditText) findViewById(R.id.editText9);
        st = (TextView) findViewById(R.id.textView15);
        btn = (Button) findViewById(R.id.button2);

        rg = (RadioGroup) findViewById(R.id.rgr);
        r1 = (RadioButton) findViewById(R.id.radioButton2);
        r2 = (RadioButton) findViewById(R.id.radioButton3);
        r3 = (RadioButton) findViewById(R.id.radioButton4);
        r4 = (RadioButton) findViewById(R.id.radioButton5);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                stateq = "";
            }else{
                stateq = extras.getString("place1");
            }
        }
        else{
            stateq = (String) savedInstanceState.getSerializable("place1");
        }
        st.setText(stateq);
        btn.setOnClickListener(addListener);
    }

    public View.OnClickListener addListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String qnStr = "", o1Str = "", o2Str = "", o3Str = "", o4Str = "", ansStr = "";

            qnStr = qn.getText().toString();
            o1Str = o1.getText().toString();
            o2Str = o2.getText().toString();
            o3Str = o3.getText().toString();
            o4Str = o4.getText().toString();

            if (qnStr.length() == 0 || o1Str.length() == 0 || o2Str.length() == 0 || o3Str.length() == 0 || o4Str.length() == 0
                    || rg.getCheckedRadioButtonId() == -1) {
                Toast.makeText(intakeActivity.this, "All the fields are required", Toast.LENGTH_SHORT).show();
            }
            else{
                if(r1.isChecked()){ansStr = o1Str;}
                else if (r2.isChecked()){ansStr = o2Str;}
                else if (r3.isChecked()) {ansStr = o3Str;}
                else if(r4.isChecked()) {ansStr = o4Str;}
                else{}

                QuizData qdata = new QuizData();
                qdata.setQuestion(qnStr);
                qdata.setLocation(stateq);
                qdata.setOp1(o1Str);
                qdata.setOp2(o2Str);
                qdata.setOp3(o3Str);
                qdata.setOp4(o4Str);
                qdata.setAnswer(ansStr);
                Log.i("done", "done");

                helper.insertQuestion(qdata);
                helper.updateScore(2);

                qn.setText("");
                o1.setText("");
                o2.setText("");
                o3.setText("");
                o4.setText("");
                rg.clearCheck();
                Toast.makeText(intakeActivity.this, "Thanks for adding Knowledge :)", Toast.LENGTH_LONG).show();
            }
        }

    };
}
