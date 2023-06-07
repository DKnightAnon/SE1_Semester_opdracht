package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;

import java.sql.SQLException;

public interface IDBInsert {

    public void addNewCategory(ICategory category) throws SQLException, ClassNotFoundException;

    public void addNewProduct(IProduct product) throws ClassNotFoundException, SQLException;
}
