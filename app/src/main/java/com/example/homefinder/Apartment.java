package com.example.homefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Apartment {

    int images;
    String bedroom;
    String bathroom;
    int price_per_month;
    int area;
    String location;
    private double rating;

    public Apartment(int images, String bedroom, String bathroom, int price_per_month, int area, String location, double rating) {
        this.images = images;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.price_per_month = price_per_month;
        this.area = area;
        this.location = location;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }



    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public int getPrice_per_month() {
        return price_per_month;
    }

    public void setPrice_per_month(int price_per_month) {
        this.price_per_month = price_per_month;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
