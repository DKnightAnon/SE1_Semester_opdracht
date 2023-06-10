package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class TransactionDBHandler extends DBhandler{



    public ObservableList<IProduct> getTransactions() {
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
                "FROM PURCHASE JOIN EXPENSE_CATEGORY " +
                "ON PURCHASE.Category = EXPENSE_CATEGORY.Category_ID;";

        ObservableList<IProduct> list;
        try {
            //Connection connection = DriverManager.getConnection(DBhandler.getJdcbURL(), DBhandler.getUser(),DBhandler.getPassword() );
            //Above code made redundant. It can now be called with 'DBHandler.getConnection();'
            Connection connection = getConnection();
            list = FXCollections.observableArrayList();
            PreparedStatement ps = connection.prepareStatement(databasequery3);
            ResultSet rs = ps.executeQuery();

//            while (rs.next()) {
//
//                list.add(new TransactionProduct(
//                        rs.getInt("Purchase_ID"),
//                        rs.getString("Date"),
//                        rs.getString("Item"),
//                        rs.getString("Description"),
//                        rs.getString("Name")));//category
//            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public IProduct getSingularProduct(int ID) throws SQLException, ClassNotFoundException {
        String databasequery =
                "SELECT Purchase_ID, Date, Item, Description, Name " +
                        "FROM PURCHASE JOIN EXPENSE_CATEGORY" +
                        " ON PURCHASE.Category = EXPENSE_CATEGORY.Category_ID " +
                        "where purchase_id = ?; ";
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(databasequery);
        ps.setInt(1, ID);
        ResultSet rs = ps.executeQuery();
        IProduct SingularProduct = null;
//        while (rs.next()) {
//            SingularProduct = new TransactionProduct(
//                    rs.getInt("Purchase_ID"),
//                    rs.getString("Date"),
//                    rs.getString("Item"),
//                    rs.getString("Description"),
//                    rs.getString("Name"));
//
//        }
        return SingularProduct;
    }
//    public ObservableList<TransactionProductCategory> getCategories() {
//        ObservableList<TransactionProductCategory>   list = FXCollections.observableArrayList();
//        try {
//            Connection connection = DBhandler.getConnection();
//
//            PreparedStatement ps = connection.prepareStatement("SELECT * FROM expense_category");
//            ResultSet rs = ps.executeQuery();
//            list.add(new TransactionProductCategory("Select a category",0)); // This is a dummy category. I'm not quite sure yet how to retrieve data apart from string values from items in the combobox, so this is a stopgap measure.
//
//            while (rs.next()) {
//                //list.add(rs.getString("Name"));
//
//                list.add(new ICategory(rs.getString("Name"), rs.getInt("Category_ID")));
//            }
//            connection.close();
//        }catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
    public void addCategory(String categoryName) {
        try{
            Class.forName("org.h2.Driver");
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO EXPENSE_CATEGORY (Name) VALUES (?);"); //H2 specific statement
            ps.setString(1,categoryName);
            ps.executeUpdate();
            connection.close();


        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void addNewProduct(String date, String item, String description, int id) {
        PreparedStatement psInsert = null;
        try{
           Connection con = getConnection();

            psInsert = con.prepareStatement("INSERT INTO Purchase (Date, Item,Description, Category) VALUES (?,?,?," + id + ")");
            psInsert.setString(1,date);
            psInsert.setString(2,item);
            psInsert.setString(3,description);
            psInsert.execute();
            //System.out.printf("%s, %s, %s, %s, categoryID : %d",date,item,description,category,id);
            //Testing done
            con.close();

        }catch (SQLException e){
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }




}
