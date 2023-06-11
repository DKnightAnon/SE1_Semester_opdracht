package com.example.se_opdracht.ErrorMessages;

import com.example.se_opdracht.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public final class ErrorWarnings {

    private static final String missingData = "Data missing";
    private static final String missingDataHeader = "Not all data fields have been filled!";


    public static void noCompletePurchaseInfo() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(missingData);
        alert.setHeaderText(missingDataHeader);
        alert.setContentText("Please be sure to fill in every field before pressing the 'Add new purchase' button.");
        alert.showAndWait();

    }
    public static void noCategoryEntered(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(missingData);
        alert.setHeaderText(missingDataHeader);
        alert.setContentText("Please enter a name in the textfield before pressing the 'Add new category' button.");
        alert.showAndWait();

    }

    public static void unableToSwitchScene() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Screen Switch Error");
        alert.setContentText("Unable to switch between screens." + "\n" + "Please check if scene path was input correctly in code.");
        alert.showAndWait();
    }

    public static void unableToCloseApplication() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Screen Switch Error");
        alert.showAndWait();

    }

    public static void logoutConfirm() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Logout");
        alert.setContentText("You're about to exit the application.");
        alert.getDialogPane().getStylesheets().add(String.valueOf(Main.class.getResource("CSS_Files/DarkMode.css")));

        if (alert.showAndWait().get() == ButtonType.OK) {
            javafx.application.Platform.exit();
            System.out.println("Appliction closed.");
        }

    }

    public static void noItemSelected() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No item selected");
        alert.setContentText("You havent selected an item to display yet!");
    }
}
