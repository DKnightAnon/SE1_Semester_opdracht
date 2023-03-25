package com.example.se_opdracht.DBHandlers;


import com.example.se_opdracht.Products.Product;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhandler {

 private static String jdcbURL = "jdbc:h2:mem:bptDB";
 private static String user = "admin";
 private static String password = "admin";
 public static String connected = "Connected to database!";
 public static String disconnected = "Disconnected from database!";
 public static String connectionUnable = "Unable to connect to database...";

    public static Connection connection() throws SQLException {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(jdcbURL, user, password);
             System.out.println(connected);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    };


    public void addNewProduct(){

    }

}