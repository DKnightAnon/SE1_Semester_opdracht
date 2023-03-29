package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.DBhandler;
import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.Products.Timeline.TimelineProductCategory;
import com.example.se_opdracht.Products.Transaction.TransactionProduct;
import com.example.se_opdracht.Products.Transaction.TransactionProductCategory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseTest {

    private static TimelineDBHandler TLDB = new TimelineDBHandler();


    private static String jdcbURL = "jdbc:h2:~/bptDB";
    private static String user = "admin";
    private static String password = "admin";
    public static String connected = "Connected to database!";
    public static String disconnected = "Disconnected from database!";
    public static String connectionUnable = "Unable to connect to database...";

   /* public static Connection connection() throws SQLException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(jdcbURL, user, password);
            System.out.println(connected);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    };*/

    public static void TestAll() throws SQLException, ClassNotFoundException {
       // printDatabaseAllTransactions();
        printDatabaseTransaction();
        printTimelineProducts();
        printTimeLineCategories();
        insertTransactionProduct();
        System.exit(0);
    }

    public static void printDatabaseAllTransactions() throws SQLException {
        ObservableList<TransactionProduct> tpList = FXCollections.observableArrayList();
        ObservableList<TransactionProductCategory> tpcList = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection(jdcbURL, user, password);
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Purchase_ID, Date, Item, Description, Name, category_ID FROM PURCHASE JOIN expense_category ON purchase.Category = expense_category.Category_ID;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tpList.add(new TransactionProduct(
                        rs.getInt("Purchase_ID"),
                        rs.getString("Date"),
                        rs.getString("Item"),
                        rs.getString("Description"),
                        rs.getString("Name")));
                tpcList.add(new TransactionProductCategory(
                        rs.getString("Category_ID"),
                        rs.getInt("NAME")));


            }
            for (int i = 0; i < tpList.size(); i++) {
                System.out.printf("%d, %s, %s, %s, %d, %s, %d",
                        tpList.get(i).getID(),
                        tpList.get(i).getDate(),
                        tpList.get(i).getName(),
                        tpList.get(i).getDescription(),
                        tpList.get(i).getCategory(),
                        tpcList.get(i).getCategoryName(),
                        tpcList.get(i).getCategoryID());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printDatabaseTransaction() {
        try {
            Connection connection = DriverManager.getConnection(jdcbURL, user, password);
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Purchase_ID, Date, Item, Description, Name FROM PURCHASE JOIN expense_category ON purchase.Category = expense_category.Category_ID;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("Purchase_ID");
                String date = rs.getString("Date");
                String item = rs.getString("Item");
                String description = rs.getString("Description");
                String category = rs.getString("Name");//category
                System.out.printf("%d, %s, %s, %s, %s\n", id, date, item, description, category);
            }
            if (!rs.next()) {
                System.out.println("No further results for transactions\n");
            }
            ps = connection.prepareStatement("SELECT * FROM EXPENSE_CATEGORY ");
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                int id = rs2.getInt("Category_ID");
                String name = rs2.getString("NAME");
                System.out.printf("%d, %s\n", id, name);
            }
            if (!rs.next()) {
                System.out.println("No further results for Transaction categories\n");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTimelineProducts() throws SQLException, ClassNotFoundException {
        ObservableList<TimelineProduct> list = TLDB.getProducts();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s,%s,%s,%d\n",
                    list.get(i).getName(),
                    list.get(i).getDescription(),
                    list.get(i).getCategory(),
                    list.get(i).getProductID()
            );
            System.out.println("No further results for Timeline Products\n");
        }
        //System.exit(0);
    }

    public static void printTimeLineCategories() throws SQLException, ClassNotFoundException {
        ObservableList<TimelineProductCategory> list = TLDB.getCategories();
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d, %s\n",
                    list.get(i).getCategoryID(),
                    list.get(i).getCategoryName()
            );
            System.out.println("No further results for Timeline Categories\n");
        }
        //System.exit(0);

    }
    public static void insertTransactionProduct(){
        try {
            String insertion = "INSERT INTO PURCHASE (Date, Item, Description, Category) VALUES ('26-03-2022', 'testitem','testdescription',1);";
            PreparedStatement psInsert = null;
            Connection con = DriverManager.getConnection(DBhandler.getJdcbURL(), DBhandler.getUser(), DBhandler.getPassword());
            psInsert = con.prepareStatement(insertion);
            psInsert.executeUpdate();
            System.out.println("Successfully inserted a Transaction Product entry into table Purchase!\n");
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
