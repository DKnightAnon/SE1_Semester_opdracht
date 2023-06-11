package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.AbstractFactory;
import com.example.se_opdracht.ProductMaker.ProductFactory;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class ProductDBHandler extends DBConnect{
    AbstractFactory factory = new ProductFactory();


    public abstract ObservableList<IPurchase> getTransactions();
    public abstract ObservableList<IPurchase> getTransactions(IProduct product);
    public abstract ArrayList<IPurchase> getTransactionsAsArrayList(IProduct product);
    public abstract void addNewTransaction(IPurchase purchase) throws ClassNotFoundException, SQLException;

    public abstract ObservableList<ICategory> getCategories()throws SQLException, ClassNotFoundException;
    public abstract void addNewCategory(ICategory category)throws SQLException, ClassNotFoundException;

    public abstract void addNewProduct(IProduct product) throws ClassNotFoundException, SQLException;



}
