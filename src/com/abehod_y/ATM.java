package com.abehod_y;


import java.util.Random;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        //      Bank init
        Bank swed = new Bank("SwedBank");
        User yura = swed.addNewUser("Yura", "Abykhodau", "1234");
        User alex = swed.addNewUser("Alex", "Vasilyev", "4321");
        swed.addNewAccount(yura);
        swed.addNewAccount(yura);
        swed.addNewAccount(alex);

        System.out.printf("Welcome to %s  \n", swed.getName());

//      User input and access check
        Scanner scanner = new Scanner(System.in);
        boolean access = false;
        User user = null;
        while (access == false) {
            System.out.println("Enter User ID: ");
            String userUuid = scanner.nextLine();
            System.out.println("Enter User pin: ");
            String userPin = scanner.nextLine();
            user = swed.getUser(userUuid, userPin);
            if (user != null) {
                break;
            }
            System.out.println("Data is wrong, try again");
        }
//
//        for (Account account : swed.getAccounts(user)) {
//            System.out.println(account.toString());
//        }

        for (int i = 0; i < swed.getAccounts(user).size(); i++) {
            System.out.println(swed.getAccounts(user).get(i).toString(i+1));
        }
    }
}
