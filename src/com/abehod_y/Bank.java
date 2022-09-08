package com.abehod_y;


import java.util.ArrayList;
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

    public boolean getAccess(String uuid, String pin) {
       for (User user : this.users) {
            if (user.getUuid().equals(uuid) && user.getPin().equals(pin)) {
                return true;
            }
        }
        return false;
    }

    public String getNewUserUuid() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }

    public void addNewAccount(String name, User user){
        Account account = new Account(name, user);
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", users=" + users +
                ", accounts=" + accounts +
                '}';
    }
}
