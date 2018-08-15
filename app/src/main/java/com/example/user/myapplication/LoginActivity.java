package com.example.user.myapplication;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    public Button regButton, logInButton;
    private FirebaseDatabase databaseGreenSky;
    private DatabaseReference usersDB;
    private EditText textName, textPassword;
    private long id, points;
    private String name, password;
    private List<User> allUsers = new ArrayList<>();

    public void init() {
        regButton = (Button) findViewById(R.id.regButton);
        logInButton = (Button) findViewById(R.id.logInButton);
        textName = (EditText) findViewById(R.id.logInUserName);
        textPassword = (EditText) findViewById(R.id.logInPassword);
        databaseGreenSky = FirebaseDatabase.getInstance();
        usersDB = databaseGreenSky.getReference();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rb = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(rb);
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUsersData();
            }
        });

        usersDB.child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    User newUser = child.getValue(User.class);
                    allUsers.add(newUser);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }

    public void getUsersData() {
        name = textName.getText().toString();
        password = textPassword.getText().toString();
        for (User user : allUsers) {
            if((name.equals(user.getName()))&&(password.equals(user.getPassword()))){
                moveToNextActivity(user);
            }
        }
    }

    public void moveToNextActivity(User user) {
        Intent na = new Intent(LoginActivity.this, FlightsActivity.class);
        na.putExtra("user",  user);
        startActivity(na);
    }


}
