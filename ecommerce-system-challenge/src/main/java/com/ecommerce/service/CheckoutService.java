package com.ecommerce.service;

import com.ecommerce.cart.Cart;
import com.ecommerce.cart.CartItem;
import com.ecommerce.customer.Customer;
import com.ecommerce.products.Shippable;

import java.util.List;

public class CheckoutService  {
    private final double SHIPPING_FEES_PER_KG = 12.5;

    private final CartService cartService;
    private final ShippingService shippingService;
    public CheckoutService(CartService cartService, ShippingService shippingService) {
        this.cartService = cartService;
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer , Cart cart) throws Exception {
        if (cart.isEmpty()) throw new Exception("Cart is Empty");

        double subTotal = cartService.getSubTotal(cart);
        List<Shippable> shippableList = cartService.getShippableItems(cart);
        double shippingFees = shippableList.stream().mapToDouble(Shippable::getWeight).sum() * SHIPPING_FEES_PER_KG;
        double total = shippingFees + subTotal;

        if (customer.getBalance() < total) {
            throw new Exception("Customer balance is less than the total balance");
        }
        customer.decreaseBalance(total);

        System.out.println("** checkout complete **");
        for (CartItem item : cart.getItems()){
            System.out.println("item name is " + item.getProduct().getName() + " item quantity is " + item.getQuantity() + " item totalPrice is " + item.getTotalPrice());
        }

        System.out.println("subtotal is " + subTotal);
        System.out.println("shippingFees is " + shippingFees);
        System.out.println("total is " + total);
        System.out.println("Customer balance is " + customer.getBalance());

        shippingService.shipItems(shippableList);

    }
}
