package com.example.se_opdracht;

import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public abstract class GenericScreenController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button ReturnButton;
    @FXML
    private Button MenuButton;
    @FXML
    private Button HomeButton;
    ErrorWarnings error = new ErrorWarnings();
    private Boolean darkMode;

    public Boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(Boolean darkMode) {
        this.darkMode = darkMode;
    }

    public Boolean isDatePickerEmpty(DatePicker datePicker) {
        if (datePicker.getValue() != null) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean isTextFieldEmpty(TextField textfield) {
        if (textfield.getText().isEmpty()) {
            return true;
        }else {
            return false;
        }
    }

    public void OnReturnButtonClicked(ActionEvent actionEvent) {
        try {
            URL fxmlLocation = getClass().getResource("StartMenu.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            error.unableToSwitchScene();
        }
    }


    @FXML
    void onSettingsButtonClick(ActionEvent event) {

    }
    @FXML
    void onHomeButtonClick(ActionEvent event) {

    }

    @FXML
    void onMenuButtonClick(ActionEvent event) {

    }

    public void onTransactionsButtonClick(ActionEvent actionEvent) throws IOException {
        //Switch scenes
        try {
            URL fxmlLocation = getClass().getResource("TransactionScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinHeight(650);
            stage.setMinWidth(1000);
            stage.show();
        } catch (Exception e) {
            //Removing the e.printStackTrace(); causes the sceneswitching to work for some reason? Needs looking into on a different date.
            //Sceneswtiching works if both controllers are in source package.
            error.unableToSwitchScene();
            e.printStackTrace();
        }

    }

    public void onGraphsButtonClick(ActionEvent actionEvent) {
    }

    public void onProductsButtonClick(ActionEvent actionEvent) {
        try {
            URL fxmlLocation = getClass().getResource("ProductsScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setMinHeight(650);
            stage.setMinWidth(1000);
            stage.show();
        } catch (Exception e) {
            //Removing the e.printStackTrace(); causes the sceneswitching to work for some reason? Needs looking into on a different date.
            //Sceneswtiching works if both controllers are in source package.
            error.unableToSwitchScene();
            e.printStackTrace();
        }
    }

    public void onCloseButtonClick(ActionEvent actionEvent) {

    }

    public void setScreenTheme () {
        while (true) {
            Boolean mode = getDarkMode();
            if (mode = false) {

            } else if (mode = true) {


            }
        }
    }


}
