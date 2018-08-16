package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    User logedInUser;
    Intent logInIntent;
    TextView userName, userPoints;
    Button buttonFlights, buttonInfo;

    public void init() {
        logInIntent = getIntent();
        logedInUser = (User) logInIntent.getSerializableExtra("user");
        userName = (TextView) findViewById(R.id.userName);
        userPoints = (TextView) findViewById(R.id.userPoints);
        userName.setText("Hello " + logedInUser.getName());
        userPoints.setText("Your sum of points is: " + logedInUser.getPoints());

        buttonFlights = (Button) findViewById(R.id.watchUserFlights);
        buttonInfo = (Button) findViewById(R.id.getInformation);


        buttonFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent na = new Intent(UserActivity.this, UserFlightsActivity.class);
                na.putExtra("logedInUser",logedInUser);
                startActivity(na);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent na = new Intent(UserActivity.this, InformationActivity.class);
                startActivity(na);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init();

    }
}
