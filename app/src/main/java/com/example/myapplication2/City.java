package com.example.myapplication2;

public class City {
    private final String name;
    private int imageResId;

    public City(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
