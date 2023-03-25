package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TransactionDBHandler extends DBhandler{

    public static ObservableList<TransactionProduct> Transactions() throws SQLException {

        ObservableList<TransactionProduct> list;
        try {
            Connection connection = connection();
            list = FXCollections.observableArrayList();
            PreparedStatement ps = connection.prepareStatement("SELECT ID, Date, Item, Vendor, Description, Category FROM gebruiker");
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

    @Override
    public void addNewProduct() {
        PreparedStatement psInsert = null;
        int ID;
        Date date;
        String item;
        String vendor;
        String description;
        String category;
        ResultSet resultSet = null;

        try{
           Connection con = connection();
            psInsert = con.prepareStatement("INSERT INTO Purchase(ID,");
            psInsert.setInt(1, ID);
            psInsert.setDate(2, date);

        }catch (SQLException e){

        }

    }




}
