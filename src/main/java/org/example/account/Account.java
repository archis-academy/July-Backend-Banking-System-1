package org.example.account;

import java.time.LocalDate;
import org.example.user.User;

public class Account {




    public int accountId;
    public long accountNumber;
    public String accountType;
    public float accountBalance;
    public String accountHolder;
    public LocalDate createdDate;
    public User user;

    public Account() {}

    public Account(int accountId, int accountNumber, String accountType, float accountBalance, String accountHolder, LocalDate createdDate, User user) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
        this.createdDate = createdDate;
        this.user = user;
    }
}
