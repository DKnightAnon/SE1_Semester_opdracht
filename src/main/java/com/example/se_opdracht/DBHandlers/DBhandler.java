package com.example.se_opdracht.DBHandlers;


import java.sql.*;

public interface DBhandler {

    //Choose this url for a database in home directory : jdbc:h2:~/bptDB;
    //Choose this url for a database in projectroot/Database : jdbc:h2:file:./Database/bptDB
 String jdcbURL = "jdbc:h2:file:./Database/bptDB";
 String user = "Admin";
 String password = "admin";

    public default void addNewProduct(){

    }

    static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(jdcbURL, user,password);
        return connection;
    }
    static String getJdcbURL() {
        return jdcbURL;
    }

    static String getUser() {
        return user;
    }

    static String getPassword() {
        return password;
    }
}