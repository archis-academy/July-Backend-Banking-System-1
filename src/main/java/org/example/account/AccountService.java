package org.example.account;

import org.example.user.User;
import org.example.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AccountService {
    List<Account> accountList;
    final UserService userService;

    public AccountService(List<Account> accountList, UserService userService) {
        this.accountList = accountList;
        this.userService = userService;
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

    public Account listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (accountsQuantity != false) {
            for (Account account : accountList) {
                return account;

            }
        } else if (accountsQuantity == false) {
            System.out.println("There is no account!");
            return null;
        }
    }
}
    
