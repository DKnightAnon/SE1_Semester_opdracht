package com.example.se_opdracht.ProductMaker.Products.Transaction;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;

import java.math.BigDecimal;

public class TransactionPurchase implements IPurchase {

    private ICategory category;
    private IProduct product;
    private String date;
    private BigDecimal price;

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
}
