package com.atm;

import java.util.ArrayList;

public class Account {
   private  int accountId;
   private String name;
   private int pin;
   private  double balance;
   private ArrayList<Transaction> transactions;

   public Account(int accountId, String name, int pin, double balance){

       this.accountId = accountId;
       this.name = name;
       this.pin = pin;
       this.balance = balance;
       this.transactions = new ArrayList<>();

   }
   public int getAccountId(){
       return accountId;
   }
    public String getName(){
        return name;
    }
    public int getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
        }

    public void withdraw(double amount) {
        balance = balance - amount;

        Transaction transaction = new Transaction("Withdrawal", amount, "Cash withdrawn");

        addTransaction(transaction);
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        balance = balance + amount;

        Transaction transaction =
                new Transaction("Deposit", amount, "Cash deposited");

        addTransaction(transaction);
    }

    public void transfer(Account receiver, double amount) {
        balance = balance - amount;

        Transaction senderTransaction =
                new Transaction("Transfer", amount,
                        "Transferred to Account " + receiver.getAccountId());

        addTransaction(senderTransaction);

        receiver.balance = receiver.balance + amount;

        Transaction receiverTransaction =
                new Transaction("Transfer Received", amount,
                        "Received from Account " + this.accountId);

        receiver.addTransaction(receiverTransaction);    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void showTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(
                    transaction.getType() + " | ₹" +
                            transaction.getAmount() + " | " +
                            transaction.getDescription()
            );
        }
    }
    }


