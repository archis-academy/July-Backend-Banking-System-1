package org.example.account;

import org.example.user.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import org.example.user.User;


public class AccountService {

    ArrayList<Account> accountList = new ArrayList<>();
    final UserService userService;


    public AccountService(UserService userService) {
        this.userService = userService;
    }


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
        }
        return null;
    }

}
