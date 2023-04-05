package com.example.se_opdracht;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        AtomicReference<Double> x = new AtomicReference<>((double) 0);
        AtomicReference<Double> y = new AtomicReference<>((double) 0);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Homepage");
            stage.initStyle(StageStyle.UNDECORATED);
            scene.getStylesheets().addAll(getClass().getResource("CSS_Files/Buttons.css").toExternalForm());


            root.setOnMousePressed(event -> {
                x.set(event.getScreenX());
                y.set(event.getScreenY());
            });
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX()- x.get());
                stage.setY(event.getScreenY()- y.get());
            });

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