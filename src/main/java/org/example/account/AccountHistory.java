
package org.example.account;

import java.time.LocalDate;

public class AccountHistory {

    public String transactionType;
    public boolean isSuccess;
    public LocalDate date;
    public float amount;
    public String location;
    public Account account;

    AccountHistory() {

    }

    AccountHistory(String transactionType, boolean isSuccess, LocalDate date, float amount, String location) {
        this.transactionType = transactionType;
        this.isSuccess = isSuccess;
        this.date = date;
        this.amount = amount;
        this.location = location;
    }
}