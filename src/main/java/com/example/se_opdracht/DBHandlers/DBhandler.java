package com.example.se_opdracht.DBHandlers;


import com.example.se_opdracht.Products.Product;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.sql.*;
import java.time.LocalDate;

public  class DBhandler {

 private static String jdcbURL = "jdbc:h2:~/bptDB;DATABASE_TO_UPPER=false";
 private static String user = "Admin";
 private static String password = "admin";
 public static String connected = "Connected to database!";
 public static String disconnected = "Disconnected from database!";
 public static String connectionUnable = "Unable to connect to database...";

  /*  public static Connection connection() throws SQLException {
        Connection conn = DriverManager.getConnection(jdcbURL, user, password);
        return conn;
    };*/


    public void addNewProduct(){

    }
    public  void addNewTransactionProduct(String date, String item, String description, String category){

    }

    public static String getJdcbURL() {
        return jdcbURL;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}