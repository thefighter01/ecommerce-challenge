package com.ecommerce.service;

import com.ecommerce.products.Shippable;

import java.util.List;

public class ShippingService {

    public void shipItems(List<Shippable> items){

        double totalWeight = 0;
        System.out.println("shipping items are ");
        for (Shippable item : items) {
            totalWeight += item.getWeight();
            System.out.println("item Name is " + item.getName() + "  and  item Weight is " + item.getWeight());
        }

        System.out.println("Total weight is " + totalWeight);
    }
}
