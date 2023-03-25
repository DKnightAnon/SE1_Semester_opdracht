package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TransactionScreenController extends GenericScreenController{

    @FXML
            private AnchorPane TransactionScreen;

    ErrorWarnings error = new ErrorWarnings();
    TransactionDBHandler tdbh = new TransactionDBHandler();



    private TableView<TransactionProduct> TransactionTable;
    private TableColumn<TransactionProduct, Integer> TransactionID;
    private TableColumn<TransactionProduct, String> ProductNaam;
    private TableColumn<TransactionProduct, String> Vendor;
    private TableColumn<TransactionProduct, String> Description;
    private TableColumn<TransactionProduct, String> Category;



    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button Return;

/*    public void onReturnButtonClicked(ActionEvent actionEvent) throws IOException {
        //Switch scene to Main
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

    }*/

    public void AddNewPurchase(ActionEvent actionEvent) {
    }
}
