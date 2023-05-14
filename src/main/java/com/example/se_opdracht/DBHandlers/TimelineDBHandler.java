package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.Products.Timeline.TimelineProductCategory;
import com.example.se_opdracht.Products.Timeline.TimelineProductPurchase;
import com.example.se_opdracht.Products.Transaction.TransactionProductCategory;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TimelineDBHandler implements DBhandler{

    public static ArrayList<TimelineProduct> getProductsAsArrayList() throws ClassNotFoundException {
        ArrayList list = new ArrayList<>();
        Class.forName("org.h2.Driver");
        String query = "SELECT product.Product_ID, product.Name, product.Description,category.CategoryName " +
                "From TimelineProduct product join TimelineProductCategory category " +
                "on product.category = category.Category_ID";
        try {
            Connection con = DBhandler.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list.add(new TimelineProduct("Select a product",
                    "You shoudln't see this.",
                    "You shouldn't see this.",
                    0
            ));
            while (rs.next()) {
                list.add(new TimelineProduct(
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("CategoryName"),
                        rs.getInt("Product_ID")
                ));

            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return list;
    }



    public static ObservableList<TimelineProductPurchase> getPurchases(int productID) throws ClassNotFoundException {
        ObservableList<TimelineProductPurchase> list = FXCollections.observableArrayList();
        Class.forName("org.h2.Driver");
        String query = "SELECT * FROM PRODUCTPURCHASEDATE where Product_ID = ? ";

        try{
            Connection con = DBhandler.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new TimelineProductPurchase(
                        rs.getInt("PurchaseDate_ID"),
                        rs.getString("Date"),
                        rs.getBigDecimal("PurchasePrice"),
                        rs.getInt("Product_ID")));
            }
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static ArrayList<TimelineProductPurchase> getPurchasesAsArrayList() throws ClassNotFoundException {
        ArrayList<TimelineProductPurchase> list = new ArrayList<>();
        Class.forName("org.h2.Driver");
        String query = "SELECT * FROM PRODUCTPURCHASEDATE";

        try{
            Connection con = DBhandler.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new TimelineProductPurchase(
                        rs.getInt("PurchaseDate_ID"),
                        rs.getString("Date"),
                        rs.getBigDecimal("PurchasePrice"),
                        rs.getInt("Product_ID")));
            }
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static ObservableList<TimelineProduct> getProductsListview(int index) throws ClassNotFoundException {
        ObservableList<TimelineProduct> list = FXCollections.observableArrayList();
        Class.forName("org.h2.Driver");
        String query = "Select Name, Product_ID from TimelineProduct where Category = ?";
        try {
            Connection connection = DBhandler.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,index);
            ResultSet rs = ps.executeQuery();
            list.add(new TimelineProduct(
                    "Items in category are:",
                    "empty",
                    "empty",
                    0
            ));
            while (rs.next()) {
                list.add(new TimelineProduct(
                        rs.getString("Name"),
                        "this should be empty",
                        "Empty",
                        rs.getInt("Product_ID")

                ));
            }
        }catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return list;
    }
    public static ObservableList<TimelineProduct> getProducts() throws ClassNotFoundException, SQLException {
        ObservableList<TimelineProduct> list;
        list = FXCollections.observableArrayList();
        //This was first initialized with the null value. Don't do this, it throws exceptions.
        Class.forName("org.h2.Driver");
        String query = "SELECT product.Product_ID, product.Name, product.Description,category.CategoryName " +
                "From TimelineProduct product join TimelineProductCategory category " +
                "on product.category = category.Category_ID";
        try{
            Connection con = DBhandler.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list.add(new TimelineProduct("Select a product",
                    "You shoudln't see this.",
                    "You shouldn't see this.",
                    0
            ));
            while (rs.next()){
                list.add(new TimelineProduct(
                        rs.getString("Name"),
                        rs.getString("Description"),
                        rs.getString("CategoryName"),
                        rs.getInt("Product_ID")
                ));

            }
            con.close();

        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return list;
    }

    public static ArrayList<TimelineProductCategory> getCategoriesAsArrayList() throws ClassNotFoundException {
        ArrayList list = new ArrayList<TimelineProductCategory>();
        String query = "SELECT * FROM TIMELINEPRODUCTCATEGORY";
        Class.forName("org.h2.Driver");
        try {
            Connection con = DBhandler.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TimelineProductCategory(rs.getInt("Category_ID"), rs.getString("CategoryName")));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return list;
    }
    public static ObservableList<TimelineProductCategory> getCategories() throws SQLException, ClassNotFoundException {
        ObservableList<TimelineProductCategory> list;
        list = FXCollections.observableArrayList();
        String query = "SELECT * FROM TIMELINEPRODUCTCATEGORY";
        Class.forName("org.h2.Driver");
        try {
            Connection con = DBhandler.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            list.add(new TimelineProductCategory(0,"Select a category"));//Stopgap measure to have index start at 1 instead of 0. I've done something similar in TransactionDBHandler.java

            while (rs.next()) {
                list.add(new TimelineProductCategory(rs.getInt("Category_ID"), rs.getString("CategoryName")));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return list;
    }
    public void addCategory(String name) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DBhandler.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO TimelineProductCategory (CategoryName) VALUES (?);"); //H2 specific statement
            ps.setString(1, name);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void addNewProduct(String name, String description, int categoryID) throws SQLException, ClassNotFoundException {
        String insert = "Insert into TimelineProduct (Name, Description, Category) Values (?,?,?)";
        Class.forName("org.h2.Driver");
        Connection connection = DBhandler.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1,name);
            ps.setString(2,description);
            ps.setInt(3,categoryID);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
    public void addNewPurchase(int productIndex, String date, String purchasePrice) throws SQLException, ClassNotFoundException {
        String insert = "Insert into ProductPurchaseDate (Product_ID, Date, PurchasePrice) Values (?,?,?)";
        Class.forName("org.h2.Driver");
        Connection connection = DBhandler.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, productIndex);
            ps.setString(2, date);
            BigDecimal price = new BigDecimal(purchasePrice);
            ps.setBigDecimal(3, price);
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    }
