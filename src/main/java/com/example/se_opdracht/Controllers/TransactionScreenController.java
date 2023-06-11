package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.ChartHandlers.ChartHandler;
import com.example.se_opdracht.ChartHandlers.Transaction.TransactionChartHandler;
import com.example.se_opdracht.DBHandlers.ProductDBHandler;
import com.example.se_opdracht.DBHandlers.TransactionDBHandler;
import com.example.se_opdracht.Data;
import com.example.se_opdracht.InputCheckers.TransactionCheck;
import com.example.se_opdracht.ProductMaker.AbstractFactory;
import com.example.se_opdracht.ProductMaker.ProductFactory;
import com.example.se_opdracht.ProductMaker.Products.ICategory;


import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class TransactionScreenController implements Initializable {

//Table variables
    @FXML
        private TableView TransactionTable;
     @FXML
     private TableColumn IDColumn,DateColumn,ItemColumn,DescriptionColumn,CategoryColumn,PriceColumn;
//Table variables

    //Purchase(Transaction) form variables
    @FXML
    private DatePicker expenseDate;
    @FXML
    private TextField expenseItem,NewCategoryTextField,priceField;
    @FXML
    private TextArea purchaseDescription;
    @FXML
    private ComboBox selectCategory;
    @FXML
    private Button addPurchaseButton;
    //Purchase(Transaction) form variables
    private Chart CategoryChart;
    @FXML
    private VBox chartContainer;
    ObservableList<ICategory> categoryList;
    ObservableList<IPurchase> transactions;
    ProductDBHandler db = new TransactionDBHandler();
    AbstractFactory factory = new ProductFactory();
    ChartHandler chartHandler = new TransactionChartHandler();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            CategoryChart = chartHandler.initialize();
            chartContainer.getChildren().add(CategoryChart);
            TableLoad();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void AddNewPurchase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Double price = Double.valueOf(priceField.getText());
        db.addNewTransaction(TransactionCheck.PurchaseCheck(
                factory.createPurchase(
                        factory.createProduct(expenseItem.getText(),purchaseDescription.getText(),0,
                                (ICategory) selectCategory.getSelectionModel().getSelectedItem()),
                        expenseDate.getValue().format(DateTimeFormatter.ofPattern(Data.dateformat)), BigDecimal.valueOf(price),0 )));
            selectCategory.setValue("Choose a category");
            TableLoad();
    }



    public void onTableLoadClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        TableLoad();
    }


    public void TableLoad() throws SQLException, ClassNotFoundException {
        IDColumn.setCellValueFactory(new PropertyValueFactory<IPurchase, Integer>("PurchaseID"));//Purchase_ID in database
        DateColumn.setCellValueFactory(new PropertyValueFactory<IPurchase, String>("Date"));//Date in database
        ItemColumn.setCellValueFactory(new PropertyValueFactory<IProduct, String>("Product"));//(product) name in database
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<IProduct, String>("Description")); //(product) description in database
        CategoryColumn.setCellValueFactory(new PropertyValueFactory<IProduct, String>("Category"));//(Expense_Category) name in database
        PriceColumn.setCellValueFactory(new PropertyValueFactory<IPurchase, BigDecimal>("Price"));

        transactions = db.getTransactions();
        TransactionTable.setItems(transactions);
        categoryList = db.getCategories();
        selectCategory.setItems(categoryList);
        CategoryChart = chartHandler.initialize();
        updateChart();

    }

    private void updateChart() throws SQLException, ClassNotFoundException {
        chartContainer.getChildren().remove(chartContainer.getChildren().size()-1);
        CategoryChart = chartHandler.update();
        chartContainer.getChildren().add(CategoryChart);
    }

    public void OnAddNewCategoryClick(ActionEvent event) throws SQLException, ClassNotFoundException {
            db.addNewCategory(factory.createCategory(NewCategoryTextField.getText(),0));
            NewCategoryTextField.clear();
            TableLoad();

    }


}
