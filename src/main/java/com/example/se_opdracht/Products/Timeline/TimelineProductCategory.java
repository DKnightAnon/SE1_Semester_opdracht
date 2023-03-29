package com.example.se_opdracht.Products.Timeline;

import com.example.se_opdracht.Products.ProductCategory;

public class TimelineProductCategory extends ProductCategory {


    public TimelineProductCategory(int categoryID, String catergoryName) {

        super(catergoryName,categoryID);
    }

    @Override
    public String toString(){
        return super.getCategoryName();
    }
}
