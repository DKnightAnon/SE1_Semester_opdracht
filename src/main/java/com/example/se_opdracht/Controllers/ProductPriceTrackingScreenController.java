package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineProduct;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ProductPriceTrackingScreenController extends GenericScreenController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        try {
////            dataLoad();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }


//
//    public void addNewProduct(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        String newProductName = NewProductTextfield.getText();
//        int productIndex = newProductCategoryList.getSelectionModel().getSelectedIndex();
//        Boolean emptyTextField = isTextFieldEmpty(NewProductTextfield);
//        if (emptyTextField){
//
//        }else {
//            DB.addNewProduct(newProductName,"Empty",productIndex);
//            dataLoad();
//            NewProductTextfield.clear();
//        }
//
//    }
//
//    public void addNewPurchase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        Boolean emptyDate = isDatePickerEmpty(purchaseDatePicker);
//
//        if (emptyDate ||
//                purchaseDatePicker.getEditor().getText().isEmpty() ||
//                purchasePriceTextfield.getText().isEmpty())
//        {
//            error.noCompletePurchaseInfo();
//        } else {
//            LocalDate productdate = purchaseDatePicker.getValue();
//            String newPurchaseDate = productdate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//            String purchaseValue = purchasePriceTextfield.getText();
//            TimelineProduct selectedProduct = (TimelineProduct) productFormList.getSelectionModel().getSelectedItem();
//            int productID = selectedProduct.getProductID();
//            DB.addNewPurchase(
//                    productID,
//                    newPurchaseDate,
//                    purchaseValue
//            );
//            purchaseDatePicker.getEditor().clear();
//            purchasePriceTextfield.clear();
//            dataLoad();
//        }
//
//    }
//
//    public void addNewCategory(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        String newCategoryname = newCategoryTextfield.getText();
//        DB.addCategory(newCategoryname);
//        newCategoryTextfield.clear();
//        dataLoad();
//    }
//
//    public void dataLoad() throws SQLException, ClassNotFoundException {
//        ObservableList<TimelineProductCategory> categoryList = TimelineDBHandler.getCategories();
//        ObservableList<TimelineProduct> DBProductList = DB.getProducts();
//        ObservableList<TimelineProduct> listViewProductList = FXCollections.observableArrayList();
//        listViewProductList.add(new TimelineProduct("Select a product","You shouldn't see this","You shouldn't see this.",0));
//        for (int i = 0; i<DBProductList.size();i++){
//            listViewProductList.add(DBProductList.get(i));
//        }
//        //Above is a stopgap measure to have index start at 1 instead of 0. I've done something similar in TransactionDBHandler.java and TimelineDBHandler.java
//        productCategoryList.setItems(categoryList);
//        newProductCategoryList.setItems(categoryList);
//        productFormList.setItems(DBProductList);
//        //productList.setItems(listViewProductList);
//    }
//
//    public void ProductCategoryListItemSelected(ActionEvent actionEvent) throws ClassNotFoundException {
//        int productID = productCategoryList.getSelectionModel().getSelectedIndex();
//        ObservableList<TimelineProduct> productlist;
//        productlist = TimelineDBHandler.getProductsListview(productID);
//        productList.setItems(productlist);
//    }
//
//    public void fillPurchaseTable(int productID) throws ClassNotFoundException {
//        ObservableList<TimelineProductPurchase> purchaseHistory = TimelineDBHandler.getPurchases(productID);
//        //The string value here needs to equal the name of the variable in the class you're trying to retireve data from
//        PurchaseID.setCellValueFactory(new PropertyValueFactory<TimelineProductPurchase, Integer>("PurchaseID"));
//        DateColumn.setCellValueFactory(new PropertyValueFactory<TimelineProductPurchase,String>("PurchaseDate"));
//        PriceColumn.setCellValueFactory(new PropertyValueFactory<TimelineProductPurchase, BigDecimal>("PurchasePrice"));
//        PurchaseTable.setItems(purchaseHistory);
//        /*
//        for (int i = 0;i<purchaseHistory.size();i++) {
//            System.out.println(purchaseHistory.get(i).getPurchaseID()
//                    + ", " +
//                    purchaseHistory.get(i).getPurchaseDate()
//                    + ", " +
//                    purchaseHistory.get(i).getPurchasePrice()
//                    + ", " +
//                    purchaseHistory.get(i).getPurchaseProductID()
//            );
//            }
//            System.out.println("No further results");
//            */
//
//    }
//
//
//    public void FillTable(MouseEvent mouseEvent) throws ClassNotFoundException {
//        try {
//            TimelineProduct selectedProduct = (TimelineProduct) productList.getSelectionModel().getSelectedItem();
//            int productID = selectedProduct.getProductID();
//            fillPurchaseTable(productID);
//
//
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            error.noItemSelected();
//            throw new RuntimeException(e);
//        }
//        //System.out.println("TestClick!");
//    }
//
//    public void onCloseButtonClick(ActionEvent actionEvent) {
//        try {
//            error.logoutConfirm(TimelineScreen);
//        } catch (Exception e) {
//            error.unableToCloseApplication();
//        }
//    }
}
