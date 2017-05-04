package com.example.jaypa.quizquest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.ViewDebug;

/**
 * Created by jaypa on 2/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    static String urname;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    Cursor cursor10;
    public static Boolean questionsExit = false;
    public static int questionCounter = 0;
    public String topScore1 = "";
    public String topScore2 = "";
    public String topScore3 = "";
    public String topScore4 = "";
    public String topScore5 = "";

    public String topScore11 = "";
    public String topScore22= "";
    public String topScore33 = "";
    public String topScore44 = "";
    public String topScore55 = "";


    //contact inforamation table
    private static final String TABLE_CONTACT = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_SCORE = "score";

    //quiz question table
    private static final String TABLE_QUIZ = "quiz";
    private static final String COLUMN_QID = "qid";
    private static final String COLUMN_LOCATION = "location";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_OP1 = "op1";
    private static final String COLUMN_OP2 = "op2";
    private static final String COLUMN_OP3 = "op3";
    private static final String COLUMN_OP4 = "op4";
    private static final String COLUMN_ANS = "answer";

    SQLiteDatabase db;
    Cursor stateCursor;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String TABLE_CREATE_CONTACT = "create table " + TABLE_CONTACT +
            "(id integer primary key not null, score integer not null," +
            "username text not null, password text not null, email text not null);";

    private static final String TABLE_CREATE_QUIZ = "create table " + TABLE_QUIZ +
            "(qid integer primary key not null, location text not null," +
            "question text not null, op1 text not null, op2 text not null, op3 text not null," +
            "op4 text not null, answer text not null);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_CONTACT);
        db.execSQL(TABLE_CREATE_QUIZ);
        this.db = db;
    }

    public void insertContact(LoginData d){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_CONTACT;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        int score = d.getScore();

        Log.i("cursor", Integer.toString(count));
        values.put (COLUMN_ID, count);
        values.put(COLUMN_USERNAME, d.getUsername());
        values.put(COLUMN_PASSWORD, d.getPassword());
        values.put(COLUMN_EMAIL, d.getEmail());
        values.put(COLUMN_SCORE, score);

        db.insert(TABLE_CONTACT, null, values);
        db.close();
    }

    public String searchPass(String userStr){
        db = this.getReadableDatabase();
        String query = "select username, password from "+TABLE_CONTACT;
        Cursor cursor = db.rawQuery(query, null);
        String u, p;
        p = "not found";
        if(cursor.moveToFirst()){
            do{
                u = cursor.getString(0);

                if (u.equals(userStr)){
                    p = cursor.getString(1);
                    urname = userStr;
                    Log.i("urname", urname);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return p;
    }

    // inserting a question from user
    public void insertQuestion(QuizData q){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_QUIZ;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_QID, count);
        values.put(COLUMN_LOCATION, q.getLocation());
        values.put(COLUMN_QUESTION, q.getquestion());
        values.put(COLUMN_OP1, q.getOp1());
        values.put(COLUMN_OP2, q.getOp2());
        values.put(COLUMN_OP3, q.getOp3());
        values.put(COLUMN_OP4, q.getOp4());
        values.put(COLUMN_ANS, q.getAnswer());

        db.insert(TABLE_QUIZ, null, values);
        db.close();
    }

    public int searchScore(String userStr){
        db = this.getReadableDatabase();
        String query = "select username, score from "+ TABLE_CONTACT;
        Cursor cursor = db.rawQuery(query, null);
        String u;
        int p = 0;
        if (cursor.moveToFirst()){
            do{
                u = cursor.getString(0);
                if (u.equals(userStr)){
                    p = cursor.getInt(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        Log.i("STRING",userStr);
        return p;
    }

    public void updateScore(int score){
        int currentScore = searchScore(urname);
        int updatedScore = currentScore + score;

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE, updatedScore);

        db.update(TABLE_CONTACT, values,"username = ?",new String[] {urname});
        db.close();
        //Log.i("score", Integer.toString(searchScore(urname)));
    }

    public void getTopTen(){
        db = this.getReadableDatabase();
        String query = "Select username, score from " + TABLE_CONTACT + " ORDER BY score DESC LIMIT 5";
        cursor10 = db.rawQuery(query, null);

        if (cursor10.moveToFirst()){
            topScore1 = cursor10.getString(0); topScore11 = cursor10.getString(1);
            if (cursor10.moveToNext())
                topScore2 = cursor10.getString(0); topScore22 = cursor10.getString(1);
            if (cursor10.moveToNext())
                topScore3 = cursor10.getString(0); topScore33 = cursor10.getString(1);
            if (cursor10.moveToNext())
                topScore4 = cursor10.getString(0); topScore44 = cursor10.getString(1);
            if (cursor10.moveToNext())
                topScore5 = cursor10.getString(0); topScore55 = cursor10.getString(1);
        }
    }

    // getting a cursor for user selected state
    public void getstatequestions(String state){
        state = '"' + state + '"';
        db = this.getReadableDatabase();
        String query = "select question, answer, op1, op2, op3, op4 from " + TABLE_QUIZ + " where location=" + state;
        stateCursor = db.rawQuery(query, null);
    }

    public void checkifEmptyquizDatabase(){
        db = this.getReadableDatabase();
        String query = "select * from " + TABLE_QUIZ;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                questionCounter ++;
            }while(cursor.moveToNext());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_QUIZ);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACT);
        this.onCreate(db);
    }
}
