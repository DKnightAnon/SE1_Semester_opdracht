package com.example.se_opdracht.ProductMaker;

import com.example.se_opdracht.ProductMaker.Products.ICategory;
import com.example.se_opdracht.ProductMaker.Products.IProduct;
import com.example.se_opdracht.ProductMaker.Products.IPurchase;

import java.math.BigDecimal;

/**
 * Base class for ProductFactories.
 * <p></p>
 * Handles creating {@link com.example.se_opdracht.ProductMaker.Products.Product}.
 * @Author Anthony Delgado
 */

public abstract class AbstractFactory {

    /**
     * Creates a category with the supplied name and ID.
     * @param categoryName Name of the category as listed in the database.
     * @param CategoryID ID of the category as listed in the database.
     * @return New Category object.
     * @Author Anthony Delgado
     */
    public abstract ICategory createCategory(String categoryName, int CategoryID);

    /**
     * Creates a new Product with the supplied parameters.
     * @param name
     * @param description
     * @param productID
     * @param category
     * @return
     */
    public abstract IProduct createProduct(String name, String description, int productID, ICategory category);

    /**
     * Creates a new Purchase with the supplied parameters.
     * @param product Object representing the bought product.
     * @param date The date on which the product was bought as listed in database.
     * @param price The price for which the product was bought on the specified date.
     * @param purchaseID ID of the purchase as listed in database.
     * @return New Purchase object
     * @Author Anthony Delgado
     * @see com.example.se_opdracht.ProductMaker.Products.Product
     */
    public abstract IPurchase createPurchase(IProduct product, String date, BigDecimal price, int purchaseID);

}
