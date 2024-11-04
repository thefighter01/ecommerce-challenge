package com.ecommerce.products;

public abstract class NonExpirableProduct extends Product {

    public NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public boolean isExpired() {
        return false;
    }
}
