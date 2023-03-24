package com.example.se_opdracht;

import com.example.se_opdracht.graphs.Linegraph;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhandler {

 private static String jdcbURL = "jdbc:h2:mem:bptDB";
 private static String user = "admin";
 private static String password = "admin";
 public String connected = "Connected to database!";
 public String disconnected = "Disconnected from database!";
 public String connectionUnable = "Unable to connect to database...";

    public  Connection connection() throws SQLException {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(jdcbURL, user, password);
             System.out.println(connected);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    };

    public static void addProduct() throws  SQLException {

    }

    public static ObservableList<Linegraph> getDataContact() throws SQLException {
        return null;
    }
}