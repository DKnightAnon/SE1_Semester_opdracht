package com.example.se_opdracht;

import javafx.scene.control.Alert;

public class ErrorWarnings {
    public void databasenotconnected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Connection Failed");
        alert.setContentText("Unable to connect to database." + "\n" + "Please check server connection and login info.");
        alert.showAndWait();
    }
}
