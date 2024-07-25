package org.example.account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
            throw new RuntimeException(UserMessage.USER_NOT);
        }
            Account account = new Account();
            account.accountNumber = generateAccountNumber();
            account.accountId = generateNextAccountId();
            account.accountQuantity = accountList.size() + 1;
            account.accountHolder = user.fullName;
            account.accountType = accountType;
            account.accountBalance = 0.0f;
            account.CreatedDate = LocalDate.now();
            accountList.add(account);
            return account;
    }

    public long generateNextAccountId(){
        long maxId = 0;
        for (Account acc : accountList){
            if(acc.accountId > maxId){
                maxId = acc.accountId;
            }
        }
        return  maxId +1;
    }

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
        }
        System.out.println("Account couldn't found!");
        return null;
    }


    public List<Account> listAllAccounts() {
        boolean accountsQuantity = accountList.isEmpty();
        if (accountsQuantity) {
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
}

