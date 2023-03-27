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

    public static void printdatabase() {
        try {
            PreparedStatement psInsert = null;
            ResultSet resultSet = null;
            Connection con =  DriverManager.getConnection(DBhandler.getJdcbURL(), DBhandler.getUser(), DBhandler.getPassword());
            psInsert = con.prepareStatement("INSERT INTO PURCHASE (Date, Item, Description, Category) VALUES ('26-03-2022', 'testitem','testdescription',1);");
            psInsert.executeUpdate();
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(jdcbURL, user, password);
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT Purchase_ID, Date, Item, Description, Name FROM PURCHASE JOIN expense_category ON purchase.Category = expense_category.Category_ID;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

               int id =         rs.getInt("Purchase_ID");
               String date =         rs.getString("Date");
               String item =         rs.getString("Item");
               String description =         rs.getString("Description");
               String category =         rs.getString("Name");//category
               System.out.printf("%d, %s, %s, %s, %s\n", id, date, item, description, category);
            }
            if (rs.next() == false) {
                System.out.println("No further results");
            }
            ps = connection.prepareStatement("SELECT * FROM EXPENSE_CATEGORY ");
            ResultSet rs2 = ps.executeQuery();
            while (rs2.next()) {
                int id = rs2.getInt("Category_ID");
                String name = rs2.getString("NAME");
                System.out.printf("%d, %s\n", id, name);

            }
            connection.close();
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



            }catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        launch();

        //printdatabase();

    }
}