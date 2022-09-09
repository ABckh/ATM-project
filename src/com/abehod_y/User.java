package com.abehod_y;


import java.util.ArrayList;

public class User {
    private String name;
    private String surname;
    private String uuid;
    private String pin;
    private ArrayList<Account> accounts;

    public User(String name, String surname, String pin, Bank theBank) {
        this.name = name;
        this.surname = surname;
        this.pin = pin;
        this.uuid = theBank.getNewUserUuid();
        this.accounts = new ArrayList<>();
        System.out.printf("The user %s %s with id %s was created \n", this.name, this.surname, this.uuid);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUuid() {
        return uuid;
    }

    public String getPin() {
        return pin;
    }

    public ArrayList<Account> getAccounts(Bank theBank) {
        for (Account account : theBank.getAccounts()) {
            if (account.getUser().equals(this) && !this.accounts.contains(account)) {
                this.accounts.add(account);
            }
        }
        return accounts;
    }

}
