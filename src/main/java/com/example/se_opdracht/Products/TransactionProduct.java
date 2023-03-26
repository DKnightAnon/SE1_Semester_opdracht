package com.example.se_opdracht.Products;
import java.sql.Date;

public class TransactionProduct extends Product{

    private String Category;
    private String Date;
    private int ID;
    //Need to find a way to add dates. Initial research shows Date is a class in Java.

    public TransactionProduct(int ID, String date , String name, String Description, String Category) {
        super(name, Description);
        this.Date = date;
        this.Category = Category;
        this.ID = ID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
