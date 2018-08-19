package com.example.user.myapplication;


import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Flight implements Serializable {
    private String numFlight;
    private String takeOff;
    private String Landing;
    private Map<String, Meal> passengersList;
    private DataBaseHelper dbHelper = new DataBaseHelper();

    public Flight() {
    }

    public Flight(String numFlight, String takeOff, String landing) {
        this.numFlight = numFlight;
        this.takeOff = takeOff;
        this.Landing = landing;
        setPassengersList(new HashMap<String, Meal>());
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public String getLanding() {
        return Landing;
    }

    public void setLanding(String landing) {
        Landing = landing;
    }

    public Map<String, Meal> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(Map<String, Meal> passengersList) {
        this.passengersList = passengersList;
    }

    public String getNumFlight() {
        return numFlight;
    }

    public void setNumFlight(String numFlight) {
        this.numFlight = numFlight;
    }

    public void addUserToList(String user) {
        this.passengersList.put(user, new Meal());
        dbHelper.getDB().child("users").child(user).child("listFilghts").child(this.getNumFlight()).setValue(this);
        dbHelper.getDB().child("flights").child(this.getNumFlight()).child("passengersList").setValue(this.getPassengersList());
    }

    @Override
    public String toString(){
        return getNumFlight();
    }

}
