package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class InformationActivity extends AppCompatActivity {
    private Button mealsButton, infoButton;
    private User logedInUser;
    private Flight currentFlight;

    private void init() {
        mealsButton = (Button) findViewById(R.id.chooseMeal);
        infoButton = (Button) findViewById(R.id.watchWeather);
        logedInUser = (User) getIntent().getSerializableExtra("user");
        currentFlight = (Flight) getIntent().getSerializableExtra("flight");

        mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent na = new Intent(InformationActivity.this, MealsActivity.class);
                na.putExtra("logedInUser", logedInUser);
                na.putExtra("flight", currentFlight);
                startActivity(na);
            }
        });

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent na = new Intent(InformationActivity.this, WeatherActivity.class);
                na.putExtra("logedInUser", logedInUser);
                na.putExtra("flight", newFlight);
                startActivity(na);*/
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        init();

    }
}
