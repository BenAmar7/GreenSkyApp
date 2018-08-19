package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
    private DataBaseHelper dbHelper;
    private FirebaseUser logedInUser;
    private User user;
    private Intent logInIntent;
    private TextView userName, userPoints;
    private Button buttonFlights, buttonInfo;
    private List<User> allUsers = new ArrayList<>();

    public void init() {
        logInIntent = getIntent();
        dbHelper = new DataBaseHelper();

        userName = (TextView) findViewById(R.id.userName);
        userPoints = (TextView) findViewById(R.id.userPoints);


        buttonFlights = (Button) findViewById(R.id.watchUserFlights);
        buttonInfo = (Button) findViewById(R.id.getInformation);


        buttonFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent na = new Intent(UserActivity.this, UserFlightsActivity.class);
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
        logedInUser = dbHelper.getmAuth().getCurrentUser();
        String uid = logedInUser.getUid();
        user = new User(uid);
        dbHelper.getDB().child("users").child(uid).setValue(user);
        userName.setText("Hello " + user.getName());
        userPoints.setText("Your sum of points is: " + user.getPoints());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        init();

    }


}
