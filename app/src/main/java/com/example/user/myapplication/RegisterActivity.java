package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    public Button finalreg;

    public void init() {
        finalreg = (Button) findViewById(R.id.finalreg);
        finalreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fb = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(fb);

            }
        });
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);
            init();
        }
    }

