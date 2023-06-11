package com.example.se_opdracht.ProductMaker.Products;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;

import java.math.BigDecimal;

public class Purchase implements IPurchase {

    private ICategory category;
    private IProduct product;
    private String date;
    private BigDecimal price;
    private int PurchaseID;
    private String description;

    public Purchase(IProduct product, String date, BigDecimal price, int purchaseID) {
        this.product = product;
        this.category = product.getCategory();
        this.date = date;
        this.price = price;
        PurchaseID = purchaseID;
        this.description= product.getDescription();
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
    public IProduct getProduct() {
        return this.product;
    }

    @Override
    public void setProduct(IProduct product) {
        this.product = product;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int getPurchaseID() {
        return this.PurchaseID;
    }

    @Override
    public void setPurchaseID(int id) {
        this.PurchaseID = id;

    }

    public String getDescription() {
        return description;
    }

    public void addAll(IProduct product, ICategory category, String date, BigDecimal price, int purchaseID){
        this.product = product;
        this.category = category;
        this.date = date;
        this.price = price;
    }

}
