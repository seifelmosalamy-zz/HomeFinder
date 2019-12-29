package com.example.homefinder.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homefinder.Apartment;
import com.example.homefinder.MainActivity;
import com.example.homefinder.R;
import com.example.homefinder.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FeedFragment extends Fragment {

    private FeedViewModel feedViewModel;

    FragmentActivity fragment;
    RecyclerView recyclerView ;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Apartment> apartmentList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        feedViewModel = ViewModelProviders.of(this).get(FeedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_feed, container, false);
        /*final TextView textView = root.findViewById(R.id.text_feed);
        feedViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        final FragmentActivity c = getActivity();
        recyclerView = root.findViewById(R.id.recycle_view);
        apartmentList = new ArrayList<>();
        int []image ={R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download};

        for (int i=0;i<10;i++){

            apartmentList.add(new Apartment(image[i],"Bedroom: "+i,  "Bathroom: "+i,i*200,i*60, "Cairo,Nasr city,Makram Ebied", 4.5));
        }

        recyclerViewAdapter = new RecyclerViewAdapter(apartmentList);
        layoutManager = new LinearLayoutManager(c);
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


        return root;
    }
}