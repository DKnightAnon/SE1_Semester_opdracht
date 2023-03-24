package com.example.se_opdracht;

import com.example.se_opdracht.graphs.Linegraph;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhandler {



    public static Connection connection() throws SQLException {
        Connection conn = null;
        try {
             conn = DriverManager.getConnection("jdbc:h2:~bptDB", "test", "test");
            //Statement st = conn.createStatement();
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