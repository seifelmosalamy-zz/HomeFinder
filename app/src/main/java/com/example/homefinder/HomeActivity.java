package com.example.homefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

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
