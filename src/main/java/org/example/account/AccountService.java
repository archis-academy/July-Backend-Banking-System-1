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

    public long getRandom() {
        Random random = new Random();
        long accountNumber = random.nextLong(9999999);
        return accountNumber;

    }

    public Account createAccount(int userId, String accountType) {

        Account account = new Account();
        User user = userService.getUserById(userId);
        if(user != null){
        account.accountNumber = getRandom();
        account.accountId = account.getNextId();
        account.accountQuantity = account.getNextQuantity();
        account.accountType = accountType;
        account.CreatedDate = LocalDate.now();

        }

        return account;

    }

}
