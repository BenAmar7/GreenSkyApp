package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    //private DataBaseHelper dbHelper;
    private FirebaseUser logedInUser;
    private User user;
    private Intent logInIntent;
    private TextView userName, userPoints;
    private Button buttonFlights, buttonInfo, buttonBuyFlights;
    private List<User> allUsers = new ArrayList<>();

    public void init() {
        logInIntent = getIntent();
        //dbHelper = new DataBaseHelper();

        userName = (TextView) findViewById(R.id.userName);
        userPoints = (TextView) findViewById(R.id.userPoints);


        buttonFlights = (Button) findViewById(R.id.watchUserFlights);
        buttonInfo = (Button) findViewById(R.id.getInformation);
        buttonBuyFlights = (Button) findViewById(R.id.buyFlights);

        buttonFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent na = new Intent(UserActivity.this, UserFlightsActivity.class);
                na.putExtra("user", user);
                startActivity(na);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent na = new Intent(UserActivity.this, InformationActivity.class);
                startActivity(na);
            }
        });

        buttonBuyFlights.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent na = new Intent(UserActivity.this, BuyFlightsActivity.class);
                startActivity(na);
            }
        });

        /*dbHelper.getUsersDB().child("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    User newUser = child.getValue(User.class);
                    allUsers.add(newUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });s
*/
        logedInUser = DataBaseHelper.getInstance().getmAuth().getCurrentUser();
        String uid = logedInUser.getUid();
        getUserFromDB(uid);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init();

    }

    public void getLogInUser() {
        userName.setText("Hello " + user.getName());
        userPoints.setText("Your sum of points is: " + user.getPoints());
    }

    public void getUserFromDB(String uId) {
        DataBaseHelper.getInstance().getDB().child("users").child(uId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    ArrayList<Flight> listFlights = new ArrayList<>();
                    user = dataSnapshot.getValue(User.class);
                    Object obj = dataSnapshot.getValue(User.class);
                    for (DataSnapshot snapChild : dataSnapshot.getChildren()) {
                        for (DataSnapshot snapGrandChild : snapChild.getChildren()) {
                            Flight flight = snapGrandChild.getValue(Flight.class);
                            listFlights.add(flight);
                        }
                    }
                    user.setListFlights(listFlights);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //DataBaseHelper.getInstance().getDB().child("users").child(user.getName()).child("listFlights").getKey();
                //user.setListFlights(DataBaseHelper.getInstance().getDB().child("users").child(user.getName()).child("listFlights").getKey());
                getLogInUser();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

/*
    public void getUserFromDB(final String userID, final ProfileActivity activity){
        dbRef.child(USERS).child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                activity.setUser(user);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError Object ){

            }
        });
    }*/

}
