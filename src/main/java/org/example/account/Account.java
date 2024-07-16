package org.example.account;

import java.time.LocalDate;
import org.example.user.User;

public class Account {
    
        public int AccountNumber;
        public String AccountType;
        public float AccountBalance;
        public int AccountHolder;
        public LocalDate CreatedDate;
        public User user;
        public AccountHistory accountHistory;
    
        public Account() {
    
        }
    
        public Account(int accountNumber, String accountType, float accountBalance, int accountHolder) {
            this.AccountNumber = accountNumber;
            this.AccountType = accountType;
            this.AccountBalance = accountBalance;
            this.AccountHolder = accountHolder;
        }
    

}
