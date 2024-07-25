package org.example.account;

import java.time.LocalDate;
import org.example.user.User;

public class Account {
        public long accountId;
        public long accountQuantity;
        public long accountNumber;
        public String accountType;
        public float accountBalance;
        public String accountHolder;
        public LocalDate CreatedDate;
        public User user;
        public AccountHistory accountHistory;
        
    
        public Account() {
    
        }
    
        public Account(long accountId,long accountQuantity, long accountNumber, String accountType, float accountBalance, String accountHolder, LocalDate CreatedDate) {
            this.accountId = accountId;
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            this.accountBalance = accountBalance;
            this.accountHolder = accountHolder;
            this.CreatedDate = CreatedDate;
            
        }



}
