package com.example.foodorderingapp.Models;

import androidx.appcompat.app.AppCompatActivity;

public class LoginModel extends AppCompatActivity {

    String Gmail,password;

    public LoginModel(String gmail, String password) {
        Gmail = gmail;
        this.password = password;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
