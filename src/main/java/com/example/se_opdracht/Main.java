package com.example.se_opdracht;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Homepage");
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setMinHeight(650);
            stage.setMinWidth(1000);
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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        launch();

    }
}