package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class FlightsActivity extends AppCompatActivity {
    User logedInUser;
    Intent logInIntent;
    TextView userName, userPoints;
    public void init() {
        logInIntent = getIntent();
        logedInUser = (User) logInIntent.getSerializableExtra("user");
        userName = (TextView)findViewById(R.id.userName);
        userPoints = (TextView)findViewById(R.id.userPoints);
        userName.setText("Hello "+logedInUser.getName());
        userPoints.setText("Your sum of points is: "+logedInUser.getPoints());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filghts);
        init();

    }
}
