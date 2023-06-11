package com.example.se_opdracht.InputCheckers;

import com.example.se_opdracht.ErrorMessages.ErrorWarnings;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.scene.control.TextInputDialog;

public class TransactionCheck {

    public static IPurchase PurchaseCheck(IPurchase purchase){

        descriptionCheck(purchase.getProduct());
        categoryCheck(purchase.getCategory());

        return purchase;
    }

    private static void descriptionCheck(IProduct product){
        if (product.getDescription().length()>250){
            String subject;
            TextInputDialog td = new TextInputDialog();
            td.setHeaderText("Description too long. Please keep it under 250 characters.");
            td.showAndWait();
            subject = td.getEditor().getText();
            product.setDescription(subject);
        }
    }

    /**
     * This method is used to check if the Category object in the purchase is valid.
     * <p></p>
     * Right now this method only prints to the console. In the future, this is meant ot generate a popup allowing you to select a valid category.
     * @param category The supplied ICategory to be checked.
     * @Author Anthony Delgado
     */
    private static void categoryCheck(ICategory category){
        if (category == null){
            System.out.println("Category Object in Purchase is null!");
        }
    }

}
