package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.DBhandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {


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

    }
}