package com.abehod_y;


import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
//      Bank init
        Bank swed = new Bank("SwedBank");
        User user = swed.addNewUser("Yura", "Abykhodau", "1234");
        User user2 = swed.addNewUser("Alex", "Vasilyev", "4321");
        System.out.printf("Welcome to %s  \n", swed.getName());

//      User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User ID: ");
        String userUuid = scanner.nextLine();
        System.out.println("Enter User pin: ");
        String userPin = scanner.nextLine();

//      Acces check
        boolean access = swed.getAccess(userUuid, userPin);


    }
}
