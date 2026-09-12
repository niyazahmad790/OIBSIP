package com.atm;

public class ATM {

        private Bank bank;

        public ATM(Bank bank){
            this.bank= bank;
        }

            public Account login(int accountId, int pin) {

                Account account = bank.findAccount(accountId);

                if (account != null && account.getPin() == pin) {
                    return account;
                }

                return null;
            }
        }

