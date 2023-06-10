package com.example.se_opdracht.ProductMaker;

import com.example.se_opdracht.ProductMaker.Products.*;


import java.math.BigDecimal;

public class ProductFactory extends AbstractFactory{
    @Override
    public ICategory createCategory() {
        return new Category();
    }

    @Override
    public IProduct createProduct() {
        return new Product();
    }

    @Override
    public IPurchase createPurchase(IProduct product, String date, BigDecimal price, int purchaseID) {
        return new Purchase(product,date,price,purchaseID);
    }
}
