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

    public int generateAccountNumber() {
        int accountNumber;
        Random random = new Random();
        accountNumber = random.nextInt(1000);
        return accountNumber;
    }

    public void createAccount(int userId, String accountType) {
        User user = userService.getUserById(userId);
        if (user != null) {
            Account account = new Account();
            account.accountNumber = generateAccountNumber();
            account.accountType = accountType;
            account.accountBalance = 0.0f;
            account.accountHolder = user.userId;
            accountList.add(account);
            succesTransaction("Create account");
        } else {
            System.out.println("Not found Id!");
        }
    }

    public void deleteAccount(int accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            accountList.remove(account);
            succesTransaction("Delete account");
        } else {
            System.out.println("Not found account number!");
        }
    }

    public void updateAccount(int accountNumber, String accountType, float accountBalance, int accountHolder) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            account.accountType = accountType;
            account.accountBalance = accountBalance;
            account.accountHolder = accountHolder;
            succesTransaction("Update account");
        } else {
            System.out.println("Not found account number!");
        }
    }

    public void listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (accountsQuantity != false) {
            for (Account account : accountList) {
                System.out.println(account);

            }
        } else if (accountsQuantity == false) {
            System.out.println("There is no account!");
        }
    }
}
