package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class UserFlightsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button buttonMeals;
    private User logedInUser;
    private Intent userIntent;
    private ArrayAdapter<String> flightListAdapter;
    private ListView flightsList;

    public void init() {
        userIntent = getIntent();
        logedInUser = (User) userIntent.getSerializableExtra("logedInUser");

        logedInUser.addFlightToList("flight1");
        logedInUser.addFlightToList("flight2");
        logedInUser.addFlightToList("flight3");
        logedInUser.addFlightToList("flight4");

        flightsList = (ListView) findViewById(R.id.flightsList);

        flightListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, logedInUser.getListFlights());
        flightsList.setAdapter(flightListAdapter);
        flightsList.setOnItemClickListener(this);


        /*buttonMeals = (Button) findViewById(R.id.chooseMeal);
        buttonMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_flights);
        init();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You clicked on " + position, Toast.LENGTH_SHORT).show();
    }
}
