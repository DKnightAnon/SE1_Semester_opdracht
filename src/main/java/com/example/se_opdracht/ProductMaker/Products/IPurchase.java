package com.example.se_opdracht.ProductMaker.Products;

import java.math.BigDecimal;

public interface IPurchase {

    public ICategory getCategory();
    public void setCategory(ICategory category);

    public IProduct getProduct();
    public void setProduct(IProduct product);

    public String getDate();
    public void setDate(String date);

    public BigDecimal getPrice();
    public void setPrice(BigDecimal price);

    public int getPurchaseID();
    public void setPurchaseID(int id);

    public void addAll(IProduct product, ICategory category, String date, BigDecimal price, int purchaseID);

}
