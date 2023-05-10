package com.example.se_opdracht.BudgetHandlers;

import java.util.ArrayList;

public class MonthlyBudget implements IMonthlyBudget {
    private double budget;
    private ArrayList<Double> currentBudget = new ArrayList<>();
    private int Month;

    public MonthlyBudget(double budget){
        this.budget = budget;
        for (int i = 0;i<12;i++){currentBudget.add(budget);} //This will be replaced by something that retrieves specified budgets from the database based on a given year.


    }



    public boolean fitsInBudget(double price, int month, double minimalLimitPercentage) {
        boolean fitsInBudget = false;
        int selectedMonth = month-1;
        double BudgetBeforePurchase = currentBudget.get(selectedMonth);
        double Budget = currentBudget.get(selectedMonth) - price;
        Double lowerlimit = budget/minimalLimitPercentage;

        if (Budget<0 || Budget<= lowerlimit){
            fitsInBudget = false;
        }
        else if (Budget>0 && Budget>lowerlimit){
            fitsInBudget = true;
            currentBudget.set(selectedMonth,Budget);
        }

        System.out.println("-----------------------------------");
        System.out.println("Budget before purchase : "+BudgetBeforePurchase);
        System.out.println("Budget after purchase: "+Budget);
        System.out.println("Lower limit : "+lowerlimit);
        System.out.println("Purchase price = "+price);
        System.out.println("Month = "+selectedMonth);





        return fitsInBudget;
    }

    public boolean fitsInBudget(double price, int month, double minimalLimitPercentage, boolean essential ){
//        boolean fitsInBudget = true;
        int selectedMonth = month-1;
        double BudgetBeforePurchase = currentBudget.get(selectedMonth);
        double Budget = currentBudget.get(selectedMonth) - price;
        double lowerlimit = budget/minimalLimitPercentage;

//        if (Budget<0 || Budget<= lowerlimit){
//            fitsInBudget = false;
//        }
//        else if (Budget>0 && Budget>lowerlimit){
//            fitsInBudget = true;
//        }else if (Budget>0  && essential){
//            fitsInBudget = true;
//        }



//        System.out.println("-----------------------------------");
//        System.out.println("Budget before purchase : "+BudgetBeforePurchase);
//        System.out.println("Budget after purchase: "+Budget);
//        System.out.println("Lower limit : "+lowerlimit);
//        System.out.println("Purchase price = "+price);
//        System.out.println("Month = "+selectedMonth);



        return !(Budget<0 || Budget<lowerlimit) || (Budget>0 && essential) || (Budget>0 && Budget>lowerlimit) ;



    }


}



