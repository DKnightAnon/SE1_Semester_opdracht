package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class TransactionDBHandler extends DBhandler{

    public static ObservableList<TransactionProduct> getTransactions() {

        ObservableList<TransactionProduct> list;
        try {
            Connection connection = connection();
            list = FXCollections.observableArrayList();
            PreparedStatement ps = connection.prepareStatement("SELECT ID, Date, Item, Vendor, Description, Category FROM purchase");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new TransactionProduct(
                        rs.getInt("ID"),
                        rs.getDate("Date"),
                        rs.getString("Item"),
                        rs.getString("Vendor"),
                        rs.getString("Description"),
                        rs.getString("Category")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static ObservableList<String> getCategories() {
        ObservableList<String>   list = FXCollections.observableArrayList();
        try {
            Connection connection = connection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM expense_category");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(rs.getString("Name"));
            }
        }catch (SQLException e) {

        }
        return list;
    }

    @Override
    public void addNewProduct(Date date, String item, String vendor, String description, String category) {
        PreparedStatement psInsert = null;
        ResultSet resultSet = null;

        try{
           Connection con = connection();
            psInsert = con.prepareStatement("INSERT INTO Purchase(Date, Item, Vendor, Description, Category) VALUES (?,?,?,?,?)");
            psInsert.setDate(1, date);
            psInsert.setString(2,item);
            psInsert.setString(3, vendor);
            psInsert.setString(4,description);
            psInsert.setString(5,category);
            psInsert.executeUpdate();

        }catch (SQLException e){

        }

    }




}
