package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private User user;
    private static long userId = 1;
    private Button finalReg;
    private boolean regComplete;
    private EditText textName, textPassword, textVerifyPassword;
    private String name, password, verifyPassword;
    private FirebaseDatabase databaseGreenSky;
    private DatabaseReference usersDB;

    public void init() {
        finalReg = (Button) findViewById(R.id.finalReg);
        textName = (EditText) findViewById(R.id.userName);
        textPassword = (EditText) findViewById(R.id.password);
        textVerifyPassword = (EditText) findViewById(R.id.verifyPassword);

        databaseGreenSky = FirebaseDatabase.getInstance();
        usersDB = databaseGreenSky.getReference();


        finalReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkingRegistration();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    protected void checkingRegistration() {
        name = textName.getText().toString();
        password = textPassword.getText().toString();
        verifyPassword = textVerifyPassword.getText().toString();

        if (password.equals(verifyPassword)) {
            regComplete = true;
            user = new User(name, password,userId);
            usersDB.child("users").push().setValue(user);
            userId++;
        } else {
            regComplete = false;

        }
        if (regComplete) {
            try{
                Intent fb = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(fb);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
