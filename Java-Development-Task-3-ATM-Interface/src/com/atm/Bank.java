package com.atm;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public Account findAccount(int accountId) {

        for (Account account : accounts) {

            if (account.getAccountId() == accountId) {
                return account;
            }

        }

        return null;
    }

}
