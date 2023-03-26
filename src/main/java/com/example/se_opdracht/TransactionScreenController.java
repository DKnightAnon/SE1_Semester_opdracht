package com.example.se_opdracht;

import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.Products.TransactionProduct;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class TransactionScreenController extends GenericScreenController implements Initializable {

    @FXML
            private AnchorPane TransactionScreen;

    ErrorWarnings error = new ErrorWarnings();
    TransactionDBHandler tdbh = new TransactionDBHandler();



//Table variables
    @FXML
    private TableView<TransactionProduct> TransactionTable;
    @FXML
    private TableColumn<TransactionProduct, Integer> IDColumn;
    @FXML
    private TableColumn<TransactionProduct, String> DateColumn;
    @FXML
    private TableColumn<TransactionProduct, String> ItemColumn;
    @FXML
    private TableColumn<TransactionProduct, String> DescriptionColumn;
    @FXML
    private TableColumn<TransactionProduct, String> CategoryColumn;
//Table variables

    //Purchase(Transaction) form variables
    @FXML
    private DatePicker expenseDate;
    @FXML
    private TextField expenseItem;
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
    ObservableList<String> categoryList;
    ObservableList<TransactionProduct> transactions;

    public void AddNewPurchase(ActionEvent actionEvent) {
        LocalDate productdate = expenseDate.getValue();
        String date = productdate.toString();
        tdbh.addNewProduct(
                date,
                expenseItem.getText(),
                purchaseDescription.getText(),
                selectCategory.getSelectionModel().getSelectedItem().toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  while (true) {

        }

    public void onTableLoadClick(ActionEvent event) {
        IDColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, Integer>("IDColumn"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Date"));
        ItemColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Item"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Description"));
        CategoryColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Category"));
        transactions = TransactionDBHandler.getTransactions();
        TransactionTable.setItems(transactions);
        categoryList = TransactionDBHandler.getCategories();
        selectCategory.setItems(categoryList);
    }
    //   }
}
