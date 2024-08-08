package com.patika;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Ürünler
        Product product1 = new Product("Laptop", "Electronics", 1200.00, 10);
        Product product2 = new Product("Headphones", "Electronics", 150.00, 25);
        Product product3 = new Product("Mouse", "Electronics", 50.00, 30);

        // Faturalar
        Invoice invoice1 = new Invoice("INV12345", new Date(), 1350.00);
        Invoice invoice2 = new Invoice("INV12346", new Date(), 100.00);
        Invoice invoice3 = new Invoice("INV12347", new Date(), 2000.00);

        // Siparişler
        Order order1 = new Order(List.of(product1, product2), invoice1);
        Order order2 = new Order(List.of(product3), invoice2);
        Order order3 = new Order(List.of(product1, product3), invoice3);

        // Müşteriler
        Customer customer1 = new Customer("Cem", "cem@example.com", 28, List.of(order1, order2));
        Customer customer2 = new Customer("Ali", "ali@example.com", 35, List.of(order2));
        Customer customer3 = new Customer("Cem", "cem2@example.com", 24, List.of(order3));


        List<Customer> customers = List.of(customer1, customer2, customer3);

        // 1. Sistemdeki bütün müşteri sayısını bulma
        int customerCount = customers.size();
        System.out.println("Sistemdeki müşteri sayısı: " + customerCount);

        // 2. İsmi Cem olan müşterilerin aldıkları ürün sayısını bulma
        int cemProductCount = customers.stream()
                .filter(customer -> customer.getName().equals("Cem"))
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toList())
                .size();
        System.out.println("İsmi Cem olan müşterilerin aldıkları ürün sayısı: " + cemProductCount);

        // 3. İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarını hesaplama
        double cemTotalSpent = customers.stream()
                .filter(customer -> customer.getName().equals("Cem") && customer.getAge() < 30 && customer.getAge() > 25)
                .mapToDouble(Customer::getTotalSpent)
                .sum();
        System.out.println("İsmi Cem olup yaşı 30’dan küçük 25’ten büyük müşterilerin toplam alışveriş tutarı: " + cemTotalSpent);

        // 4. Sistemdeki 1500 TL üzerindeki faturaları listeleme
        List<Invoice> highValueInvoices = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .map(Order::getInvoice)
                .filter(invoice -> invoice.getTotalAmount() > 1500)
                .collect(Collectors.toList());
        System.out.println("1500 TL üzerindeki faturalar:");
        highValueInvoices.forEach(invoice ->
                System.out.println("Fatura Numarası: " + invoice.getInvoiceNumber() + ", Tutar: " + invoice.getTotalAmount())
        );
    }
}