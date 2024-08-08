package com.patika;

import java.util.Date;

public class Invoice {
    private String invoiceNumber;
    private Date date;
    private double totalAmount;

    public Invoice(String invoiceNumber, Date date, double totalAmount) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    // Getter ve Setter methods
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

