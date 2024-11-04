package com.ecommerce.products;

import java.util.Date;

public class Biscuits extends ExpirableProduct implements Shippable{

    private final double weight;

    public Biscuits(String name, double price , int quantity , Date expirayDate , double weight) {
        super(name , price , quantity , expirayDate);
        this.weight = weight;

    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean requiredShipping() {
        return true;
    }
}
