package com.example.se_opdracht.Products;

public class Product {
private String Name;
private String Description;

    public Product(String name, String Description) {
        this.Name = name;
        this.Description = Description;
    }

    public Product(String name){
        this.Name = name;
        this.Description = null;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
