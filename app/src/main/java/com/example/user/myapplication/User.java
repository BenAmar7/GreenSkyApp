package com.example.user.myapplication;

import android.support.annotation.NonNull;

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
    private long id;
    private String name;
    private String password;
    private long points;
    private List<String> listFlights;
    //private FirebaseDatabase databaseGreenSky = FirebaseDatabase.getInstance();
    //private DatabaseReference usersDB = databaseGreenSky.getReference();


    public User() {
    }

    public User(String name, String password, long id) {
        setId(id);
        setName(name);
        setPassword(password);
        setPoints(0);
        setListFlights(Arrays.asList(new String[]{" "}));
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public List<String> getListFlights() {
        return listFlights;
    }

    public void setListFlights(List<String> listFlights) {
        this.listFlights = listFlights;
    }

    public boolean addFlightToList(String flight) {
        if (this.listFlights.add(flight)) {

            return true;
        }
        else
            return false;
    }

    public long getId() {

        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public long getPoints() {
        return this.points;
    }

}

