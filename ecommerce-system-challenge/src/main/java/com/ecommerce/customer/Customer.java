package com.ecommerce.customer;

public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public void decreaseBalance(double balance){
        this.balance = balance;
    }

}
