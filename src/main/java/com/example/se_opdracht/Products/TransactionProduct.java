package com.example.se_opdracht.Products;
import java.sql.Date;

public class TransactionProduct extends Product{

    private String Category;
    private String date;
    private String Vendor;
    private int ID;
    //Need to find a way to add dates. Initial research shows Date is a class in Java.

    public TransactionProduct(int ID, String date,String Vendor, String name, String Description, String Category) {
        super(name, Description);
        this.date = date;
        this.Category = Category;
        this.ID = ID;
        this.Vendor = Vendor;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


}
