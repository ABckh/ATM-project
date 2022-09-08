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
        System.out.printf("The user %s %s with id %s was created", this.name, this.surname, this.uuid);
    }


}
