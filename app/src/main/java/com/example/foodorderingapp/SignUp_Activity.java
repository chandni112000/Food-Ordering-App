package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignUp_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

//        getSupportActionBar().setTitle("Sign Up");
        EditText customerName , PhoneNo , gmail, password  ;
        EditText cfpassword;
        Button register;
        DBHelper db;


        register = findViewById(R.id.btnRegister);
        customerName = (EditText) findViewById(R.id.UserName);
        PhoneNo = findViewById(R.id.etPhone);
        gmail = findViewById(R.id.Gmail);
        password = findViewById(R.id.etPassword);
        cfpassword = findViewById(R.id.confirmPassword);
        db = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customergmail = gmail.getText().toString();
                String pass = password.getText().toString();
                String repass = cfpassword.getText().toString();

                if (customergmail.equals("")||pass.equals("") || repass.equals(""))
                    Toast.makeText(SignUp_Activity.this, "Please Enter emailId , password and confirm password fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = db.checkusergmail(customergmail);
                        if (checkuser == false){
                            Boolean insert = db.insertData(customergmail,pass);
                            if(insert == true){
                                Toast.makeText(SignUp_Activity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp_Activity.this , SignIn_Activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUp_Activity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp_Activity.this, "User already exist! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SignUp_Activity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        TextView accountCreate;

        accountCreate = findViewById(R.id.createAccount);

        accountCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp_Activity.this , SignIn_Activity.class);
                startActivity(intent);
            }
        });
    }
}