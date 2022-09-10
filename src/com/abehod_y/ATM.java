package com.abehod_y;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ATM {
    public static void main(String[] args) {
        
        Bank swed = initBank("SwedBank");
        User user = loginUser(swed);
        Scanner scanner = new Scanner(System.in);
        showAccounts(user, swed);
//      Menu
        while (true) {
            System.out.println("\nWhat would you like to do? ");
            showMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice == 5) quit();
            Account acc = accountChoice(user,swed);
            if (choice == 1) showTransact(acc);
            else if (choice == 2) withdraw(acc);
            else if (choice == 3) deposit(acc);
            else if (choice == 4) transfer(user, swed, acc);
            else System.out.println("\nSorry, you should enter a number from 1 to 5");
        }
    }

    static Bank initBank(String name){
        //    Bank init
        Bank bank = new Bank(name);
        User yura = bank.addNewUser("Yura", "Vasnetsov", "1234");
        User alex = bank.addNewUser("Alex", "Vasilyev", "4321");
        User michael = bank.addNewUser("Michael", "Smart", "4321");

        bank.addNewAccount(yura);
        bank.addNewAccount(yura);
        bank.addNewAccount(alex);
        System.out.printf("\nWelcome to %s  \n", bank.getName());
        return bank;
    }

    static User loginUser(Bank bank){
        //    User input and access check
        Scanner scanner = new Scanner(System.in);
        User user = null;
        while (true) {
            System.out.print("Enter User ID: ");
            String userUuid = scanner.nextLine();
            System.out.print("Enter User pin: ");
            String userPin = scanner.nextLine();
            user = bank.getUser(userUuid, userPin);
            if (user != null) {
                if (user.getAccounts(bank).size() > 0) {
                    System.out.printf("\nWelcome, %s %s, this is your accounts: \n", user.getName(), user.getSurname());
                    break;
                } else {
                    System.out.println("You don't have any accounts in our bank");
                }
            } else System.out.println("Data is wrong, try again");
        }
        return user;
    }

    static void showMenu(){
        //      Menu init
        Map<Integer, String> menu = new TreeMap<>();
        menu.put(1, "Show account transact");
        menu.put(2, "Withdraw");
        menu.put(3, "Deposit");
        menu.put(4, "Transfer");
        menu.put(5, "Quit");

        for (Integer key : menu.keySet()) {
            System.out.printf("%s) %s\n", key, menu.get(key));
        }
    }

    static void showAccounts(User user, Bank bank){
        //      Displaying accounts
        for (int i = 0; i < user.getAccounts(bank).size(); i++) {
            System.out.println(user.getAccounts(bank).get(i).toString(i+1));
        }
    }

    static Account accountChoice(User user, Bank bank){
        Scanner scanner = new Scanner(System.in);
        Account acc = null;
        if (user.getAccounts(bank).size() > 1) {
            System.out.println("Which account do you want to use?");
            showAccounts(user, bank);
            System.out.print("Enter account number: ");
            int acoountChoice = scanner.nextInt();
            return user.getAccounts(bank).get(acoountChoice-1);
        } else return user.getAccounts(bank).get(0);
    }

    static void showTransact(Account account){
        //              Show transact
        if (account.getTransactions().size() == 0) System.out.println("You have no transactions in this account");
        else {
            for (Transaction transaction : account.getTransactions()){
                System.out.println(transaction.toString());
            }
        }
    }

    static void withdraw(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money do you want to withdraw? ");
        double amount = scanner.nextDouble();
        System.out.println(account.withdrow(amount));
    }
    static void deposit(Account account){
        Scanner scanner = new Scanner(System.in);
        System.out.print("How much money you want to deposit? ");
        double amount = scanner.nextDouble();
        System.out.println(account.deposit(amount));
    }

    static void transfer(User user, Bank bank, Account account){
        Scanner scanner = new Scanner(System.in);
        if (user.getAccounts(bank).size() == 1) {
            System.out.println("You cannot transfer money, cause you have only one account");
        } else {
            System.out.println("For what account do you want transfer money to?");
            for (int i = 0; i < user.getAccounts(bank).size(); i++) {
                if (!user.getAccounts(bank).get(i).equals(account)) {
                    System.out.println(user.getAccounts(bank).get(i).toString(i + 1));
                }
            }
            System.out.print("Enter choice: ");
            int toAcc = scanner.nextInt();
            System.out.print("How much money do you want to transfer?  ");
            double transferAmount = scanner.nextDouble();
            System.out.println(account.transfer(transferAmount, user.getAccounts(bank).get(toAcc - 1)));
        }
    }

    static void quit(){
        System.exit(0);
    }
}
