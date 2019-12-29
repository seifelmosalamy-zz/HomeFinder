package com.example.homefinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }


    public void leasePressed(View v){
        Intent mainIntent = new Intent(this, LeaseActivity.class);
        this.startActivity(mainIntent);
    }

    public void rentPressed(View v){
        Intent mainIntent = new Intent(this, MainActivity.class);
        this.startActivity(mainIntent);
    }

}
