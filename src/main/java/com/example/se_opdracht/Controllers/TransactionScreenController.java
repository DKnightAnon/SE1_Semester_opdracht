package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.DescriptionChecker;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionProduct;
import com.example.se_opdracht.ProductMaker.Products.Transaction.TransactionProductCategory;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TransactionScreenController extends GenericScreenController implements Initializable {

//Table variables
    @FXML
        private TableView TransactionTable;
     @FXML
     private TableColumn IDColumn,DateColumn,ItemColumn,DescriptionColumn,CategoryColumn;
//Table variables

    //Purchase(Transaction) form variables
    @FXML
    private DatePicker expenseDate;
    @FXML
    private TextField expenseItem,NewCategoryTextField;
    @FXML
    private TextArea purchaseDescription;
    @FXML
    private ComboBox selectCategory;
    @FXML
    private Button addPurchaseButton;
    //Purchase(Transaction) form variables

    ObservableList<TransactionProductCategory> categoryList;
    ObservableList<TransactionProduct> transactions;
    DescriptionChecker DesCheck = new DescriptionChecker(250);//250 character limit for descriptions

    @FXML
    private AnchorPane TransactionScreen;

    public void AddNewPurchase(ActionEvent actionEvent) {
        Boolean emptyDate;
        if (expenseDate.getValue() != null) {
            emptyDate = false;
        } else {
            emptyDate = true;
        }
        LocalDate productdate = expenseDate.getValue();
        String dateFormat = productdate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));//use MM for months. mm is for minutes of hour

            if (
                      emptyDate
                    || expenseItem.getText().equals("")
                    || DesCheck.checkDescription(Integer.valueOf(purchaseDescription.getText().length())) == 1
                    || selectCategory.getSelectionModel().getSelectedItem().equals(""))
            {
                error.noCompletePurchaseInfo();
            } else {
                try {


                    tdbh.addNewProduct(
                            dateFormat,
                            expenseItem.getText(),
                            purchaseDescription.getText(),
                            selectCategory.getSelectionModel().getSelectedIndex()
                    );
                    TableLoad();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            selectCategory.setValue("Choose a category");



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      //  while (true) {
        TableLoad();

        }

    public void onTableLoadClick(ActionEvent actionEvent) {
        TableLoad();
    }


    public void TableLoad() {
        IDColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, Integer>("ID"));//Purchase_ID in database
        DateColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Date"));//Date in database
        ItemColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Name"));//(product) name in database
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Description")); //(product) description in database
        CategoryColumn.setCellValueFactory(new PropertyValueFactory<TransactionProduct, String>("Category"));//(Expense_Category) name in database
        transactions = TransactionDBHandler.getTransactions();
        TransactionTable.setItems(transactions);
        categoryList = TransactionDBHandler.getCategories();
        selectCategory.setItems(categoryList);


    }


    public void OnAddNewCategoryClick(ActionEvent event) {
        if (NewCategoryTextField.getText().equals(null) || NewCategoryTextField.getText().equals("")){
            error.noCategoryEntered();
        }else {
            TransactionDBHandler.addCategory(NewCategoryTextField.getText());
            NewCategoryTextField.clear();
            TableLoad();
        }
    }

    public void onCloseButtonClick(ActionEvent actionEvent) {
        try {
            error.logoutConfirm(TransactionScreen);
        } catch (Exception e) {
            error.unableToCloseApplication();
        }
    }
}
