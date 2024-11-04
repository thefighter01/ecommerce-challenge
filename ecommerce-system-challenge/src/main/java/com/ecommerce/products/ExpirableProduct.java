package com.ecommerce.products;

import java.util.Date;

public abstract class ExpirableProduct extends Product {
    private final Date expiryDate;

    public ExpirableProduct(String name , double price , int quantity, Date expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return new Date().after(expiryDate);
    }
}
