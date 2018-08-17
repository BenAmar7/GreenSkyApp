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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFlightsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button buttonMeals;
    private User logedInUser;
    private Intent userIntent;
    private ArrayAdapter<String> flightListAdapter;
    private ListView flightsList;
    private List<Flight> flights;

    public void init() {
        userIntent = getIntent();
        logedInUser = (User) userIntent.getSerializableExtra("logedInUser");
        flights = new ArrayList<Flight>();

        flights.add(new Flight("1111", "11:00", "16:00"));
        flights.add(new Flight("2222", "12:00", "17:00"));
        flights.add(new Flight("3333", "13:00", "18:00"));
        flights.add(new Flight("4444", "14:00", "19:00"));

        for (Flight flight : flights) {
            flight.addUserToList(logedInUser); // need to remove the first element in the list of flights in User
        }

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
        Intent na = new Intent(UserFlightsActivity.this, MealsActivity.class);
        na.putExtra("logedInUser", logedInUser);
        Flight newFlight = flights.get(position);
        na.putExtra("flight", newFlight);
        startActivity(na);
    }
}
