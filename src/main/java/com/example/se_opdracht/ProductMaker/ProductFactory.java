package com.example.se_opdracht.ProductMaker;

import com.example.se_opdracht.ProductMaker.Products.*;


import java.math.BigDecimal;

public class ProductFactory extends AbstractFactory{
    @Override
    public ICategory createCategory(String categoryName, int CategoryID) {
        return new Category(categoryName, CategoryID);
    }

    @Override
    public IProduct createProduct(String name, String description, int productID, ICategory category) {
        return new Product(name, description, productID, category);
    }

    @Override
    public IPurchase createPurchase(IProduct product, String date, BigDecimal price, int purchaseID) {
        return new Purchase(product,date,price,purchaseID);
    }
}
