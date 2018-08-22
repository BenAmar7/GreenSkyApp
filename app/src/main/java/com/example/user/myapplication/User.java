package com.example.user.myapplication;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class User implements Serializable {
    //private long id;
    private String name;
    private long points;
    private ArrayList<Flight> listFlights = new ArrayList<>();
    //private DataBaseHelper dbHelper = new DataBaseHelper();


    public User() {
    }

    public User(String name) {
        //setId(id);
        setName(name);
        setPoints(0);
        //setListFlights(new ArrayList<Flight>());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public void setListFlights(ArrayList<Flight> listFlights) {
        this.listFlights = listFlights;
    }

    public void updateFlight(Flight flight,long points){
        for (Flight flightsUser :listFlights) {
            if (flightsUser.getNumFlight().equals(flight.getNumFlight())){
                flightsUser.getPassengersList().put(this.getName(),points);
                break;
            }
        }
    }

    public ArrayList<Flight> getListFlights() {
        return this.listFlights;
    }

    public String getName() {
        return this.name;
    }

    public long getPoints() {
        return this.points;
    }

}

