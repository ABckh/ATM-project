package com.abehod_y;


import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public User addNewUser(String name, String surname, String pin) {
        User newUser = new User(name, surname, pin, this);
        this.users.add(newUser);
        return newUser;
    }

    public User getUser(String uuid, String pin) {
       for (User user : this.users) {
            if (user.getUuid().equals(uuid) && user.getPin().equals(pin)) {
                return user;
            }
        }
        return null;
    }

    public String getNewUserUuid() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }

    public Account addNewAccount(User user){
        Random random = new Random();
        Account account = new Account(
                random.ints().iterator().next().toString(),
                user);
        this.accounts.add(account);
        return account;
    }

    public ArrayList<Account> getAccounts(User user) {
        ArrayList<Account> userAccounts = new ArrayList<>();
        for (Account account : accounts){
            if (account.getUser().equals(user)) userAccounts.add(account);
        }
        return userAccounts;
    }
}

