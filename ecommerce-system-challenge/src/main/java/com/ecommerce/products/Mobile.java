package com.ecommerce.products;

public class Mobile extends NonExpirableProduct implements Shippable{

    private final double weight;
    public Mobile(String name , double price , int quantity , double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public boolean requiredShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}