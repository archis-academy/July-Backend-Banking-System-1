package org.example.account;

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
            boolean confirm = confirmBeforeDeletingAccount();
            if (confirm == true) {
                accountList.remove(account);
                return "Delete transaction successfully:";
            } else {
                return "Deletion has been canceled!";
            }
        } else {
            return "Not found account number!";
        }
    }


    public boolean confirmBeforeDeletingAccount() {
        Scanner scan = new Scanner(System.in);
        confirmMessage();
        boolean confirm = scan.nextBoolean();
        return confirm;
    }


    public String confirmMessage() {
        return String.format("Are you sure you want to delete the account? %nType true to delete or Type false to cancel");
    }


    public Float checkBalanceFunctionality(int accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        if (account != null) {
            return account.AccountBalance;
        } else {
            return null;
        }
    }

    static boolean checkUsingIsDigitMethod(String input) {
        boolean temp = true;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                temp = true;
            } else {
                temp = false;
                return temp;
            }
        }
        return temp;
    }


}


