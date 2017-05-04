package com.example.jaypa.quizquest;

/**
 * Created by jaypa on 2/11/2017.
 */

public class LoginData {
    int id, score;
    String email, username, password;

    public void setId(int id){this.id = id;}
    public int getId(){return this.id;}

    public void setScore(int score){this.score = score;}
    public int getScore() {return this.score;}

    public void setUsername(String username){this.username = username;}
    public String getUsername(){return this.username;}

    public void setPassword(String password){this.password = password;}
    public String getPassword(){return this.password;}

    public void setEmail(String email){this.email = email;}
    public String getEmail(){return this.email;}
}
