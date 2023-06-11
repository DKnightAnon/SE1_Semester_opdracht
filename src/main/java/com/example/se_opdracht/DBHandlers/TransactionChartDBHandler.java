package com.example.se_opdracht.DBHandlers;

import com.example.se_opdracht.ChartHandlers.Transaction.CategoryValue;
import com.example.se_opdracht.ProductMaker.Products.Category;
import com.example.se_opdracht.ProductMaker.Products.Product;
import com.example.se_opdracht.ProductMaker.Products.Purchase;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionChartDBHandler extends TransactionDBHandler {

    public ArrayList<CategoryValue> getCategoryValue() {
        String query = "SELECT Name, sum(purchaseprice) as categoryValue FROM purchase JOIN expense_category ON purchase.Category = expense_category.Category_ID group by category;";
        ArrayList list = new ArrayList<CategoryValue>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CategoryValue(rs.getBigDecimal("categoryValue"),rs.getString("Name")));
            }
            connection.close();

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
