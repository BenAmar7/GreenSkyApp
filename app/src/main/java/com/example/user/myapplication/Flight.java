package com.example.user.myapplication;


import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Flight implements Serializable {
    private String numFlight;
    private String takeOff;
    private String Landing;
    private Map<User, Meal> passengersList;

    public Flight() {
    }

    public Flight(String numFlight, String takeOff, String landing) {
        this.numFlight = numFlight;
        this.takeOff = takeOff;
        this.Landing = landing;
        setPassengersList(new LinkedHashMap<User, Meal>());
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

    public Map<User, Meal> getPassengersList() {
        return passengersList;
    }

    public void setPassengersList(Map<User, Meal> passengersList) {
        this.passengersList = passengersList;
    }

    public String getNumFlight() {
        return numFlight;
    }

    public void setNumFlight(String numFlight) {
        this.numFlight = numFlight;
    }

    public void addUserToList(User user) {
        this.passengersList.put(user, new Meal());
        user.addFlightToList(this.getNumFlight());
    }

}
