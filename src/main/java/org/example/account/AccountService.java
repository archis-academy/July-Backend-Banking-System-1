
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

    public void succesTransaction(String temp) {
        System.out.println(temp + " transaction successfully: ");
    }


    public Account getAccountByAccountNumber(int accountNumber) {
        for (Account account : accountList) {
            if (account.accountNumber == accountNumber) {
                succesTransaction("Get account by account number");
                return account;
            }
        }
        System.out.println("Account couldn't found!");
        return null;
    }

    public long generateAccountNumber() {
        Random random = new Random();
        long accountNumber = random.nextLong(9999999999999999);
        return accountNumber;
    }
}
