package com.example.se_opdracht.DBHandlers;


import java.sql.*;

public  interface DBhandler {

 static String jdcbURL = "jdbc:h2:~/bptDB;";
 static String user = "Admin";
 static String password = "admin";
 static String connected = "Connected to database!";
 public static String disconnected = "Disconnected from database!";
 public static String connectionUnable = "Unable to connect to database...";

    public default void addNewProduct(){

    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(DBhandler.getJdcbURL(), DBhandler.getUser(),DBhandler.getPassword() );
        return connection;
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