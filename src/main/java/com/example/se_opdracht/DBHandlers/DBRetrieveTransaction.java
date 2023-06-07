package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface DBRetrieveTransaction {

    public ObservableList<IPurchase> getTransactions(IProduct product);
    public ArrayList<IPurchase> getTransactionsAsArrayList(IProduct product);

}
