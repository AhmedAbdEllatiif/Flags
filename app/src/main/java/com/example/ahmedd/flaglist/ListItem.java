package com.example.ahmedd.flaglist;

public class ListItem {

    private int img;
    private String countryName;

    public ListItem(int img, String countryName) {
        this.img = img;
        this.countryName = countryName;
    }

    public int getImg() {
        return img;
    }

    public String getCountryName() {
        return countryName;
    }
}
