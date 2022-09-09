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

        swed.addNewAccount(yura);
        swed.addNewAccount(yura);
        swed.addNewAccount(alex);

        System.out.printf("\nWelcome to %s  \n", swed.getName());

//           Menu init
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
                break;
            }
            System.out.println("Data is wrong, try again");
        }
        if (user.getAccounts(swed).size() > 0) {
            System.out.printf("\nWelcome, %s %s, this is your accounts: \n", user.getName(), user.getSurname());
        } else {
            System.out.println("You don't have any accounts in our bank");
            System.exit(0);
        }

//      Displaying accounts an menu 
        int id = 1;
        for (Account account : user.getAccounts(swed)) {
            System.out.println(account.toString(id));
            id += 1;
        }
        System.out.println("\nWhat would you like to do? ");

        for (Integer key : menu.keySet()){
            System.out.printf("%s) %s\n", key, menu.get(key));
        }

        System.out.print("Enter your choice: ");
        Integer choice = scanner.nextInt();

    }
}
