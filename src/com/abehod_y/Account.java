package com.abehod_y;


import java.util.ArrayList;

public class Account {
    private String name;
    private User user;
    private ArrayList<Transaction> transactions;

    public Account(String name, User user) {
        this.name = name;
        this.user = user;
        this.transactions = new ArrayList<>();
    }
    //    public void addNewTransaction()

}
