package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

   public Button regbutton;
   public void init(){
       regbutton = (Button)findViewById(R.id.regbutton);
       regbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent rb = new Intent(LoginActivity.this,RegisterActivity.class);
               startActivity(rb);

           }
       });
   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        try {
            /*ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    User user = dataSnapshot.getValue(User.class);
                    // ...
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    //Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    // ...
                }
            };
            databaseReference.addValueEventListener(postListener);*/
            //User user1 = new User("eran");
            //User user2 = new User("zahavi");
            //databaseReference.child("Users").child(""+user1.getID()).setValue(user1);
            //databaseReference.child("Users").child(""+user2.getID()).setValue(user2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
