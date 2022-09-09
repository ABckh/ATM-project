package com.abehod_y;

import java.util.Date;

public class Transaction {

    private double amount;
    private Account inAccount;
    private Date date;
    private String description;
    private double total;

    public Transaction(double amount, String description, double total){
        this.amount = amount;
        this.description = description;
        this.date = new Date();
        this.total = total;
    }

    public Transaction(double amount, Account inAccount, String description) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.date = new Date();
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n Transaction from " + date +
                ", amount is " + amount +
                ", description: '" + description +
                "', total is " + total + '\n';
    }

}
