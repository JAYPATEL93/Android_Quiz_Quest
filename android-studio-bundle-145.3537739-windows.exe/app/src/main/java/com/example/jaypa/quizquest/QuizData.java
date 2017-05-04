package com.example.jaypa.quizquest;

/**
 * Created by jaypa on 3/19/2017.
 */

public class QuizData {
    int qid;
    String location, question, op1, op2, op3, op4, answer;

    public void setId(int id){this.qid = id;}
    public int getId(){return this.qid;}

    public void setLocation(String location){this.location = location;}
    public String getLocation(){return this.location;}

    public void setQuestion(String question){this.question = question;}
    public String getquestion(){return this.question;}

    public void setOp1(String op1){this.op1 = op1;}
    public String getOp1(){return this.op1;}

    public void setOp2(String op2){this.op2 = op2;}
    public String getOp2(){return this.op2;}

    public void setOp3(String op3) {this.op3 = op3;}
    public String getOp3(){return this.op3;}

    public void setOp4(String op4) {this.op4 = op4;}
    public String getOp4() {return this.op4;}

    public void setAnswer(String answer) {this.answer = answer;}
    public String getAnswer() {return this.answer;}
}