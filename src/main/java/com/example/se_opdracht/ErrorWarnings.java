package com.example.se_opdracht;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ErrorWarnings {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String logoutmessage = "Appliction closed.";


    public void databasenotconnected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Connection Failed");
        alert.setContentText("Unable to connect to database." + "\n" + "Please check server connection and login info.");
        alert.showAndWait();
    }

    public void unableToSwitchScene() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Screen Switch Error");
        alert.setContentText("Unable to switch between screens." + "\n" + "Please check if scene path was input correctly in code.");
        alert.showAndWait();
    }

    public void unableToCloseApplication() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Screen Switch Error");
        alert.showAndWait();

    }

    public void logoutConfirm(AnchorPane screenName) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to exit the application.");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) screenName.getScene().getWindow();
            System.out.println(logoutmessage);
            stage.close();
        }

    }
}
