package com.example.se_opdracht.ErrorMessages;

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
    private String connectionError = "Connection Error";
    private String missingData = "Data missing";
    private String missingDataHeader = "Not all data fields have been filled!";

    public void databasenotconnected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(connectionError);
        alert.setHeaderText("Connection Failed");
        alert.setContentText("Unable to connect to database." + "\n" + "Please check server connection and login info.");
        alert.showAndWait();
    }

    public void noCompletePurchaseInfo() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(missingData);
        alert.setHeaderText(missingDataHeader);
        alert.setContentText("Please be sure to fill in every field before pressing the 'Add new purchase' button.");
        alert.showAndWait();

    }
    public void noCategoryEntered(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(missingData);
        alert.setHeaderText(missingDataHeader);
        alert.setContentText("Please enter a name in the textfield before pressing the 'Add new category' button.");
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
            System.out.println("Appliction closed.");
            stage.close();
        }

    }

    public void noItemSelected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No item selected");
        alert.setContentText("You havent selected an item to display yet!");
    }
}
