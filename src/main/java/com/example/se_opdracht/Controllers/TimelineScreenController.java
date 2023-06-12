package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.ErrorMessages.*;
import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.ProductMaker.AbstractFactory;
import com.example.se_opdracht.ProductMaker.ProductFactory;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static com.example.se_opdracht.InputCheckers.InputCheck.*;

public class TimelineScreenController implements Initializable {
    //Variables

    @FXML
    private TableView PurchaseTable;
    @FXML
    private TableColumn DateColumn,PriceColumn,PurchaseID;
    @FXML
    private ComboBox productCategoryList,productFormList,newProductCategoryList;
    @FXML
    private Button addNewProductButton,addNewPurchaseButton,addNewCategoryButton;
    @FXML
    private TextField NewProductTextfield,purchasePriceTextfield,newCategoryTextfield;
    @FXML
    private ListView productList;
    @FXML
    private DatePicker purchaseDatePicker;

    TimelineDBHandler DB = new TimelineDBHandler();

    @FXML
    private AnchorPane TimelineScreen;

    AbstractFactory factory = new ProductFactory();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dataLoad();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public void addNewProduct(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (!isTextFieldEmpty(NewProductTextfield)) {
            DB.addNewProduct(factory.createProduct(NewProductTextfield.getText(),"",0, (ICategory) newProductCategoryList.getSelectionModel().getSelectedItem()));
            dataLoad();
            NewProductTextfield.clear();
        }

    }

    private void newProduct(IProduct product){

    }

    public void addNewPurchase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if ( isDatePickerEmpty(purchaseDatePicker)|| purchaseDatePicker.getEditor().getText().isEmpty() || purchasePriceTextfield.getText().isEmpty())
        {ErrorWarnings.noCompletePurchaseInfo();}
        else {
            Double price = Double.valueOf(purchasePriceTextfield.getText());
            DB.addNewTransaction(factory.createPurchase((IProduct) productFormList.getSelectionModel().getSelectedItem(), purchaseDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), BigDecimal.valueOf(price), 0));
            refresh();
        }

    }

    public void addNewCategory(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DB.addNewCategory(factory.createCategory(newCategoryTextfield.getText(),0));
        refresh();
    }

    private void dataLoad() throws SQLException, ClassNotFoundException {
        ObservableList<ICategory> categoryList = DB.getCategories();
        ObservableList<IProduct> DBProductList = DB.getProducts();
        ObservableList<IProduct> listViewProductList = FXCollections.observableArrayList();
        for (int i = 0; i<DBProductList.size();i++){listViewProductList.add(DBProductList.get(i));}
        productCategoryList.setItems(categoryList);
        newProductCategoryList.setItems(categoryList);
        productFormList.setItems(DBProductList);
    }

    public void ProductCategoryListItemSelected(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        ObservableList<IProduct> productlist = DB.getProducts((ICategory) productCategoryList.getSelectionModel().getSelectedItem());
        productList.setItems(productlist);
        //dataLoad();
    }

    public void fillPurchaseTable(IProduct product) throws ClassNotFoundException {
        ObservableList<IPurchase> purchaseHistory = DB.getTransactions(product);
        //The string value here needs to equal the name of the variable in the class you're trying to retireve data from
        PurchaseID.setCellValueFactory(new PropertyValueFactory<IPurchase, Integer>("PurchaseID"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<IPurchase,String>("Date"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<IPurchase, BigDecimal>("Price"));
        PurchaseTable.setItems(purchaseHistory);


    }

    private void refresh() throws SQLException, ClassNotFoundException {
        purchaseDatePicker.getEditor().clear();
        newCategoryTextfield.clear();
        purchasePriceTextfield.clear();
        fillPurchaseTable((IProduct) productList.getSelectionModel().getSelectedItem());
        dataLoad();
    }


    public void FillTable(MouseEvent mouseEvent) throws ClassNotFoundException {
        try {
            if (!productList.getSelectionModel().isEmpty()) {
                IProduct selectedProduct = (IProduct) productList.getSelectionModel().getSelectedItem();
                fillPurchaseTable(selectedProduct);
            }



        }catch (Exception e) {
            e.printStackTrace();
            ErrorWarnings.noItemSelected();
            throw new RuntimeException(e);
        }
        //System.out.println("TestClick!");
    }


}