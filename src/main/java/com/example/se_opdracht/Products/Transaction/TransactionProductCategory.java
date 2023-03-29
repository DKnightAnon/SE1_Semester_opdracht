package com.example.se_opdracht.Products.Transaction;

import com.example.se_opdracht.Products.ProductCategory;

public class TransactionProductCategory extends ProductCategory {

    public TransactionProductCategory(String categoryName, int categoryID) {
        super(categoryName,categoryID);

    }
    @Override
    public String toString() {
        return super.getCategoryName();
    }
}
