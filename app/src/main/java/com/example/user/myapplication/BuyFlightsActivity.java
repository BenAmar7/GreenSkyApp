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

import java.util.ArrayList;
import java.util.List;

public class BuyFlightsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView flightsList;
    private List<Flight> flights, userFlights;
    private DataBaseHelper dbHelper;
    private ArrayAdapter<Flight> flightListAdapter;
    private String uId;
    private Button buttonGoBack;

    public void init() {
        flightsList = (ListView) findViewById(R.id.allFlightsList);
        buttonGoBack = (Button) findViewById(R.id.goBack);
        //dbHelper = new DataBaseHelper();
        flights = new ArrayList<Flight>();
        userFlights = new ArrayList<Flight>();
        flights.add(new Flight("1111", "11:00", "16:00"));
        flights.add(new Flight("2222", "12:00", "17:00"));
        flights.add(new Flight("3333", "13:00", "18:00"));
        flights.add(new Flight("4444", "14:00", "19:00"));

        for (Flight flight : flights) {
            DataBaseHelper.getInstance().getDB().child("flights").child(flight.getNumFlight()).setValue(flight);
        }

        flightListAdapter = new ArrayAdapter<Flight>(this, android.R.layout.simple_list_item_1, flights);
        flightsList.setAdapter(flightListAdapter);
        flightsList.setOnItemClickListener(this);

        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent na = new Intent(BuyFlightsActivity.this, UserActivity.class);
                finish();
                startActivity(na);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_flights);
        init();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You clicked on " + position, Toast.LENGTH_SHORT).show();
        Flight newFlight = flights.get(position);
        FirebaseUser logedInUser = DataBaseHelper.getInstance().getmAuth().getCurrentUser();
        uId = logedInUser.getUid();
        flights.get(position).addUserToList(uId);
        /*addUserToFlight(logedInUser, newFlight);
        Intent na = new Intent(UserFlightsActivity.this, MealsActivity.class);
        na.putExtra("logedInUser", logedInUser);
        Flight newFlight = flights.get(position);
        //na.putExtra("flight", newFlight);
        startActivity(na);*/
    }

    public void addUserToFlight(User user, Flight flight) {
        //flight.addUserToList(logedInUser); // need to remove the first element in the list of flights in User
        //update the database
        String path = "users/" + user.getName() + "/listFlights";
        //usersDB.child(path).setValue(flight.getNumFlight());
    }

}
