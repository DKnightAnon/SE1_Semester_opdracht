package com.example.se_opdracht.ProductMaker;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineCategory;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelinePurchase;

import java.math.BigDecimal;

public class TimelineFactory extends AbstractFactory{
    @Override
    public ICategory createCategory() {
        return new TimelineCategory();
    }

    @Override
    public IProduct createProduct() {
        return new TimelineProduct();
    }

    @Override
    public IPurchase createPurchase() {
        return new TimelinePurchase();
    }

    public IPurchase createPurchase(IProduct product, String date, BigDecimal price) {
        IPurchase purchase = createPurchase();
        purchase.setProduct(product);
        purchase.setCategory(product.getCategory());
        purchase.setDate(date);
        purchase.setPrice(price);
        return purchase;
    }
}
