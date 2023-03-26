package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class TransactionDBHandler extends DBhandler{

    public static ObservableList<TransactionProduct> getTransactions() {
        String databasequery1 =
                "SELECT 'ID', 'Date', 'Item', 'Vendor', 'Description', 'Name' " +
                        "FROM 'purchase' JOIN 'expense_category'" +
                        "ON purchase.Category = expense_category.Category_ID";
        String databasequery2 =
                "SELECT Purchase_ID, Date, Item, Description, Name " +
                        "FROM purchase JOIN expense_category " +
                        "ON purchase.Category = expense_category.Category_ID;";
        String databasequery3 =
                "SELECT Purchase_ID, Date, Item, Description, Name " +
                "FROM PURCHASE JOIN expense_category " +
                "ON purchase.Category = expense_category.Category_ID;";

        ObservableList<TransactionProduct> list;
        try {
            Connection connection = connection();
            list = FXCollections.observableArrayList();
            PreparedStatement ps = connection.prepareStatement(databasequery3);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new TransactionProduct(
                        rs.getInt("Purchase_ID"),
                        rs.getString("Date"),
                        rs.getString("Item"),
                        rs.getString("Description"),
                        rs.getString("Name")));//category
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
    public void addNewProduct(String date, String item, String description, String category) {
        PreparedStatement psInsert = null;
        ResultSet resultSet = null;

        try{
           Connection con = connection();
            psInsert = con.prepareStatement("INSERT INTO 'Purchase'('Date', 'Item','Description', 'Category') VALUES (?,?,?,?)");
            psInsert.setString(1, date);
            psInsert.setString(2,item);
            psInsert.setString(3,description);
            psInsert.setString(4,category);
            psInsert.executeUpdate();

        }catch (SQLException e){

        }

    }




}
