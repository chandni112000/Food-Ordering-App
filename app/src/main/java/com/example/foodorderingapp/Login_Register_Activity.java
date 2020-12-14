package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Login_Register_Activity extends AppCompatActivity {



    Button login, singnup ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__register_);
        //Transparent ActionBar
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

//        getSupportActionBar().hide();

        login = findViewById(R.id.btnlogin);
        singnup = findViewById(R.id.btnsignUp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Login_Register_Activity.this, "Login has been clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Login_Register_Activity.this, SignIn_Activity.class));
//                Intent intent = new Intent(Login_Register_Activity.this , SignIn_Activity.class);
//                startActivity(intent);
            }
        });

        singnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(MainActivity.this, "Login has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Login_Register_Activity.this , SignUp_Activity.class);
                startActivity(intent);
            }
        });

    }
}