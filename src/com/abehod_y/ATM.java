package com.abehod_y;


import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class ATM {
    public static void main(String[] args) {
        
//      Bank init
        Bank swed = new Bank("SwedBank");
        User yura = swed.addNewUser("Yura", "Abykhodau", "1234");
        User alex = swed.addNewUser("Alex", "Vasilyev", "4321");
        User michael = swed.addNewUser("Michael", "Smart", "4321");

        Account yurysAccount1 = swed.addNewAccount(yura);
        Account yurysAccount2 =  swed.addNewAccount(yura);
        Account alexsAccount = swed.addNewAccount(alex);

        System.out.printf("\nWelcome to %s  \n", swed.getName());

//      Menu init
        Map<Integer, String> menu = new TreeMap<>();
        menu.put(1, "Show account transact");
        menu.put(2, "Withdraw");
        menu.put(3, "Deposit");
        menu.put(4, "Transfer");
        menu.put(5, "Quit");

//      User input and access check
        Scanner scanner = new Scanner(System.in);
        User user = null;
        while (true) {
            System.out.print("Enter User ID: ");
            String userUuid = scanner.nextLine();
            System.out.print("Enter User pin: ");
            String userPin = scanner.nextLine();
            user = swed.getUser(userUuid, userPin);
            if (user != null) {
                if (user.getAccounts(swed).size() > 0) {
                    System.out.printf("\nWelcome, %s %s, this is your accounts: \n", user.getName(), user.getSurname());
                    break;
                } else {
                    System.out.println("You don't have any accounts in our bank");
                }
            } else System.out.println("Data is wrong, try again");
        }


//      Displaying accounts
        for (int i = 0; i < user.getAccounts(swed).size(); i++) {
            System.out.println(user.getAccounts(swed).get(i).toString(i+1));
        }

//      Menu
        while (true) {

            System.out.println("\nWhat would you like to do? ");
            for (Integer key : menu.keySet()) {
                System.out.printf("%s) %s\n", key, menu.get(key));
            }

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            Account acc = null;
            if (user.getAccounts(swed).size() > 1) {
                System.out.println("Which account do you want to use?");
                for (int i = 0; i < user.getAccounts(swed).size(); i++) {
                    System.out.println(user.getAccounts(swed).get(i).toString(i+1));
                }
                System.out.print("Enter account number: ");
                int acoountChoice = scanner.nextInt();
                acc = user.getAccounts(swed).get(acoountChoice-1);
            } else acc = user.getAccounts(swed).get(0);
            if (choice == 1) {
//              Show transact
                if (acc.getTransactions().size() == 0) System.out.println("You have no transactions in this account");
                else {
                    for (Transaction transaction : acc.getTransactions()){
                        System.out.println(transaction.toString());
                    }
                }
            } else if (choice == 2) {
//              Withdraw

            } else if (choice == 3) {
//              Deposit

            } else if (choice == 4) {
//              Transfer

            } else if (choice == 5) {
//              Quit
                System.exit(0);
            } else System.out.println("\nSorry, you should enter a number from 1 to 5");

        }
    }
}
