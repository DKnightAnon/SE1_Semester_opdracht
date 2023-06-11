package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimelineDBHandler extends ProductDBHandler{

    private final String getProductsQuery = "SELECT product.Product_ID, product.Name, product.Description,category.CategoryName, category.Category_ID " +
            "From TimelineProduct product join TimelineProductCategory category " +
            "on product.category = category.Category_ID";;


    public  ObservableList<IProduct> getProducts() {
        ObservableList<IProduct> list = FXCollections.observableArrayList();
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(getProductsQuery);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(factory.createProduct(rs.getString("Name"), rs.getString("Description"), rs.getInt("Product_ID"), factory.createCategory(rs.getString("CategoryName"), rs.getInt("Product_ID"))));
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
    public ArrayList<IProduct> getProductsAsArrayList() throws ClassNotFoundException {
        List list = getProducts();
        return (ArrayList<IProduct>) list;
    }

    public ArrayList<ICategory> getCategoriesAsArrayList() throws SQLException, ClassNotFoundException {
        List list = getCategories();
        return (ArrayList<ICategory>) list;
    }
    public  ObservableList<ICategory> getCategories() throws SQLException, ClassNotFoundException {
        ObservableList<ICategory> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM TIMELINEPRODUCTCATEGORY";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(factory.createCategory(rs.getString("CategoryName"),rs.getInt("Category_ID")));
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



//    -------------------------------------------------------new------------------------------------------------------------------

    @Override
    public void addNewTransaction(IPurchase purchase) throws ClassNotFoundException, SQLException {
        String insert = "Insert into ProductPurchaseDate (Product_ID, Date, PurchasePrice) Values (?,?,?)";
        Class.forName("org.h2.Driver");
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, purchase.getProduct().getProductID());
            ps.setString(2, purchase.getDate());
            ps.setBigDecimal(3, purchase.getPrice());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public ObservableList<IPurchase> getTransactions(IProduct product) {
        ObservableList<IPurchase> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM PRODUCTPURCHASEDATE where Product_ID = ? ";
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,product.getProductID());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                IPurchase retrieve = factory.createPurchase(factory.createProduct(rs.getString("Name"), rs.getString("Description"), rs.getInt("Product_ID"), factory.createCategory(rs.getString("CategoryName"), rs.getInt("Product_ID"))), rs.getString("Date"),rs.getBigDecimal("PurchasePrice"),rs.getInt("PurchaseDate_ID"));
                list.add(retrieve);
            }
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public ObservableList<IPurchase> getTransactions() {
        return null;
    }

    @Override
    public ArrayList<IPurchase> getTransactionsAsArrayList(IProduct product) {
        List list = getTransactions(product);
        return (ArrayList<IPurchase>) list;
    }

    @Override
    public void addNewCategory(ICategory category) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO TimelineProductCategory (CategoryName) VALUES (?);"); //H2 specific statement
            ps.setString(1, category.getCategoryName());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewProduct(IProduct product) throws ClassNotFoundException, SQLException {
        String insert = "Insert into TimelineProduct (Name, Description, Category) Values (?,?,?)";
        Class.forName("org.h2.Driver");
        Connection connection = getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1,product.getName());
            ps.setString(2,product.getDescription());
            ps.setInt(3,product.getCategory().getCategoryID());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    //Beneath this is a method to print everything in the ResultSet rs to the command line. This is not currently used in the program, but could be useful in the future.

    //            System.out.println(rs.next());
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int columnsNumber = rsmd.getColumnCount();
//            while (rs.next()) {
//                for (int i = 1; i <= columnsNumber; i++) {
//                    if (i > 1) System.out.print(",  ");
//                    String columnValue = rs.getString(i);
//                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
//                }
//                System.out.println("");
//            }
}
