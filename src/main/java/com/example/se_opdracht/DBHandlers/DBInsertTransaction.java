package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.IPurchase;

import java.sql.SQLException;

public interface DBInsertTransaction {

    public void addTransaction(IPurchase purchase) throws ClassNotFoundException, SQLException;
}
