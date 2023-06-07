package com.example.se_opdracht.ProductMaker.Products;

public interface IProduct {

    public String getName();
    public void setName(String name);

    public String getDescription();
    public void setDescription(String description);

    public int getProductID();
    public void setProductID(int ID);

    public ICategory getCategory();
    public void setCategory(ICategory category);

    public void addAll(String name,String description,int productID, ICategory category);

    public String toString();

}
