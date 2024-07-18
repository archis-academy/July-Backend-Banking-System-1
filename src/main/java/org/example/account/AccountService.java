package org.example.account;

import org.example.user.UserService;
import java.time.LocalDate;
import java.util.ArrayList;
import org.example.user.User;


public class AccountService {

    ArrayList<Account> accountList = new ArrayList<>();
    final UserService userService;


    public AccountService(UserService userService) {
        this.userService = userService;
    }

    public void createAccount(int userId, String accountType) {
        Account account = new Account();
        account.AccountNumber = 0;
        account.AccountType = accountType;
        account.CreatedDate = LocalDate.now();

        User user = userService.getUserById(userId);
        if (user != null) {
            account.user = user;
            accountList.add(account);
            System.out.println("User account has been created successfully");
        }

    }

}
