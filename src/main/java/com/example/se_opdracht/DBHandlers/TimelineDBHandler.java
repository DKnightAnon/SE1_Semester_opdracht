package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ProductMaker.AbstractFactory;
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

public class TimelineDBHandler extends DBhandler implements DBInsertTransaction,DBRetrieveTransaction,IDBInsert,IDBRetrieve{

    public ArrayList<IProduct> getProductsAsArrayList() throws ClassNotFoundException {
        ArrayList list = new ArrayList<>();
        Class.forName("org.h2.Driver");
        String query = "SELECT product.Product_ID, product.Name, product.Description,category.CategoryName, category.Category_ID " +
                "From TimelineProduct product join TimelineProductCategory category " +
                "on product.category = category.Category_ID";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            AbstractFactory.Timeline.createCategory().addAll(rs.getString("CategoryName"), rs.getInt("Category_ID"));
            while (rs.next()) {
                ICategory tempCat =  AbstractFactory.Timeline.createCategory();
                tempCat.addAll(rs.getString("CategoryName"), rs.getInt("Category_ID"));
                IProduct tempProduct = AbstractFactory.Timeline.createProduct();
                tempProduct.addAll(rs.getString("Name"), rs.getString("Description"), rs.getInt("Product_ID"), tempCat);
                list.add(tempProduct);

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


public boolean checkConnection() throws SQLException, ClassNotFoundException {
    Class.forName("org.h2.Driver");
    try{String query = "SELECT product.Product_ID, product.Name, product.Description,category.CategoryName, category.Category_ID " +
            "From TimelineProduct product join TimelineProductCategory category " +
            "on product.category = category.Category_ID";
    Connection con = getConnection();
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    if (rs.next()){
        con.close();
        return true;
    }else {
        con.close();
        return false;
    }

    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }

}

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TimelineDBHandler db = new TimelineDBHandler();
        //System.out.println(db.checkConnection());
        db.getProducts();


    }


    public  ObservableList<IProduct> getProducts() {
        ObservableList<IProduct> list = FXCollections.observableArrayList();
        //This was first initialized with the null value. Don't do this, it throws exceptions.
        String query = "SELECT product.Product_ID, product.Name, product.Description,category.CategoryName " +
                "From TimelineProduct product join TimelineProductCategory category " +
                "on product.category = category.Category_ID";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
//            AbstractFactory.Timeline.createCategory().addAll(rs.getString("CategoryName"), rs.getInt("Category_ID"));

//            System.out.println(rs.next());
            while (rs.next()) {
                ICategory tempCat =  AbstractFactory.Timeline.createCategory();
                tempCat.addAll(rs.getString("CategoryName"), rs.getInt("Category_ID"));
                IProduct tempProduct = AbstractFactory.Timeline.createProduct();
                tempProduct.addAll(rs.getString("Name"), rs.getString("Description"), rs.getInt("Product_ID"), tempCat);
                list.add(tempProduct);

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

    public ArrayList<ICategory> getCategoriesAsArrayList() {
        ArrayList list = new ArrayList<ICategory>();
        String query = "SELECT * FROM TIMELINEPRODUCTCATEGORY";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ICategory temp = AbstractFactory.Timeline.createCategory();
            while (rs.next()) {
                temp.addAll(rs.getString("CategoryName"),rs.getInt("Category_ID"));
                list.add(temp);
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
    public  ObservableList<ICategory> getCategories() throws SQLException, ClassNotFoundException {
        ObservableList<ICategory> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM TIMELINEPRODUCTCATEGORY";
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ICategory temp = AbstractFactory.Timeline.createCategory();
            while (rs.next()) {
                temp.addAll(rs.getString("CategoryName"),rs.getInt("Category_ID"));
                list.add(temp);
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
    public void addTransaction(IPurchase purchase) throws ClassNotFoundException, SQLException {
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

            IPurchase temp = AbstractFactory.Timeline.createPurchase();
            IProduct tempProduct = AbstractFactory.Timeline.createProduct();
            ICategory tempCategory = AbstractFactory.Timeline.createCategory();

            while (rs.next()){
                temp.addAll(tempProduct,tempCategory, rs.getString("Date"),rs.getBigDecimal("PurchasePrice"), rs.getInt("PurchaseDate_ID"));
                list.add(temp);
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
}
