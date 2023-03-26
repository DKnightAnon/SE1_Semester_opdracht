package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.DBhandler;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Main extends Application {


    private static String jdcbURL = "jdbc:h2:mem:bptDB";
    private static String user = "admin";
    private static String password = "admin";
    public static String connected = "Connected to database!";
    public static String disconnected = "Disconnected from database!";
    public static String connectionUnable = "Unable to connect to database...";

    public static Connection connection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdcbURL, user, password);
            System.out.println(connected);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    };

    public static void printdatabase() {
        try {
            Connection connection = connection();
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Purchase_ID, Date, Item, Vendor, Description, Name FROM purchase JOIN expense_category ON purchase.Category = expense_category.Category_ID;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

               int id =         rs.getInt("ID");
               String date =         rs.getString("Date");
               String item =         rs.getString("Item");
               String vendor =         rs.getString("Vendor");
               String description =         rs.getString("Description");
               String category =         rs.getString("Category");
               System.out.printf("%d, %s, %s, %s, %s, %s\n");
            }
            if (rs.next() == false) {
                System.out.println("No results");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Homepage");
            stage.setScene(scene);
            stage.show();
            try {
                //Class.forName("org.h2.Driver");
            /*Connection conn = DriverManager.getConnection("jdbc:h2:~bptDB","test","test");
            Statement st = conn.createStatement();*/

                DBhandler database = new DBhandler();
                database.connection();

            }catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        launch();

        printdatabase();

    }
}