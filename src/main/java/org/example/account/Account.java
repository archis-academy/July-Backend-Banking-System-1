package org.example.account;

public class Account {
    public int accountNumber;
    public String accountType;
    public float accountBalance;
    public int accountHolder;

    public Account() {
    }

    public Account(int accountNumber, String accountType, float accountBalance, int accountHolder) {
        accountNumber = accountNumber;
        accountType = accountType;
        accountBalance = accountBalance;
        accountHolder = accountHolder;
    }


}