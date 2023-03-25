package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class TransactionScreenController extends GenericScreenController implements Initializable {

    @FXML
            private AnchorPane TransactionScreen;

    ErrorWarnings error = new ErrorWarnings();
    TransactionDBHandler tdbh = new TransactionDBHandler();



//Table variables
    private TableView<TransactionProduct> TransactionTable;
    private TableColumn<TransactionProduct, Integer> ID;
    private TableColumn<TransactionProduct, Date> Date;
    private TableColumn<TransactionProduct, String> Item;
    @FXML
    private TableColumn<TransactionProduct, String> Vendor;
    private TableColumn<TransactionProduct, String> Description;
    private TableColumn<TransactionProduct, String> Category;
//Table variables

    //Purchase(Transaction) form variables
    @FXML
    private DatePicker expenseDate;
    @FXML
    private TextField VendorTextField;
    @FXML
    private TextArea purchaseDescription;
    @FXML
    private ComboBox selectCategory;
    @FXML
    private Button addPurchaseButton;
    //Purchase(Transaction) form variables

    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button Return;

    public void AddNewPurchase(ActionEvent actionEvent) {
        tdbh.addNewProduct();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ID.setCellValueFactory(new PropertyValueFactory<TransactionProduct, Integer>("ID"));
        Date.setCellValueFactory(new PropertyValueFactory<TransactionProduct, Date>("Date"));
        Item.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String >("Item"));
        Vendor.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Vendor"));
        Description.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Description"));
        Category.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Category"));


    }
}
