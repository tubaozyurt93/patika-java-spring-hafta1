package com.patika;

import java.util.List;

public class Customer {
    private String name;
    private String email;
    private int age;
    private List<Order> orders;

    public Customer(String name, String email,int age, List<Order> orders) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.orders = orders;
    }

    // Getter ve Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public double getTotalSpent() {
        return orders.stream()
                .mapToDouble(order -> order.getInvoice().getTotalAmount())
                .sum();
    }
}

