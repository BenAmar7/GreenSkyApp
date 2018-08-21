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

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserFlightsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private User logedInUser;
    private Intent userIntent;
    private ArrayAdapter<Flight> flightListAdapter;
    private DataBaseHelper dbHelper = DataBaseHelper.getInstance();
    private List<Flight> listFlights;
    private ListView flightsList;

    public void init() {
        userIntent = getIntent();
        logedInUser = (User) userIntent.getSerializableExtra("user");
        flightsList = (ListView) findViewById(R.id.userFlightsList);

        listFlights =logedInUser.getListFlights();

        flightListAdapter = new ArrayAdapter<Flight>(this, android.R.layout.simple_list_item_1, listFlights);
        flightsList.setAdapter(flightListAdapter);
        flightsList.setOnItemClickListener(this);

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
        Flight newFlight = logedInUser.getListFlights().get(position);
        Intent na = new Intent(UserFlightsActivity.this, InformationActivity.class);
        na.putExtra("logedInUser", logedInUser);
        na.putExtra("flight", newFlight);
        startActivity(na);
    }


}
