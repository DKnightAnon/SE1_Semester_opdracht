package com.example.se_opdracht.BudgetHandlers;

public interface IMonthlyBudget {


    public boolean fitsInBudget(double price, int month, double minimalLimitPercentage);

    public boolean fitsInBudget(double price, int month, double minimalLimitPercentage,boolean essential);
}
