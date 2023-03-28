package com.example.se_opdracht.Products.Timeline;

public class TimelineProductCategory {


    public TimelineProductCategory(int categoryID, int catergoryName) {
        this.categoryID = categoryID;
        this.catergoryName = catergoryName;
    }

    private int categoryID;
    private int catergoryName;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getCatergoryName() {
        return catergoryName;
    }

    public void setCatergoryName(int catergoryName) {
        this.catergoryName = catergoryName;
    }
}
