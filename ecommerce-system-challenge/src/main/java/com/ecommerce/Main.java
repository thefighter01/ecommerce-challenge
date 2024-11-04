package com.ecommerce;


import com.ecommerce.cart.Cart;
import com.ecommerce.customer.Customer;
import com.ecommerce.products.Biscuits;
import com.ecommerce.products.Mobile;
import com.ecommerce.products.MobileScratchCard;
import com.ecommerce.products.TV;
import com.ecommerce.service.CartService;
import com.ecommerce.service.CheckoutService;
import com.ecommerce.service.ShippingService;

import java.util.Date;

public class Main {
    public static final long EXPIRYDATE = 86_400_000;


    public static void main(String[] args) {

        Date expiryDate = new Date(System.currentTimeMillis()+EXPIRYDATE);

        TV tv = new TV("HD" , 1000 , 5, 20);

        Mobile mobile = new Mobile("nokia" , 100 , 3 , 5 );

        Biscuits biscuits = new Biscuits("biscuits" , 5 , 10 , expiryDate , 2);

        MobileScratchCard mobileScratchCard = new MobileScratchCard("mobileCard" , 1 , 20);


        Customer customer = new Customer("mahmoud" , 10000);
        Cart cart = new Cart();



        CartService cartService = new CartService();

        ShippingService shippingService = new ShippingService();
        CheckoutService checkoutService = new CheckoutService(cartService , shippingService);

        try {
            for (int i = 0; i < 2; ++i) {
                cartService.addItemToCart(cart, tv, 1);
                cartService.addItemToCart(cart, mobile, 1);
                cartService.addItemToCart(cart, mobileScratchCard, 5);
                cartService.addItemToCart(cart, biscuits, 3);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkoutService.checkout(customer , cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}