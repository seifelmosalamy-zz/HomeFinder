package com.example.homefinder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FragmentActivity fragment;
    RecyclerView recyclerView ;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Apartment> apartmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_feed, R.id.navigation_search, R.id.navigation_saves, R.id.navigation_alerts, R.id.navigation_more)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        getSupportActionBar().hide();



        recyclerView = findViewById(R.id.recycle_view);
        apartmentList = new ArrayList<>();
        int []image ={R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download};

        for (int i=0;i<10;i++){

            apartmentList.add(new Apartment(image[i],"Bedroom: "+i,  "Bathroom: "+i,i*200,i*60, "Cairo,Nasr city,Makram Ebied", 4.5));
        }

        recyclerViewAdapter = new RecyclerViewAdapter(apartmentList);
        layoutManager = new LinearLayoutManager(this);
        try{
            recyclerView.setAdapter(recyclerViewAdapter);

        }
        catch(NullPointerException ignored){

        }
        try{
            recyclerView.setLayoutManager(layoutManager);
        }
        catch(NullPointerException ignored){

        }


    }

    public void MapFragment(View view) {
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_feed, R.id.navigation_search, R.id.navigation_saves, R.id.navigation_alerts, R.id.navigation_more)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.map);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);
//        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recycle_view);
        apartmentList = new ArrayList<>();
        int []image ={R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download};

        for (int i=0;i<10;i++){

            apartmentList.add(new Apartment(image[i],"Bedroom: "+i,  "Bathroom: "+i,i*200,i*60, "Cairo,Nasr city,Makram Ebied", 4.5));
        }

        recyclerViewAdapter = new RecyclerViewAdapter(apartmentList);
        layoutManager = new LinearLayoutManager(this);
        try{
            recyclerView.setAdapter(recyclerViewAdapter);

        }
        catch(NullPointerException ignored){

        }
        try{
            recyclerView.setLayoutManager(layoutManager);
        }
        catch(NullPointerException ignored){

        }

    }
}
