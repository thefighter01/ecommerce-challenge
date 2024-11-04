package com.ecommerce.products;

public abstract class Product {
    private final String name;
    private double price;
    private int quantity;

    public Product(String name , double price , int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }

    public void increaseQuantity(int quantity){
        this.quantity += quantity;
    }
    public void decreaseQuantity(int quantity){
        this.quantity -= quantity;
    }
    public boolean isAvailable(){
        return this.quantity > 0;
    }
    public void changePrice(double price){
        this.price = price;
    }


    public abstract boolean isExpired();

    public abstract boolean requiredShipping();





}
