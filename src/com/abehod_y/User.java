package com.abehod_y;

import java.util.ArrayList;
import java.util.UUID;

public class User {

    private String name;
    private String surname;
    private String userId;
    private ArrayList<Account> accounts;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.userId = UUID.randomUUID().toString().replace("-","").substring(0,8);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", userId='" + userId + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
