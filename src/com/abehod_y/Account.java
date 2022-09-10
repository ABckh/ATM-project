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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void addBalance(double amount){
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String withdrow(double amount){
        double total = this.balance - amount;
        if (total < 0) {
            return "Insufficient funds";
        } else {
            this.balance = total;
            this.transactions.add(new Transaction(amount, "Withdraw", this.balance));
            return "Successful, updated balance is " + this.balance;
        }
    }

    public String deposit(double amount){
        this.balance += amount;
        this.transactions.add(new Transaction(amount, "Deposit", this.balance));
        return "Successful, updated balance is " + this.balance;
    }

    public String transfer(double amount, Account inAccount){
        double total = this.balance - amount;
        if (total < 0){
            return "Insufficient funds";
        } else {
            this.balance = total;
            inAccount.addBalance(amount);
            this.transactions.add(new Transaction(amount, inAccount,
                    "Transfer to " + inAccount.getAccountNumber(),
                    this.balance));
            inAccount.transactions.add(new Transaction(amount, this, "Transfer from " + this.getAccountNumber(),
                    this.balance));
            return "Succesful, updated balance is " + this.balance;
        }
    }


    public String toString(int id) {
        return id + ")" +
                " accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance;
    }
}
