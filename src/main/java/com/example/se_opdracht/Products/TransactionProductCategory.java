package com.example.se_opdracht.Products;

public class TransactionProductCategory {
    private String categoryName;
    private int categoryID;

    public TransactionProductCategory(String categoryName, int categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {

        return categoryName;
    }
}
