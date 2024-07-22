package org.example.account;

import java.time.LocalDate;
import org.example.user.User;

public class Account {

        public long idCounter = 0;
        public long quantityCounter = 0;
        public long accountId;
        public long accountNumber;
        public long accountQuantity;        
        public String accountType;
        public float accountBalance;
        public String accountHolder;
        public LocalDate CreatedDate;
        public User user;
        public AccountHistory accountHistory;
        
    
        public Account() {
    
        }
    
        public Account(Long accountId, Long accountNumber,Long accountQuantity, String accountType, float accountBalance, String accountHolder, LocalDate CreatedDate) {
            this.accountId = accountId;
            this.accountNumber = accountNumber;
            this.accountQuantity = accountQuantity;
            this.accountType = accountType;
            this.accountBalance = accountBalance;
            this.accountHolder = accountHolder;
            this.CreatedDate = CreatedDate;
            
        }

        public synchronized long getNextId() {
            return idCounter++;
        }
    
        public synchronized long getNextQuantity() {
            return quantityCounter++;
        }



}
