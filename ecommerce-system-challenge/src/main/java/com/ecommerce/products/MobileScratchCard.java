package com.ecommerce.products;


public class MobileScratchCard extends NonExpirableProduct {


    public MobileScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean requiredShipping() {
        return false;
    }
}
