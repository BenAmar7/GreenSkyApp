package com.example.user.myapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBaseHelper {
    private FirebaseDatabase databaseGreenSky;
    private DatabaseReference DB;
    private FirebaseAuth mAuth;

    public DataBaseHelper(){
        databaseGreenSky = FirebaseDatabase.getInstance();
        DB = databaseGreenSky.getReference();
        mAuth = FirebaseAuth.getInstance();
    }

    public FirebaseDatabase getDatabaseGreenSky() {
        return databaseGreenSky;
    }

    public DatabaseReference getDB() {
        return DB;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }
}
