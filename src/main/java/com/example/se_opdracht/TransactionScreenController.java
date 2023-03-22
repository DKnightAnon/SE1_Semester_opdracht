package com.example.se_opdracht;

import com.example.se_opdracht.Main;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TransactionScreenController {

    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button Return;

    public void onReturnButtonClicked(ActionEvent actionEvent) throws IOException {
        //Switch scene to Main
        URL fxmlLocation = getClass().getResource("StartMenu.fxml");

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        root = loader.load();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
