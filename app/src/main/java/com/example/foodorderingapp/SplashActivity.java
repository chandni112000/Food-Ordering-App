package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(1000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(SplashActivity.this, Login_Register_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();


    }
}