package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDBRetrieve {

    public ArrayList<IProduct> getProductsAsArrayList() throws ClassNotFoundException;

    public ObservableList<IProduct> getProducts();

    public ArrayList<ICategory> getCategoriesAsArrayList();

    public ObservableList<ICategory> getCategories()throws SQLException, ClassNotFoundException;
}
