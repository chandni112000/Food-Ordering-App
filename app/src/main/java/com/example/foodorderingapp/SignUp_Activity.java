package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;


public class SignUp_Activity extends AppCompatActivity {

    EditText customerName , PhoneNo , gmail, password  ;
    EditText cfpassword;
    Button register;
    ProgressBar progressBar;
//    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

//        getSupportActionBar().setTitle("Sign Up");
        DBHelper db;


        register = findViewById(R.id.btnRegister);
        customerName = (EditText) findViewById(R.id.UserName);
        PhoneNo = findViewById(R.id.etPhone);
        gmail = findViewById(R.id.Gmail);
        password = findViewById(R.id.etPassword);
        cfpassword = findViewById(R.id.confirmPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

//        firebaseAuth = FirebaseAuth.getInstance();


//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String customergmail = gmail.getText().toString();
//                String pass = password.getText().toString();
//                String repass = cfpassword.getText().toString();
//
//
//                if(TextUtils.isEmpty(customergmail)){
//                    Toast.makeText(SignUp_Activity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                 if(TextUtils.isEmpty(pass)){
//                    Toast.makeText(SignUp_Activity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//               if(TextUtils.isEmpty(repass)){
//                    Toast.makeText(SignUp_Activity.this, "Please confirm password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if (password.length()<3){
//                    Toast.makeText(SignUp_Activity.this, "Password too short", Toast.LENGTH_SHORT).show();
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//
//                if(pass.equals(repass)){
//                    firebaseAuth.createUserWithEmailAndPassword(customergmail, pass)
//                            .addOnCompleteListener(SignUp_Activity.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                                    progressBar.setVisibility(View.GONE);
//
//                                    if (!task.isSuccessful()) {
//                                        Toast.makeText(SignUp_Activity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
//
//                                    } else {
//
//                                        Toast.makeText(SignUp_Activity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(getApplicationContext(),SignIn_Activity.class));
//                                    }
//                                }
//                            });
//                }
//
//
//
//            }
//        });
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