package com.example.se_opdracht.ChartHandlers.Transaction;

import java.math.BigDecimal;

public class CategoryValue {

    private Double value;
    private String name;

    public CategoryValue(BigDecimal value, String name) {
        this.value = value.doubleValue();
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value.doubleValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
