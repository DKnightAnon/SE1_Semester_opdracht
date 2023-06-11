package com.example.se_opdracht.InputCheckers;

import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;
import javafx.scene.control.TextInputDialog;

public class TransactionCheck {

    public static IPurchase PurchaseCheck(IPurchase purchase){

        descriptionCheck(purchase.getProduct());

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


}
