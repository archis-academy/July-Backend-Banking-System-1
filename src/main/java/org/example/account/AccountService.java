package org.example.account;

import org.example.user.User;
import org.example.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountService {
    List<Account> accountList;

    public AccountService() {
        this.accountList = new ArrayList<>();
    }

    public Account getAccountByAccountNumber(int accountNumber) {
        for (Account account : accountList) {
            if (account.AccountNumber == accountNumber) {
                return account;
            }
        }
        System.out.println("Account couldn't found!");
        return null;
    }

    public long generateAccountNumber() {
        long accountNumber;
        Random random = new Random();
        accountNumber = random.nextLong(999999999);
        return accountNumber;
    }
}