package com.example.se_opdracht.Products.Timeline;

import java.math.BigDecimal;

public class TimelineProductPurchase {
    private int PurchaseID;
    private String PurchaseDate;
    private BigDecimal PurchasePrice;
    private int PurchaseProductID;

    public TimelineProductPurchase(int purchaseID, String purchaseDate, BigDecimal purchasePrice, int purchaseProductID) {
        PurchaseID = purchaseID;
        PurchaseDate = purchaseDate;
        PurchasePrice = purchasePrice;
        PurchaseProductID = purchaseProductID;
    }

    public int getPurchaseID() {
        return PurchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        PurchaseID = purchaseID;
    }

    public String getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public BigDecimal getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public int getPurchaseProductID() {
        return PurchaseProductID;
    }

    public void setPurchaseProductID(int purchaseProductID) {
        PurchaseProductID = purchaseProductID;
    }
}
