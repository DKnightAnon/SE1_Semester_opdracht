package com.example.se_opdracht.ProductMaker.Products;

public interface ICategory {
    public String getCategoryName();
    public void setCategoryName(String name);

    public int getCategoryID();
    public void setCategoryID(int id);

    public void addAll(String name, int id);

    public String toString();


}
