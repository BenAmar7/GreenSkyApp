package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BuyFlightsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView flightsList;
    private List<Flight> flights;
    private List<String> userFlights;
    private DataBaseHelper dbHelper;
    private ArrayAdapter<Flight> flightListAdapter;
    private String uId;
    private Button buttonGoBack;

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void init() {
        flightsList = (ListView) findViewById(R.id.allFlightsList);
        buttonGoBack = (Button) findViewById(R.id.goBack);
        FirebaseUser logedInUser = DataBaseHelper.getInstance().getmAuth().getCurrentUser();
        uId = logedInUser.getUid();
        flights = new ArrayList<Flight>();
        userFlights = new ArrayList<String>();

        initFlights();


        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper.getInstance().getDB().child("users").child(uId).child("listFilghts").setValue(userFlights);
                Intent na = new Intent(BuyFlightsActivity.this, UserActivity.class);
                finish();
                startActivity(na);
            }
        });
    }

    private void initFlights() {
        DataBaseHelper.getInstance().getDB().child("flights").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //ArrayList<Flight> listFlights = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Flight flight = ds.getValue(Flight.class);
                    flights.add(flight);
                }
                buildFlights(flights);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
        newFlight.addUserToList(uId);
        userFlights.add(newFlight.getNumFlight());
    }

    public void buildFlights(List<Flight> flights) {
        flightListAdapter = new ArrayAdapter<Flight>(this, android.R.layout.simple_list_item_1, flights);
        flightsList.setAdapter(flightListAdapter);
        flightsList.setOnItemClickListener(this);
    }


}
