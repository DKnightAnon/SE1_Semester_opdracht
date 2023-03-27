package com.example.se_opdracht.DBHandlers;


import com.example.se_opdracht.Products.Product;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.sql.*;
import java.time.LocalDate;

public  interface DBhandler {

 static String jdcbURL = "jdbc:h2:~/bptDB;";
 static String user = "Admin";
 static String password = "admin";
 static String connected = "Connected to database!";
 public static String disconnected = "Disconnected from database!";
 public static String connectionUnable = "Unable to connect to database...";

  /*  public static Connection connection() throws SQLException {
        Connection conn = DriverManager.getConnection(jdcbURL, user, password);
        return conn;
    };*/


    public default void addNewProduct(){

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