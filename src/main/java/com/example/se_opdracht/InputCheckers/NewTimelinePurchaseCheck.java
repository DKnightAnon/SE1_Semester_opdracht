package com.example.se_opdracht.InputCheckers;

import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.Data;
import com.example.se_opdracht.ErrorMessages.InputCorrectors;
import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;


import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class NewTimelinePurchaseCheck {



   public ArrayList<ICategory> AvailableCategories = new ArrayList<>();
    public ArrayList<IProduct> AvailableProducts = new ArrayList<>();
    public ArrayList<IPurchase> AvailablePurchases = new ArrayList<>();

    TimelineDBHandler db = new TimelineDBHandler();

    public NewTimelinePurchaseCheck() throws ClassNotFoundException, SQLException {
        AvailableProducts = (ArrayList<IProduct>) db.getProducts();
        AvailableCategories = (ArrayList<ICategory>) db.getCategories();
//        AvailablePurchases = db.getPurchasesAsArrayList();
    }

    private boolean validFormat(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Data.dateformat);
        try{
            formatter.parse(date);
        }catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

    private boolean categoryExists(ICategory category){

       boolean exists = false;
       int contains = 0;

       for (int i = 0;i<AvailableCategories.size();i++){
           if (AvailableCategories.get(i).getCategoryName().equals(category.getCategoryName())){
               contains = 1;
           }
       }
       if (contains == 1){
           exists = true;
       }

       return exists;

    }

    private boolean productExists(IProduct product){
        boolean exists = false;
        int contains = 0;
        for (int i = 0;i<AvailableProducts.size();i++){
            if (AvailableProducts.get(i).getName().equals(product.getName())){
                contains++;
            }
        }

        if (contains>0){
            exists = true;
        }
        return exists;
    }
    private boolean productExistInCategory(ICategory category,IProduct product){

        if (category.getCategoryName().equals(product.getCategory())){
            return true;
        }else{
            return false;
        }

    }

    public IPurchase inputCheck(IPurchase purchase){
        DateTimeFormatter formatter;
        int Code = 0;
        //Code 0 means every input is valid
        //Code 1 should be used to throw an error because price is negative
        //Code 2 should be used to throw an error because product is free
        //Code 3 should be used because either selected category or product is not related to the other/doesn't exist
        //Code 4 should be used to throw an error because date is not of proper format or because one or more input fields are empty

        double price = purchase.getPrice().doubleValue();
        if (price<0 || price ==0){
            purchase.setPrice(InputCorrectors.CorrectPrice());
        }
        if (!categoryExists(purchase.getCategory()) || !productExists(purchase.getProduct()) || !productExistInCategory(purchase.getCategory(), purchase.getProduct())){
            Code = 3;
        }
        if (!validFormat(purchase.getDate())){
            Code = 4;
        }
        return purchase;
    }

}
