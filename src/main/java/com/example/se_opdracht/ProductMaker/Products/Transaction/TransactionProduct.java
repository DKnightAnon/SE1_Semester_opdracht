package com.example.se_opdracht.ProductMaker.Products.Transaction;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;

public class TransactionProduct implements IProduct {

    private String name;
    private String description;
    private int productID;
    private ICategory category;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getProductID() {
        return this.productID;
    }

    @Override
    public void setProductID(int ID) {
        this.productID = ID;
    }

    @Override
    public ICategory getCategory() {
        return this.category;
    }

    @Override
    public void setCategory(ICategory category) {
        this.category = category;
    }

    @Override
    public void addAll(String name, String description, int productID, ICategory category) {

    }

    @Override
    public String toString() {
        return this.name;
    }

}
