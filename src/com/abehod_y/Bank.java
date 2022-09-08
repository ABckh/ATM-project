package com.abehod_y;


import java.util.ArrayList;
import java.util.UUID;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public Bank(String name ) {
        this.name = name;

    }

    public void addNewUser(String name, String surname, String pin) {
        User newUser = new User(name, surname, pin, this);
    }

    public String getNewUserUuid(){
        return UUID.randomUUID().toString().replace("-","").substring(0,8);
    }

}
