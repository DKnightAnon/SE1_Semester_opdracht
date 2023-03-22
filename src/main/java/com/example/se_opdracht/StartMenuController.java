package com.example.se_opdracht;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartMenuController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label WelcomeMessage;
    @FXML
    private Label WelcomeGuideMessage;
    @FXML
    private Button ProductsButton;
    @FXML
    private Button GraphsButton;
    @FXML
    private Button TransactionsButton;

    private Stage stage;
    private Scene scene;
    private Parent root;



@FXML
    public void onTransactionsButtonClick(ActionEvent actionEvent) throws IOException {
        //Switch scenes
        try {
            URL fxmlLocation = getClass().getResource("TransactionScreen.fxml");

            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            root = loader.load();
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onGraphsButtonClick(ActionEvent actionEvent) {
    }

    public void onProductsButtonClick(ActionEvent actionEvent) {
    }
}