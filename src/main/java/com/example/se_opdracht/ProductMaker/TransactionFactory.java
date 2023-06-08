package com.example.se_opdracht.ProductMaker;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionCategory;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionProduct;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionPurchase;

import java.math.BigDecimal;

public class TransactionFactory extends AbstractFactory{
    @Override
    public ICategory createCategory() {
        return new TransactionCategory();
    }

    @Override
    public IProduct createProduct() {
        return new TransactionProduct();
    }

    @Override
    public IPurchase createPurchase() {
        return new TransactionPurchase();
    }

    @Override
    public IPurchase createPurchase(IProduct product, String date, BigDecimal price) {
        return null;
    }
}
