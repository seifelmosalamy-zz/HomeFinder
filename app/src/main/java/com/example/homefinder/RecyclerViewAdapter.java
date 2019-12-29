
package com.example.homefinder;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    List<Apartment> apartmentList;

    public RecyclerViewAdapter(List<Apartment> apartmentList) {
        this.apartmentList = apartmentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_apartment,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Apartment apartment = apartmentList.get(position);
        holder.location.setText(apartment.getLocation());
        holder.bedroom.setText(apartment.getBedroom());
        holder.bathroom.setText(apartment.getBathroom());
        holder.area.setText(apartment.getArea());
        holder.textViewRating.setText(String.valueOf(apartment.getRating()));
        holder.price_per_month.setText(String.valueOf(apartment.getPrice_per_month()));
        holder.image.setImageResource(apartment.getImages());
    }

    @Override
    public int getItemCount() {
        if (apartmentList == null)return 0;
        return apartmentList.size();
    }

    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {

        TextView location,textViewRating;
        TextView bedroom;
        TextView bathroom;
        TextView area;
        TextView price_per_month;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.textViewTitle);
            bedroom = itemView.findViewById(R.id.textViewShortDesc);
//            bathroom = itemView.findViewById(R.id.bathroom);
//            area = itemView.findViewById(R.id.area);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            price_per_month = itemView.findViewById(R.id.textViewPrice);
            image = itemView.findViewById(R.id.imageViewR);
        }
    }
}

