package com.example.se_opdracht.Controllers;

import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.ProductMaker.AbstractFactory;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.ProductMaker.Products.Timeline.TimelinePurchase;
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

public class ProductsScreenController extends GenericScreenController implements Initializable {
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
        IProduct newProduct = AbstractFactory.Timeline.createProduct();
        ICategory tempCat = (ICategory) newProductCategoryList.getSelectionModel().getSelectedItem();
        newProduct.addAll(NewProductTextfield.getText(),"",0,tempCat);
        Boolean emptyTextField = isTextFieldEmpty(NewProductTextfield);
        if (!emptyTextField) {
            DB.addNewProduct(newProduct);
            dataLoad();
            NewProductTextfield.clear();
        }

    }

    public void addNewPurchase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Boolean emptyDate = isDatePickerEmpty(purchaseDatePicker);
        if (emptyDate || purchaseDatePicker.getEditor().getText().isEmpty() || purchasePriceTextfield.getText().isEmpty())
        {error.noCompletePurchaseInfo();}
        else {
            String price = String.valueOf(purchasePriceTextfield.getText());
            IProduct selectedProduct = (IProduct) productFormList.getSelectionModel().getSelectedItem();
            IPurchase purchase = AbstractFactory.Timeline.createPurchase(selectedProduct,
                    purchaseDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                    BigDecimal.valueOf(Long.parseLong(price)));
            DB.addTransaction(purchase);
            refresh();
        }

    }

    public void addNewCategory(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ICategory newCategory = AbstractFactory.Timeline.createCategory();
        newCategory.setCategoryName(newCategoryTextfield.getText());
        DB.addNewCategory(newCategory);
        refresh();
    }

    public void dataLoad() throws SQLException, ClassNotFoundException {
        ObservableList<ICategory> categoryList = DB.getCategories();
        ObservableList<IProduct> DBProductList = DB.getProducts();
        ObservableList<IProduct> listViewProductList = FXCollections.observableArrayList();
        for (int i = 0; i<DBProductList.size();i++){listViewProductList.add(DBProductList.get(i));}
        productCategoryList.setItems(categoryList);
        newProductCategoryList.setItems(categoryList);
        productFormList.setItems(DBProductList);
        //productList.setItems(listViewProductList);
    }

    public void ProductCategoryListItemSelected(ActionEvent actionEvent) throws ClassNotFoundException {
        int productID = productCategoryList.getSelectionModel().getSelectedIndex();
        ObservableList<IProduct> productlist = DB.getProducts();
        productList.setItems(productlist);
    }

    public void fillPurchaseTable(IProduct product) throws ClassNotFoundException {
        ObservableList<IPurchase> purchaseHistory = DB.getTransactions(product);
        //The string value here needs to equal the name of the variable in the class you're trying to retireve data from
        PurchaseID.setCellValueFactory(new PropertyValueFactory<TimelinePurchase, Integer>("PurchaseID"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<TimelinePurchase,String>("PurchaseDate"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<TimelinePurchase, BigDecimal>("PurchasePrice"));
        PurchaseTable.setItems(purchaseHistory);


    }

    private void refresh() throws SQLException, ClassNotFoundException {
        purchaseDatePicker.getEditor().clear();
        newCategoryTextfield.clear();
        purchasePriceTextfield.clear();
        dataLoad();
    }


    public void FillTable(MouseEvent mouseEvent) throws ClassNotFoundException {
        try {
            TimelineProduct selectedProduct = (TimelineProduct) productList.getSelectionModel().getSelectedItem();
            fillPurchaseTable(selectedProduct);



        }catch (Exception e) {
            e.printStackTrace();
            error.noItemSelected();
            throw new RuntimeException(e);
        }
        //System.out.println("TestClick!");
    }


}