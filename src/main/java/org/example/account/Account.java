package org.example.account;

import java.time.LocalDate;
import org.example.user.User;

public class Account {
        public int AccountId;
        public int AccountNumber;
        public String AccountType;
        public float AccountBalance;
        public String AccountHolder;
        public LocalDate CreatedDate;
        public User user;
        public AccountHistory accountHistory;
        
    
        public Account() {
    
        }
    
        public Account(int accountId, int accountNumber, String accountType, float accountBalance, String accountHolder, LocalDate CreatedDate) {
            this.AccountId = accountId;
            this.AccountNumber = accountNumber;
            this.AccountType = accountType;
            this.AccountBalance = accountBalance;
            this.AccountHolder = accountHolder;
            this.CreatedDate = CreatedDate;
            
        }

}
