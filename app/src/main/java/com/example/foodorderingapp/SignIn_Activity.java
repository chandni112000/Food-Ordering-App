package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SignIn_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_);

//        getSupportActionBar().setTitle("Sign In");

        TextView accountCreate;
        EditText gmail, pass;
        Button signIn;
        DBHelper DB;


        accountCreate = findViewById(R.id.createAccount);
        gmail = findViewById(R.id.Gmail);
        pass = findViewById(R.id.etPassword);
        signIn = findViewById(R.id.btnSignIn);
        DB = new DBHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String customergmail = gmail.getText().toString();
                String password = pass.getText().toString();
                if (customergmail.equals("") || password.equals(""))
                    Toast.makeText(SignIn_Activity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusergmaipassword(customergmail,password);
                    if (checkuserpass == true){
                        Toast.makeText(SignIn_Activity.this, "sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignIn_Activity.this , MainActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(SignIn_Activity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }



            }

        });

        accountCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignIn_Activity.this , SignUp_Activity.class);
                startActivity(intent);

            }
        });
    }
}