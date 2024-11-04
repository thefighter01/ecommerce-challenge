package com.ecommerce.service;

import com.ecommerce.cart.Cart;
import com.ecommerce.cart.CartItem;
import com.ecommerce.products.Product;
import com.ecommerce.products.Shippable;

import java.util.List;
import java.util.stream.Collectors;

public class CartService {

    public void addItemToCart(Cart cart , Product product , int quantity) throws Exception {
        // TODO handle the exceptions

        if (product.isExpired()) throw new Exception(product.getName() +" is expired");
        if (!product.isAvailable()) throw new Exception(product.getName() +" is out of stock");

        if (product.getQuantity() < quantity) throw new Exception("the stock contain only " + product.getQuantity() + " units of " + product.getName());


        cart.addItem(new CartItem(product , quantity));
        product.decreaseQuantity(quantity);

    }

    public double getSubTotal(Cart cart) {
        return cart.getItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<Shippable> getShippableItems(Cart cart){

        return cart.getItems().stream().map(CartItem::getProduct).filter(Product::requiredShipping).map(item -> (Shippable) item).collect(Collectors.toList());
    }
}
