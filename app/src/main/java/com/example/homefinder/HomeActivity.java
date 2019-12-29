package com.example.homefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    //el moshkela htkon hena azon

    public void gotoLoginActivity(View v){
        Intent mainIntent = new Intent(this, LoginActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }

    public void gotoSignUpActivity(View v){
        Intent mainIntent = new Intent(this, SignUpActivity.class);
        this.startActivity(mainIntent);
        this.finish();
    }
}
