package com.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Bank bank = new Bank();

        Account account1 = new Account(1001, "Captain", 1234, 10000);
        Account account2 = new Account(1002, "Rahul", 5678, 8000);
        Account account3 = new Account(1003, "Roshan", 5578, 4000);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);

        ATM atm = new ATM(bank);

        System.out.print("Enter Account ID: ");
        int accountId = scanner.nextInt();

        boolean loginSuccessful = false;
        Account loggedInAccount = null;

        for (int attempt = 1; attempt <= 3; attempt++) {

            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();

            loggedInAccount = atm.login(accountId, enteredPin);

            if (loggedInAccount != null) {

                System.out.println("Login Successful!");
                System.out.println("Welcome " + loggedInAccount.getName());

                loginSuccessful = true;
                break;

            } else {

                System.out.println("Invalid Account ID or PIN");
            }
        }

        if (!loginSuccessful) {

            System.out.println("Access Denied");
            System.out.println("Please contact your bank.");

            scanner.close();
            return;
        }

        while (true) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n===== TRANSACTION HISTORY =====");
                    loggedInAccount.showTransactionHistory();

                    break;

                case 2:

                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();

                    if (amount <= 0) {

                        System.out.println("Invalid withdrawal amount");

                    } else if (loggedInAccount.getBalance() >= amount) {

                        System.out.println("Withdraw Allowed");

                        loggedInAccount.withdraw(amount);

                        System.out.println("Withdrawal Successful!");
                        System.out.println(
                                "Remaining Balance: ₹"
                                        + loggedInAccount.getBalance()
                        );

                    } else {

                        System.out.println("Insufficient Funds");
                    }

                    break;

                case 3:

                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    if (depositAmount > 0) {

                        loggedInAccount.deposit(depositAmount);

                        System.out.println("Deposit Successful!");
                        System.out.println(
                                "Updated Balance: ₹"
                                        + loggedInAccount.getBalance()
                        );

                    } else {

                        System.out.println("Invalid deposit amount");
                    }

                    break;

                case 4:
                    System.out.print("Enter receiver Account ID: ");
                    int receiverId = scanner.nextInt();

                    Account receiverAccount = bank.findAccount(receiverId);

                    if (receiverAccount == null) {
                        System.out.println("Receiver Account not found");
                        break;
                    }

                    if (receiverAccount.getAccountId() == loggedInAccount.getAccountId()) {
                        System.out.println("Cannot transfer money to the same account");
                        break;
                    }

                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();

                    if (transferAmount <= 0) {
                        System.out.println("Invalid transfer amount");
                    } else if (loggedInAccount.getBalance() < transferAmount) {
                        System.out.println("Insufficient Funds");
                    } else {
                        loggedInAccount.transfer(receiverAccount, transferAmount);

                        System.out.println("Transfer Successful!");
                        System.out.println("Transferred Amount: " + transferAmount);
                        System.out.println("Remaining Balance: " + loggedInAccount.getBalance());
                    }

                    break;






                case 5:

                    System.out.println("Thank you for using ATM.");

                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid choice");
            }
        }
    }
}