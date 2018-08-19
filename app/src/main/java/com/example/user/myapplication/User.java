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
    //private long id;
    private String name;
    private long points;
    private List<Flight> listFlights;
    private DataBaseHelper dbHelper = new DataBaseHelper();


    public User() {
    }

    public User(String name) {
        //setId(id);
        setName(name);
        setPoints(0);
        setListFlights(Arrays.asList(new Flight[]{null}));
    }


    /* public void setId(long id) {
         this.id = id;
     }
 */
    public void setName(String name) {
        this.name = name;
    }


    public void setPoints(long points) {
        this.points = points;
    }

    public List<Flight> getListFlights() {
        return listFlights;
    }

    public void setListFlights(List<Flight> listFlights) {
        this.listFlights = listFlights;
    }

    public boolean addFlightToList(Flight flight) {
        if (this.listFlights.add(flight)) {
            dbHelper.getDB().child(getName()).setValue(listFlights);
            return true;
        } else
            return false;
    }

    /*
        public long getId() {

            return this.id;
        }
    */
    public String getName() {
        return this.name;
    }

    public long getPoints() {
        return this.points;
    }

}

