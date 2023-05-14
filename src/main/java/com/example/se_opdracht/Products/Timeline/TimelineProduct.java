package com.example.se_opdracht.Products.Timeline;

import com.example.se_opdracht.Products.Product;

import java.math.BigDecimal;

public class TimelineProduct extends Product {
    public TimelineProduct(String name,
                           String Description,
                           String category,
                           int productID) {
        super(name, Description);
        this.Category = category;
        this.productID = productID;
    }

    public TimelineProduct(String name, String category, int productID){
        super(name);
        this.Category = category;
        this.productID = productID;

    }


    private String Category;

    private int productID;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }


    @Override
    public String toString(){
        return super.getName();
    }


}
