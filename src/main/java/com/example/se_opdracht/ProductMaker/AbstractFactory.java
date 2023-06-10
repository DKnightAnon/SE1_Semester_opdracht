package com.example.se_opdracht.ProductMaker;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;

import java.math.BigDecimal;

public abstract class AbstractFactory {

    public abstract ICategory createCategory();
    public abstract IProduct createProduct();
    public abstract IPurchase createPurchase(IProduct product, String date, BigDecimal price, int purchaseID);
}
