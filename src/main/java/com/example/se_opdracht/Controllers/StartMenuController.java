package com.example.se_opdracht.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartMenuController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label WelcomeMessage;
    private Label WelcomeGuideMessage;
    private Button ProductsButton;
    private Button GraphsButton;
    private Button TransactionsButton;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onTransactionsButtonClick(ActionEvent actionEvent) {
    }

    public void onGraphsButtonClick(ActionEvent actionEvent) {
    }

    public void onProductsButtonClick(ActionEvent actionEvent) {
    }
}