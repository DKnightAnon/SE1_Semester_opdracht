package com.example.se_opdracht.DBHandlers;


import com.example.se_opdracht.ProductMaker.AbstractFactory;
import com.example.se_opdracht.ProductMaker.ProductFactory;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public abstract class DBConnect {

    //Choose this url for a database in home directory : jdbc:h2:~/bptDB;
    //Choose this url for a database in projectroot/Database : jdbc:h2:file:./Database/bptDB
    String jdcbURL = "jdbc:h2:file:./Database/bptDB";
    String url2 = "jdbc:h2:file:./bptDB";
    String user = "Admin";
    String password = "admin";

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(jdcbURL, user, password);
        return connection;
    }

    protected String getJdcbURL() {
        return jdcbURL;
    }

    protected String getUser() {
        return user;
    }

    protected String getPassword() {
        return password;
    }
}