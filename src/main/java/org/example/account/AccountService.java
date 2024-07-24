package org.example.account;

import org.example.user.User;
import org.example.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AccountService {
    List<Account> accountList;

    public AccountService() {
        this.accountList = new ArrayList<>();
    }


    public long generateAccountNumber() {
        long accountNumber;
        Random random = new Random();
        accountNumber = 10000000 + random.nextLong(89999999);
        return accountNumber;
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
            String confirm = confirmBeforeDeletingAccount();
            if (confirm.equals("YES")) {
                accountList.remove(account);
                return "Delete transaction successfully:";
            } else {
                return "Deletion has been canceled!";
            }
        } else {
            return "Not found account number!";
        }
    }

    public String confirmBeforeDeletingAccount() {
        Scanner scan = new Scanner(System.in);
        confirmMessage();
        String confirm = scan.nextLine();
        return confirm;
    }


    public String confirmMessage() {
        return "Are you sure you want to delete the account?";
    }
}
    
  



