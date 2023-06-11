package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class TransactionDBHandler extends ProductDBHandler{

    @Override
    public ObservableList<IPurchase> getTransactions(IProduct product) {
        return null;
    }

    @Override
    public ArrayList<IPurchase> getTransactionsAsArrayList(IProduct product) {
        return null;
    }
    public ObservableList<IPurchase> getTransactions() {
        String getTransactionsQuery = "  SELECT *  FROM purchase JOIN expense_category ON purchase.Category = expense_category.Category_ID;";
        ObservableList<IPurchase> list = FXCollections.observableArrayList();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(getTransactionsQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Purchase(
                        new Product(rs.getString("Item"),rs.getString("Description"),0,
                                new Category(rs.getString("Name"), rs.getInt("Category"))
                        ),
                        rs.getString("Date"),rs.getBigDecimal("PurchasePrice"),rs.getInt("Purchase_ID")));//category
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }



    public ObservableList<ICategory> getCategories() {
        ObservableList<ICategory>   list = FXCollections.observableArrayList();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM expense_category");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(factory.createCategory(rs.getString("Name"), rs.getInt("Category_ID")));
            }
            connection.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void addNewCategory(ICategory category) {
        try{
            Class.forName("org.h2.Driver");
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO EXPENSE_CATEGORY (Name) VALUES (?);"); //H2 specific statement
            ps.setString(1,category.getCategoryName());
            ps.executeUpdate();
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addNewProduct(IProduct product) {

    }

    @Override
    public void addNewTransaction(IPurchase purchase) {
        try{
           Connection con = getConnection();
            PreparedStatement psInsert = con.prepareStatement("INSERT INTO Purchase (Date, Item,Description, Category,PurchasePrice) VALUES (?,?,?,?,?)");
            psInsert.setString(1,purchase.getDate());
            psInsert.setString(2,purchase.getProduct().getName());
            psInsert.setString(3,purchase.getProduct().getDescription());
            psInsert.setInt(4,purchase.getCategory().getCategoryID());
            psInsert.setBigDecimal(5,purchase.getPrice());
            psInsert.execute();
            con.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




}
