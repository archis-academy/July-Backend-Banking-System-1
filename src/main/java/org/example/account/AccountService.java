package org.example.account;
<<<<<<< Updated upstream

import org.example.user.UserService;

import java.time.LocalDate;
=======
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.Random;
import org.example.message.UserMessage;
import org.example.user.User;
import org.example.user.UserService;

import java.time.LocalDate;


import org.example.user.User;


public class AccountService {

    ArrayList<Account> accountList = new ArrayList<>();
    final UserService userService;


    public AccountService(UserService userService) {
        this.userService = userService;
    }


<<<<<<< Updated upstream
    public Account createAccount(int userId, String accountType) {
        User user = userService.getUserById(userId);
        if (user != null) {
            Account account = new Account();
            account.accountNumber = generateAccountNumber();
            account.accountId = accountList.size() + 1;
            account.accountQuantity = accountList.size() + 1;
            account.accountHolder = user.fullName;
            account.accountType = accountType;
            account.accountBalance = 0.0f;
            account.CreatedDate = LocalDate.now();
            accountList.add(account);
            return account;
=======

    public long generateAccountNumber() {
        long accountNumber;
        Random random = new Random();
        accountNumber = 10000000 + random.nextLong(89999999);
        return accountNumber;
    }


    public Account getAccountByAccountNumber(int accountNumber) {
        for (Account account : accountList) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
>>>>>>> Stashed changes
        }
        return null;
    }
    public Account createAccount(int userId, String accountType) {
        User user = UserService.getUserById(userId);  // UserService sınıfının statik metodu
        if (user == null) {
            throw new RuntimeException(UserMessage.USER_NOT);  // UserMessage sınıfı tanımlı olmalıdır
        }
        Account account = new Account();
        account.accountNumber = generateAccountNumber();
        account.accountId = accountList.size() + 1;
        account.accountHolder = user.fullName;
        account.accountType = accountType;
        account.accountBalance = 0.0f;
        account.createdDate = LocalDate.now();
        account.user = user;  // Account ile kullanıcı ilişkilendirilir
        accountList.add(account);
        return account;
    }

<<<<<<< Updated upstream
=======

    public List<Account> listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (accountsQuantity != false) {
            return accountList;
        }
        System.out.println("There is no account!");
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


    public Float checkBalanceFunctionality(int accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            return account.accountBalance;
        } else {
            return null;
        }
    }
>>>>>>> Stashed changes
}
