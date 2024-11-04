package com.ecommerce.products;

public class TV extends NonExpirableProduct implements Shippable {

    private final double weight;

    public TV(String name, double price, int quantity , double weight) {
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
