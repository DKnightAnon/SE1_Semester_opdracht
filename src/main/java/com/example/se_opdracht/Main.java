package com.example.se_opdracht;

import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.*;

public class Main extends Application {

    public static Stage genericstage;
    double x = 0;
    double y = 0;


    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Controllers/Sidebar.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("Controllers/StartMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Homepage");
            stage.initStyle(StageStyle.UNDECORATED);
            scene.getStylesheets().addAll(getClass().getResource("CSS_Files/DarkMode.css").toExternalForm());
            stage.getIcons().add(new Image(getClass().getResourceAsStream("images/AppIcon.png")));
            stage.setMinHeight(650);
            stage.setMinWidth(1000);
            stage.setScene(scene);
            genericstage = stage;
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        launch();

    }
}