package com.example.se_opdracht.Controllers;

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
        IProduct newProduct = factory.createProduct();
        ICategory tempCat = (ICategory) newProductCategoryList.getSelectionModel().getSelectedItem();
        newProduct.addAll(NewProductTextfield.getText(),"",0,tempCat);
        Boolean emptyTextField = isTextFieldEmpty(NewProductTextfield);
        if (!emptyTextField) {
            DB.addNewProduct(newProduct);
            dataLoad();
            NewProductTextfield.clear();
        }

    }

    private void newProduct(IProduct product){

    }

    public void addNewPurchase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Boolean emptyDate = isDatePickerEmpty(purchaseDatePicker);
        if (emptyDate || purchaseDatePicker.getEditor().getText().isEmpty() || purchasePriceTextfield.getText().isEmpty())
        {error.noCompletePurchaseInfo();}
        else {
            Double price = Double.valueOf(purchasePriceTextfield.getText());
            IProduct selectedProduct = (IProduct) productFormList.getSelectionModel().getSelectedItem();
            IPurchase purchase = factory.createPurchase(selectedProduct, purchaseDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), BigDecimal.valueOf(price), 0);
            DB.addTransaction(purchase);
            refresh();
        }

    }

    public void addNewCategory(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ICategory newCategory = factory.createCategory();
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
        PurchaseID.setCellValueFactory(new PropertyValueFactory<IPurchase, Integer>("PurchaseID"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<IPurchase,String>("Date"));
        PriceColumn.setCellValueFactory(new PropertyValueFactory<IPurchase, BigDecimal>("Price"));
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
            IProduct selectedProduct = (IProduct) productList.getSelectionModel().getSelectedItem();
            fillPurchaseTable(selectedProduct);



        }catch (Exception e) {
            e.printStackTrace();
            error.noItemSelected();
            throw new RuntimeException(e);
        }
        //System.out.println("TestClick!");
    }


}