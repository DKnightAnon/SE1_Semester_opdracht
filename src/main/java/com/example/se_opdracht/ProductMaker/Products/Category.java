package com.example.se_opdracht.ProductMaker.Products;

import com.example.se_opdracht.ProductMaker.Products.ICategory;

public class Category implements ICategory {

    private String CategoryName;
    private int CategoryID;

    public Category() {
    }

    public Category(String categoryName, int categoryID) {
        CategoryName = categoryName;
        CategoryID = categoryID;
    }

    @Override
    public String getCategoryName() {
        return this.CategoryName;
    }

    @Override
    public void setCategoryName(String name) {
        this.CategoryName = name;
    }



    @Override
    public int getCategoryID() {
        return this.CategoryID;
    }

    @Override
    public void setCategoryID(int id) {
        this.CategoryID = id;
    }

    @Override
    public void addAll(String name, int id) {
        this.CategoryName = name;
        this.CategoryID = id;
    }

    @Override
    public String toString(){
        return this.CategoryName;
    }
}
