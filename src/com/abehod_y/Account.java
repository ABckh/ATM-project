package com.abehod_y;


import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private User user;
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account(String accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public User getUser() {
        return this.user;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String toString(int id) {
        return id + ")" +
                " accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance;
    }
}
