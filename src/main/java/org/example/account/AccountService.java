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
        this.accountList = new ArrayList<>();
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

    public String deleteAccount(int accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            accountList.remove(account);
            return "Delete transaction successfully:";
        } else {
            return "Not found account number!";
        }
    }


}