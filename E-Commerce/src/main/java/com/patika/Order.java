package com.patika;

import java.util.List;

public class Order {
    private List<Product> products;
    private Invoice invoice;

    public Order(List<Product> products, Invoice invoice) {
        this.products = products;
        this.invoice = invoice;
    }

    // Getter ve Setter methods
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
