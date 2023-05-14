package com.example.se_opdracht.InputCheckers;

import com.example.se_opdracht.DBHandlers.TimelineDBHandler;
import com.example.se_opdracht.Products.Timeline.TimelineProduct;
import com.example.se_opdracht.Products.Timeline.TimelineProductCategory;
import com.example.se_opdracht.Products.Timeline.TimelineProductPurchase;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class NewTimelinePurchaseCheck {

    private String format = "dd/MM/YYYY";

   public ArrayList<TimelineProductCategory> AvailableCategories = new ArrayList<>();
    public ArrayList<TimelineProduct> AvailableProducts = new ArrayList<>();
    public ArrayList<TimelineProductPurchase> AvailablePurchases = new ArrayList<>();

    public NewTimelinePurchaseCheck() throws ClassNotFoundException {
        AvailableProducts = TimelineDBHandler.getProductsAsArrayList();
        AvailableCategories = TimelineDBHandler.getCategoriesAsArrayList();
        AvailablePurchases = TimelineDBHandler.getPurchasesAsArrayList();
    }

    private boolean isFormatValid(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            formatter.parse(date);
        }catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

    private boolean doesCategoryExist(TimelineProductCategory category){

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

    private boolean doesProductExist(TimelineProduct product){
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
    private boolean doesProductExistInCategory(TimelineProductCategory category,TimelineProduct product){

        if (category.getCategoryName().equals(product.getCategory())){
            return true;
        }else{
            return false;
        }

    }

    public int inputCheck(String Price,TimelineProductCategory category, TimelineProduct product,String date){
        DateTimeFormatter formatter;
        int Code = 0;
        //Code 0 means every input is valid
        //Code 1 should be used to throw an error because price is negative
        //Code 2 should be used to throw an error because product is free
        //Code 3 should be used because either selected category or product is not related to the other/doesn't exist
        //Code 4 should be used to throw an error because date is not of proper format or because one or more input fields are empty

        double price = Double.parseDouble(Price);
        if (price<0){
            Code = 1;
        }else if (price == 0){
            Code = 2;
        }
        if (!doesCategoryExist(category) || !doesProductExist(product) || !doesProductExistInCategory(category,product)){
            Code = 3;
        }
        if (!isFormatValid(date)){
            Code = 4;
        }
        return Code;
    }

//    public void checkContents(){
//        for (int i = 0;i<AvailableCategories.size();i++){
//            System.out.println(AvailableCategories.get(i).getCategoryID()+","+AvailableCategories.get(i).getCategoryName());
//        }
//        System.out.println("---------------------------");
//        for (int i = 0;i<AvailableProducts.size();i++){
//            System.out.println(AvailableProducts.get(i).getProductID()+","+
//                    AvailableProducts.get(i).getCategory()+","+
//                    AvailableProducts.get(i).getName()+","+
//                    AvailableProducts.get(i).getDescription()
//            );
//        }
//        System.out.println("---------------------------");
//        for (int i = 0;i<AvailablePurchases.size();i++){
//            System.out.println(AvailablePurchases.get(i).getPurchaseID()+","+
//                    AvailablePurchases.get(i).getPurchaseProductID()+","+
//                    AvailablePurchases.get(i).getPurchaseDate()+","+
//                    AvailablePurchases.get(i).getPurchasePrice()
//                    );
//        }
//        System.out.println("---------------------------");
//        System.out.println();
//
//    }
//
//
//    public static void main(String[] args) throws ClassNotFoundException {
//        var check = new NewTimelinePurchaseCheck();
//        //int input = check.inputCheck("30.80", new TimelineProduct("testing","testingdesc","testcategory",1));
//        //System.out.println(input);
//        check.checkContents();
//        //System.out.println(check.doesCategoryExist(check.AvailableCategories.get(0)));
//        System.out.println(check.doesProductExist(new TimelineProduct("TestTimelineProduct","TestTimelineCategory",1)));
//    }
}
