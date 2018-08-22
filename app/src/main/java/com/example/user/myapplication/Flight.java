package com.example.user.myapplication;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Flight implements Serializable {
    private String numFlight;
    private String takeOff;
    private String Landing;
    private Map<String, Long> passengersList = new HashMap<>();
    //private DataBaseHelper dbHelper = new DataBaseHelper();

    public Flight() {
    }

    public Flight(String numFlight, String takeOff, String landing) {
        this.numFlight = numFlight;
        this.takeOff = takeOff;
        this.Landing = landing;
        //setPassengersList(new HashMap<String, Meal>());
    }

    public void addUserToList(String user) {
        this.passengersList.put(user, (long) 0);
        DataBaseHelper.getInstance().getDB().child("users").child(user).child("listFilghts").child(this.getNumFlight()).setValue(this);
        DataBaseHelper.getInstance().getDB().child("flights").child(this.getNumFlight()).setValue(this);
        //.child("passengersList").push().setValue(this.getPassengersList());
    }

    @Override
    public String toString() {
        return getNumFlight();
    }

    public Map<String, Long> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(Map<String, Long> passengersList) {
        this.passengersList = passengersList;
    }

    public String getNumFlight() {
        return numFlight;
    }

    public void setNumFlight(String numFlight) {
        this.numFlight = numFlight;
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
}
