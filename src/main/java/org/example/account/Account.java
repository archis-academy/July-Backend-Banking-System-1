package org.example.account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.user.User;

public class Account {
    public long accountId;
    public long accountNumber;
    public String accountType;
    public float accountBalance;
    public String accountHolder;
    public LocalDate CreatedDate;
    public double totalCredit;
    public User user;
    List<AccountHistory> accountHistory;


    public Account() {
    this.accountHistory=new ArrayList<>();
    }


    public Account(long accountId, long accountNumber, String accountType, float accountBalance, String accountHolder, LocalDate createdDate, double totalCredit) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
        CreatedDate = createdDate;
        this.totalCredit = totalCredit;
    }
}
