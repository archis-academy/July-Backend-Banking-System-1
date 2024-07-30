package org.example.account;

import java.time.LocalDate;
import java.util.List;

import org.example.user.User;

public class Account {
        public int AccountId;
        public int AccountNumber;
        public String AccountType;
        public float AccountBalance;
        public String AccountHolder;
        public LocalDate CreatedDate;
        public double totalCredit;
        public User user;
        List <AccountHistory> accountHistory;

        
    
        public Account() {
    
        }
    
        public Account(int accountId, int accountNumber, String accountType, float accountBalance, String accountHolder, LocalDate CreatedDate,double totalCredit) {
            this.AccountId = accountId;
            this.AccountNumber = accountNumber;
            this.AccountType = accountType;
            this.AccountBalance = accountBalance;
            this.AccountHolder = accountHolder;
            this.CreatedDate = CreatedDate;
            this.totalCredit=totalCredit;

        }



}
